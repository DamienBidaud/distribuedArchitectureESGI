package Structur;


import Thread.Worker;
/**
 * Created by bidau on 31/05/2016.
 */
public class Node {
    private Node next;
    private Worker worker;


    public Node(Node next, Worker worker){
        this.next = next;
        this.worker = worker;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }
}
