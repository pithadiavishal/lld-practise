package lld.DelayedThread;

public class DelayedThread {
    private int delayInMillis;
    private Runnable runnable;

    public int getDelayInMillis() {
        return delayInMillis;
    }

    public Runnable getRunnable() {
        return runnable;
    }

    public DelayedThread(int delayInMillis, Runnable runnable) {
        this.delayInMillis = delayInMillis;
        this.runnable = runnable;
    }
}
