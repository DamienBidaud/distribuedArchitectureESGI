package Thread;

public class Job {

    public void execute(){
        System.out.println(Thread.currentThread().getName()+" Job is working");
    }
}
