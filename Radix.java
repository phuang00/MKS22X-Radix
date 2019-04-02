import java.util.*;
@SuppressWarnings({"unchecked", "rawtypes"})

public class Radix{
  public static void radixsort(int[] data){
    MyLinkedList<Integer>[] buckets = new MyLinkedList[20];
    // create an array of MyLinkedList
    for (int i = 0; i < 20; i++){
      buckets[i] = new MyLinkedList<>();
      // initialize each MyLinkedList in buckets
    }
    MyLinkedList<Integer> dat = new MyLinkedList<>();
    // create a MyLinkedList to be used to temp store data
    int max = 0;
    // max # of digits is set to zero
    for (int i = 0; i < data.length; i++){
      // loop through the data array
      if (Math.abs(data[i]) > Math.pow(10, max)){
        // if number of digits is greater than the previously stored max
        max = (int)Math.ceil(Math.log10(Math.abs(data[i])));
        // max is updated
      }
      dat.add(data[i]);
      // add every value to the MyLinkedList without changing order
    }
    //System.out.println(max);
    int place = 0;
    while (place < max){
      while (dat.size() > 0){
        int value = dat.removeFront();
        int digit = (int)(value / Math.pow(10, place)) % 10;
        if (digit < 0){
          buckets[9 + digit].add(value);
        }
        else{
          buckets[10 + digit].add(value);
        }
      }
      for (int i = 1; i < 20; i++){
        buckets[0].extend(buckets[i]);
        //System.out.println(buckets[0]);
      }
      dat = buckets[0];
      //System.out.println("buckets[0]" + dat);
      for (int i = 0; i < 20; i++){
        buckets[i] = new MyLinkedList<>();
      }
      place++;
    }
    //System.out.println(dat);
    for (int i = 0; i < data.length; i++){
      data[i] = dat.removeFront();
    }
  }

  public static void main(String[]args){
    System.out.println("Size\t\tMax Value\tquick/builtin ratio ");
    int[]MAX_LIST = {1000000000,500,10};
    for(int MAX : MAX_LIST){
      for(int size = 31250; size < 2000001; size*=2){
        long qtime=0;
        long btime=0;
        //average of 5 sorts.
        for(int trial = 0 ; trial <=5; trial++){
          int []data1 = new int[size];
          int []data2 = new int[size];
          for(int i = 0; i < data1.length; i++){
            data1[i] = (int)(Math.random()*MAX);
            data2[i] = data1[i];
          }
          long t1,t2;
          t1 = System.currentTimeMillis();
          Radix.radixsort(data2);
          t2 = System.currentTimeMillis();
          qtime += t2 - t1;
          t1 = System.currentTimeMillis();
          Arrays.sort(data1);
          t2 = System.currentTimeMillis();
          btime+= t2 - t1;
          if(!Arrays.equals(data1,data2)){
            System.out.println("FAIL TO SORT!");
            System.exit(0);
          }
        }
        System.out.println(size +"\t\t"+MAX+"\t"+1.0*qtime/btime);
      }
      System.out.println();
    }
  }}
