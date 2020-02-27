package P03_Stack;

import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.LinkedList;

public class Stack<T> implements Iterable {

     private LinkedList<T> list = new LinkedList<T>();

    //Empty constructor for creating an empty stackj
    public Stack() {
    }

    public Stack(T firstElement){
        push(firstElement);
    }

    public int size(){
        return list.size();
    }

    //check if stack is empty
    public boolean isEMpty() {
        return size() == 0;
    }

    //Pop am element of the stack
    //Throw an exception if the stack is emoty
    public T pop(){
        if (isEMpty()){
            throw new EmptyStackException();

        }
        return list.removeLast();

    }

    //push an elemnent on to the stack
    public void push(T element){
        list.addLast(element);
    }

    public T peek() {
        if (isEMpty()) throw new EmptyStackException();
        return list.peekLast();
    }


    @Override
    public Iterator<T> iterator() {
        return list.iterator();
    }

}
