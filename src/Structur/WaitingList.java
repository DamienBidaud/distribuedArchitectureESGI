package Structur;

import Thread.Worker;
import Thread.Job;

/**
 * Created by bidau on 31/05/2016.
 */
public class WaitingList {
    private Node first;
    private int size;

    public WaitingList(Node first){
        this.first = first;
        this.size = 0;
    }

    public void add(Node node){
        if(first==null){
            this.first = node;

        }else if(first.getNext()==null){
            first.setNext(node);
        }else{
            Node tmp = first;
            while (tmp.getNext()!=null){
                tmp = tmp.getNext();
            }
            tmp.setNext(node);
        }
        this.size ++;
    }

    public Worker remove(){
        Worker worker = first.getWorker();

        first = first.getNext();
        return worker;
    }

    public int getSize() {
        return size;
    }
}
