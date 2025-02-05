package lld.TaskScheduler;

import java.util.concurrent.TimeUnit;

public class Demo {
    public static void main(String[] args) {
        CustomTaskScheduler customTaskScheduler = new CustomTaskScheduler(2);
        customTaskScheduler.schedule(()->System.out.println("1"),4000, TimeUnit.MILLISECONDS);
        customTaskScheduler.schedule(()->System.out.println("2"),10000, TimeUnit.MILLISECONDS);
        customTaskScheduler.schedule(()->System.out.println("3"),2000, TimeUnit.MILLISECONDS);

        customTaskScheduler.start();
    }
}
