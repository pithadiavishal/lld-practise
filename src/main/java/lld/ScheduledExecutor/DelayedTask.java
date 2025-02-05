package lld.ScheduledExecutor;

import java.util.concurrent.TimeUnit;

public class DelayedTask implements Comparable, Runnable {

    private final long startTime;
    private final Runnable task;

    public DelayedTask(Runnable task, long delayTime) {
        this.task = task;
        this.startTime = System.currentTimeMillis() + delayTime;
    }

    public long getDelay(TimeUnit unit) {
        long diff = this.startTime - System.currentTimeMillis();
        long delay = unit.convert(diff, TimeUnit.MILLISECONDS);
        return delay;
    }

    @Override
    public int compareTo(Object o) {
        return Long.compare(this.getDelay(TimeUnit.MILLISECONDS), ((DelayedTask) o).getDelay(TimeUnit.MILLISECONDS));
    }

    @Override
    public void run() {
        task.run();
    }
}