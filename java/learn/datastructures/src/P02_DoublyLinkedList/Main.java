package P02_DoublyLinkedList;

public class Main {
     public static void main(String[] args) {
        DoublyLinkedList mylist = new DoublyLinkedList();
        mylist.addFirst(3);
        mylist.add(4);
        mylist.addLast(7);
        System.out.println(mylist.contains(5));
        System.out.println(mylist.getSize());
        System.out.println(mylist.indexOf(3));
        System.out.println(mylist.isEmpty());
        System.out.println(mylist.peekFirst());
        System.out.println(mylist.peekLast());
        System.out.println(mylist.remove(4));
        mylist.add(6);
        mylist.addLast(8);
        mylist.addFirst(4);
        System.out.println(mylist.removeLast());
        System.out.println(mylist.removeAt(3));
        System.out.println(mylist.removeFirst());
        System.out.println(mylist.getSize());

        System.out.println(mylist);

    }

}
