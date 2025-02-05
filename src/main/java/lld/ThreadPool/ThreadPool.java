package lld.ThreadPool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

public class ThreadPool {
    private int numOfThreads;
    private final LinkedBlockingQueue<Task> taskQueue;
    private final List<Worker> workers;

    public ThreadPool(int numOfThreads){
        this.numOfThreads = numOfThreads;
        taskQueue = new LinkedBlockingQueue<>();
        this.workers = new ArrayList<>();

        for(int i = 0 ; i < numOfThreads; i++){
            Worker worker = new Worker(taskQueue);
            workers.add(worker);
            new Thread(worker).start();
        }
    }

    public void submit(Task task) throws InterruptedException {
        taskQueue.put(task);
    }


}
