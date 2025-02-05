package lld.ThreadPool;

import java.util.concurrent.BlockingQueue;

public class Worker implements Runnable{
    private final BlockingQueue<Task> taskQueue;

    public Worker(BlockingQueue<Task> taskQueue){
        this.taskQueue = taskQueue;
    }

    @Override
    public void run(){
        while(true){
            try{
                Task task = taskQueue.take();
                task.execute();
            }catch(InterruptedException iex){
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}