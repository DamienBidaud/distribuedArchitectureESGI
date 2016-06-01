package Thread;

public class Worker extends Thread {

    private Job job;

    @Override
    public void run(){
        if(this.job!= null)
            this.job.execute();
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }
}
