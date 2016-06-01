package Structur;


import Thread.Worker;
/**
 * Created by bidau on 31/05/2016.
 */
public class Node<T> {
    private Node next;
    private T value;


    public Node(Node next, T value){
        this.next = next;
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}