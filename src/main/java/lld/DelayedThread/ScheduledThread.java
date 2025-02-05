package lld.DelayedThread;

public class ScheduledThread {
    private Runnable runnable;
    private long scheduledTime;

    public Runnable getRunnable() {
        return runnable;
    }

    public long getScheduledTime() {
        return scheduledTime;
    }

    public ScheduledThread(Runnable runnable, long scheduledTime) {
        this.runnable = runnable;
        this.scheduledTime = scheduledTime;
    }
}
