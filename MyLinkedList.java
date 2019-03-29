public class MyLinkedList<E>{



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
}
