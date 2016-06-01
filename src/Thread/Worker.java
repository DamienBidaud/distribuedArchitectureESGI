package Thread;

/**
 * Created by bidau on 31/05/2016.
 */
public class Worker extends Thread {

    private Job job;

    @Override
    public void run(){

    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }
}
