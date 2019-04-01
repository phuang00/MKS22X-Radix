@SuppressWarnings({"unchecked", "rawtypes"})


public class Radix{
  public static void radixsort(int[] data){
    MyLinkedList<Integer>[] buckets = new MyLinkedList[20];
    int max = 0;
    for (int i = 0; i < data.length; i++){
      if (Math.abs(data[i]) > Math.pow(10, max)){
        max = (int)Math.ceil(Math.log10(Math.abs(data[i])));
      }
    }
    //System.out.println(max);
  }

  public static void main(String[] args) {
    int[] data = new int[] {-32,1,5,7,3,2};
    radixsort(data);
  }
}
