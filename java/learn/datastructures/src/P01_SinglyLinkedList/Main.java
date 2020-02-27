package P01_SinglyLinkedList;

public class Main {

    public static void main(String[] args) {
        SinglyLinkedList newList = new SinglyLinkedList();

        newList.add(8);
        newList.addFirst(5);

        System.out.println(newList);
        System.out.println(newList.getSize());
    }
}
