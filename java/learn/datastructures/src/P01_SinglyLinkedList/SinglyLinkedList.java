package P01_SinglyLinkedList;

import java.util.Iterator;

public class SinglyLinkedList<T> implements Iterable<T>{

    private int size = 0;
    private Node<T> head = null;
    private Node<T> tail = null;


    private class Node<T>{

        T data;
        Node<T> next;

        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }

        @Override
        public String toString() {
            return  data.toString();
        }
    }

    public int getSize() {
        return size;
    }

    // check if list is empty
    public boolean isEmpty(){
        return getSize() == 0;
    }

    // add a new node to linkedlist
    public void add(T elem){
        addLast(elem);

    }

    // add to the tail of the linkedlist
    public void addLast(T elem){

         if (isEmpty()) {
             head = tail = new Node<T>(elem, null);
         }else {
             tail.next = new Node<T>(elem, null);
             tail = tail.next;

         }
         size++;
    }

    public void addFirst(T elem){
         if (isEmpty()) {
             head = tail = new Node<T>(elem, null);
         }else {
             Node<T> trav = head;
             head = new Node<>(elem, trav);
             head.next = trav;
         }
         size++;
    }



    @Override
    public Iterator<T> iterator() {
        return null;
    }


     @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        SinglyLinkedList.Node trav = head;
        while(trav != null) {
            sb.append(trav.data + ", ");
            trav = trav.next;
        }
        sb.append(" ]") ;
        return sb.toString();
    }
}
