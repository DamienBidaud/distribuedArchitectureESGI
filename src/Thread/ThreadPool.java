package Thread;

import Structur.Node;
import Structur.Stack;
import Structur.WaitingList;

/**
 * Created by bidau on 31/05/2016.
 */
public class ThreadPool {

    private int maxJob;
    private int maxWaitingJob;
    private Stack jobs;
    private WaitingList waitingList;


    public ThreadPool(int maxJob, int maxWaitingJob){
        this.maxJob = maxJob;
        this.maxWaitingJob = maxWaitingJob;
        this.jobs = new Stack();
        this.waitingList = new WaitingList();
    }

    public boolean addWorker(Worker worker){
        if(waitingList.getSize() < maxWaitingJob){
            Node<Worker> workerNode = new Node<>(null, worker);
            this.waitingList.add(workerNode);
            return true;
        }else{
            return false;
        }
    }

    public boolean addJob(Job job){
        if(this.jobs.getSize()<maxJob){
            this.jobs.push(job);
            return true;
        }else{
            return false;
        }

    }
}
