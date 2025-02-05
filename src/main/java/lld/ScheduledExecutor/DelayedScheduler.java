package lld.ScheduledExecutor;

import java.util.PriorityQueue;
import java.util.concurrent.TimeUnit;

public class DelayedScheduler {

    private final PriorityQueue<DelayedTask> queue;
    public DelayedScheduler() {
        this.queue = new PriorityQueue<>();
        this.startExecute();
    }

    private void put(DelayedTask task) {
        synchronized (this) {
            this.queue.offer(task);
            if (task == this.queue.peek()) {
                notify();
            }
        }
    }

    private DelayedTask take() throws InterruptedException {
        synchronized (this) {
            while (true) {
                DelayedTask peekTask = this.queue.peek();
                if (peekTask == null) {
                    wait();
                } else {
                    long delay = peekTask.getDelay(TimeUnit.MILLISECONDS);
                    if (delay <= 0) {
                        return this.queue.poll();
                    }
                    wait(delay);
                }
            }
        }
    }


    private void startExecute() {
        Runnable execute = () -> {
            while (true) {
                try {
                    DelayedTask task = this.take();
                    task.run();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        new Thread(execute, "Executor").start();
    }

    public void schedule(Runnable task, long delay) {
        this.put(new DelayedTask(task, delay));
    }
}