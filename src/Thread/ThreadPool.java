package Thread;

import Structur.WaitingList;

/**
 * Created by bidau on 31/05/2016.
 */
public class ThreadPool {

    private int maxJob;
    private int maxWaitingJob;
    private Job[] jobs;
    private WaitingList waitingList;


    public ThreadPool(int maxJob, int maxWaitingJob){
        this.maxJob = maxJob;
        this.maxWaitingJob = maxWaitingJob;
        this.jobs = new Job[this.maxJob];
        this.waitingList = new WaitingList(null);
    }

    public boolean addWorker(){
        if(waitingList.getSize() == maxWaitingJob){
            return false;
        }else{

            return true;
        }
    }
}
