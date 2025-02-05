package lld.DelayedThread;

import java.util.Comparator;
import java.util.PriorityQueue;


public class DelayedThreadService {

    private final PriorityQueue<ScheduledThread> schedulerQueue;

    public DelayedThreadService() {
        schedulerQueue = new PriorityQueue<>(Comparator.comparingLong(ScheduledThread::getScheduledTime).reversed());
    }

    public void submit(DelayedThread delayedThread) throws InterruptedException {
        long scheduledTime = System.currentTimeMillis() + delayedThread.getDelayInMillis();
        ScheduledThread scheduledThread = new ScheduledThread(delayedThread.getRunnable(), scheduledTime);
        schedulerQueue.add(scheduledThread);
    }

    public void executeTasks() throws InterruptedException {
        while (!schedulerQueue.isEmpty()) {
            long scheduledTime = schedulerQueue.peek().getScheduledTime();
            long diff = System.currentTimeMillis() - scheduledTime;
            if (diff == 0) {
                ScheduledThread scheduledThread = schedulerQueue.poll();
                if (scheduledThread != null && scheduledThread.getRunnable() != null) {
                    scheduledThread.getRunnable().run();
                }
            } else if (diff < 0) schedulerQueue.poll(); // reject tasks
        }
    }
}
