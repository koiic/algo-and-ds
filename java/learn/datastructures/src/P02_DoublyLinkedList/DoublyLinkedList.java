package P02_DoublyLinkedList;

import java.util.Iterator;

public class DoublyLinkedList<T> implements Iterable<T> {

    private int size = 0;
    private Node <T> head = null;
    private Node <T> tail = null;


    // Internal node class to represent data
    private class Node<T> {
        T data;
        Node<T> prev, next;
        public Node(T data, Node<T> prev, Node<T> next) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }

    // clear all value in doubly linked list
    public void clear() {
        Node<T> trav = head;
        while(trav != null){
            Node<T> next = trav.next;
            trav.prev = trav.next = null;
            trav.data = null;
            trav = next;
        }
        head = tail = trav = null;
        size = 0;
    }

    // Return the size of the linked list
    public int getSize() {
        return size;
    }

    // check if list is empty
    public boolean isEmpty(){
        return getSize() == 0;
    }

    // Add an element to the tail of the linkedlist, 0(1)
    public void add(T elem) {
        addLast(elem);
    }

    // Add element to the beginning  of this linkedlist, 0(1)
    public void addFirst(T elem) {

        //check if linkedlist is empty
        if (isEmpty()) {
            head = tail = new Node<T>(elem, null, null);
        } else {
            head.prev = new Node<T>(elem, null, head);
            head = head.prev;
        }
        size++;
    }

    // Add element to the end  of this linkedlist, 0(1)
    public void addLast(T elem) {

        //check if linkedlist is empty
        if (isEmpty()) {
            head = tail = new Node<T>(elem, null, null);

        }else{
            tail.next = new Node<>(elem, tail, null);
            tail = tail.next;
        }
        size++;
    }

    // Check value of the first node if it exist
    public T peekFirst() {
        if (isEmpty()) throw new RuntimeException("empty list");
        return head.data;
    }

    // Check value of the last node if it exist
    public T peekLast() {
        if (isEmpty()) throw new RuntimeException("empty list");
        return tail.data;
    }
    // Remove the first value at the end of a linkedlist
    public T removeFirst() {

        // can't remove data from an empty list
        if (isEmpty()) throw new RuntimeException("empty list");

        // extract the data at the head and move
        // the head pointer forward one node
        T data = head.data;
        head = head.next;
        --size;

        // if the list is is empty set set the tail to null as well
        if (isEmpty()) tail = null;

        // Do a memory clean
        else head.prev = null;

        // Return the data that was at the first node we just removed
        return data;
    }

    // Remove the last value at the end of a linkedlist
    public T removeLast() {

        // can't remove data from an empty list
        if (isEmpty()) throw new RuntimeException("empty list");

        // extract the data at the head and move
        // the head pointer forward one node
        T data = tail.data;
        tail = tail.prev;
        --size;

        // if the list is empty set set the head to null as well
        if (isEmpty()) head = null;

        // Do a memory clean
        else tail.next  = null;

        // Return the data that was at the first node we just removed
        return data;
    }


    //Remove an arbitrary node from the linkedlist, 0(1)
    private T remove(Node <T> node) {

        // If the node to remove is somewhere either at the head or tail handle those independently

        if (node.prev == null) return removeFirst();
        if(node.next == null) return removeLast();

        // Make the pointers of adjacent node skip over 'node'
        node.next.prev = node.prev;
        node.prev.next = node.next;

        // Temporary store the data we want to return
        T data = node.data;

        // cleanup memory
        node.data = null;
        node = node.prev = node.next = null;

        --size;

        // RETURN data
        return data;
    }


    // Remove a node at a particular index
    public T removeAt(int index) {
        // make sure the index provided is valid ;;
        if(index < 0 || index >= size) throw new IllegalArgumentException();

        int i;
        Node<T> trav;
        // Search from the front of the list
        if (index < size/2) {
            for (i=0, trav=head; i != index; i++)
                trav = trav.next;
        //Search from the back of the list
        }else
            for (i = size -1, trav=tail; i != index; i--)
                trav = trav.prev;
        return remove(trav);

    }

    // Remove a particular value in linkedlist 0(n)
    public boolean remove(Object obj) {
        Node<T> trav = head;

        //Support searching for null
        if (obj == null) {
            for (trav = head; trav != null; trav = trav.next){
                if (trav.data == null) {
                    remove(trav);
                    return true;
                }
            }
        } else {
            for (trav = head; trav != null; trav = trav.next) {
                if (obj.equals(trav.data)){
                    remove(trav);
                    return true;
                }
            }
        }
        return false;
    }

    // find the index of a particular value in the linkedlist, 0(n)
    public int indexOf(Object obj) {
        int index = 0;
        Node<T> trav = head;

        //Support searching for null
        if (obj == null) {
            for (trav = head; trav != null; trav = trav.next, index++){
                if (trav.data == null) {
                    return index;
                }
            }
        } else {
            for (trav = head; trav != null; trav = trav.next, index++) {
                if (obj.equals(trav.data)){
                    return index;
                }
            }
        }
        return -1;
    }

    // check if a value is contained within the linked list
    public boolean contains(Object obj){
        return indexOf(obj) != -1;
    }


    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> trav = head;
            @Override
            public boolean hasNext() {
                return trav != null;
            }

            @Override
            public T next() {
                T data = trav.data;
                trav = trav.next;
                return data;
            }
        };
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node<T> trav = head;
        while(trav != null) {
            sb.append(trav.data + ", ");
            trav = trav.next;
        }
        sb.append(" ]") ;
        return sb.toString();
    }
}

