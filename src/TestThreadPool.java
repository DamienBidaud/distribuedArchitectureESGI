/**
 * Created by bidau on 01/06/2016.
 */

import Thread.ThreadPool;
import Thread.Job;
import Thread.Worker;

public class TestThreadPool {

    public static void main(String args[]){
        ThreadPool  threadPool = new ThreadPool(5, 10);
        threadPool.addJob(new Job());
        threadPool.addJob(new Job());
        threadPool.addJob(new Job());
        threadPool.addJob(new Job());
        threadPool.addWorker(new Worker());
        threadPool.addWorker(new Worker());
        threadPool.addWorker(new Worker());
        threadPool.addWorker(new Worker());
        threadPool.addWorker(new Worker());
        threadPool.addWorker(new Worker());


    }
}
