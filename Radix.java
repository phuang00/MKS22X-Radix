@SuppressWarnings({"unchecked", "rawtypes"})


public class Radix{
  public static void radixsort(int[] data){
    MyLinkedList<Integer>[] buckets = new MyLinkedList[20];
    for (int i = 0; i < 20; i++){
      buckets[i] = new MyLinkedList<>();
    }
    MyLinkedList<Integer> dat = new MyLinkedList<>();
    int max = 0;
    for (int i = 0; i < data.length; i++){
      if (Math.abs(data[i]) > Math.pow(10, max)){
        max = (int)Math.ceil(Math.log10(Math.abs(data[i])));
      }
      dat.add(data[i]);
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
        System.out.println(buckets[0]);
      }
      dat = buckets[0];
      System.out.println("buckets[0]" + dat);
      for (int i = 0; i < 20; i++){
        buckets[i] = new MyLinkedList<>();
      }
      place++;
    }
    System.out.println(dat);
  }

  public static void main(String[] args) {
    int[] data = new int[] {-32,1,5,7,3,2};
    radixsort(data);
  }
}
