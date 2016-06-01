package Thread;

import Structur.Node;
import Structur.Stack;
import Structur.WaitingList;

public class ThreadPool {

    private int maxJob;
    private int maxWaitingWorker;
    private Stack jobs;
    private WaitingList waitingList;


    public ThreadPool(int maxJob, int maxWaitingWorker){
        this.maxJob = maxJob;
        this.maxWaitingWorker = maxWaitingWorker;
        this.jobs = new Stack();
        this.waitingList = new WaitingList();
    }

    public boolean addWorker(Worker worker){
        if(waitingList.getSize() < maxWaitingWorker){
            worker.setThreadPool(this);
            Node<Worker> workerNode = new Node<>(null, worker);
            this.waitingList.add(workerNode);
            launchWork();
            return true;
        }else{
            return false;
        }
    }

    public boolean addJob(Job job){
        if(this.jobs.getSize()<maxJob){
            this.jobs.push(job);
            notifyOne();
            return true;
        }else{
            return false;
        }
    }

    public void launchWork(){
        if(!this.jobs.isEmpty() && !this.waitingList.isEmpty() && this.jobs.pop()!=null){
            Worker worker = this.waitingList.remove();
            worker.setJob(this.jobs.peek());
            worker.start();
        }
    }

    public void notifyOne(){
        this.launchWork();
    }
}
