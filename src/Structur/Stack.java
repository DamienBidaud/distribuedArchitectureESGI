package Structur;

import Thread.Job;

public class Stack {
    private Node<Job> top;
    private int size;

    public Stack(){
        this.top = null;
        this.size = 0;
    }

    public void push(Job job){
        Node<Job> tmp = new Node<>(null, job);
        if(top==null){
            this.top = tmp;
        }else{
            tmp.setNext(this.top);
            this.top = tmp;
        }
        size++;
    }

    public int getSize(){
        return this.size;
    }

    public Job pop(){
        return this.top.getValue();
    }

    public Job peek(){
        Job job = this.top.getValue();
        this.top = this.top.getNext();
        return job;
    }


}
