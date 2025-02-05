package lld.ScheduledExecutor;

public class SchedulerDemo {
    public static void main(String[] args) {
        DelayedScheduler delayedScheduler = new DelayedScheduler();
        delayedScheduler.schedule(()->System.out.println("five second delay task"), 5000);
        delayedScheduler.schedule(()->System.out.println("one second delay task"), 1000);
    }

}
