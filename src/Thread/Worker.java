package Thread;

public class Worker extends Thread {

    private Job job;
    private ThreadPool threadPool;

    @Override
    public void run(){
        if(this.job!= null)
            this.job.execute();
        threadPool.addJob(this.job);
        job = null;
        threadPool.addWorker(new Worker());
        System.out.println("Fin "+Thread.currentThread().getName());
    }


    public void setJob(Job job) {
        this.job = job;
    }


    public void setThreadPool(ThreadPool threadPool) {
        this.threadPool = threadPool;
    }
}
