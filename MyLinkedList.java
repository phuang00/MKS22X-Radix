public class MyLinkedList<E>{
  private int length;
  private Node start,end;

  public MyLinkedList(){}

  public String toString(){
    String ans = "[";
    // String ans equals open brackets
    Node temp = start;
    // temp is equal to start
    while (temp != null){
      // while temp is not null
      ans += temp;
      // toString of temp is added to ans
      temp = temp.next();
      // temp is equal to temp's next
      if (temp != null) ans += ", ";
      // if temp's next is not null, ", " is added to ans
    }
    ans += "]";
    // ending bracket is added to ans
    return ans;
  }

  private class Node{
    private E data;
    private Node next,prev;

    public Node(E value, Node fwd, Node bk){
      data = value;
      next = fwd;
      prev = bk;
    }

    public E getData(){
      return data;
    }

    public E setData(E i){
      E temp = data;
      data = i;
      return temp;
    }

    public Node prev(){
      return prev;
    }

    public void setPrev(Node other){
      prev = other;
    }

    public Node next(){
      return next;
    }

    public void setNext(Node other){
      next = other;
    }

    public String toString(){
      return "" + data;
    }
  }

  public static void main(String[] args) {
    MyLinkedList<Integer> list = new MyLinkedList<>();
    //System.out.println(list.length);
    //System.out.println(list.start);
    //System.out.println(list.end);
    System.out.println(list);
  }


}
