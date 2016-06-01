package Structur;

import Thread.Worker;


public class WaitingList {
    private Node<Worker> first;
    private int size;

    public WaitingList(){
        this.first = null;
        this.size = 0;
    }

    public void add(Node<Worker> node){
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
        Worker worker = first.getValue();

        first = first.getNext();
        return worker;
    }

    public int getSize() {
        return size;
    }
}
