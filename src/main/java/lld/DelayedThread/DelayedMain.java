package lld.DelayedThread;

public class DelayedMain {

    public static void main(String[] args) throws InterruptedException {
        DelayedThreadService delayedThreadService = new DelayedThreadService();
        DelayedThread delayedThread1 = new DelayedThread(1,()-> System.out.println("runnable 1"));
        DelayedThread delayedThread2 = new DelayedThread(15000,()-> System.out.println("runnable 2"));
        DelayedThread delayedThread3 = new DelayedThread(8000,()-> System.out.println("runnable 3"));

        delayedThreadService.submit(delayedThread1);
        delayedThreadService.submit(delayedThread2);
        delayedThreadService.submit(delayedThread3);
        delayedThreadService.executeTasks();
    }
}
