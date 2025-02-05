package lld.ExecutorServiceDemo;

import java.util.concurrent.*;

public class FutureAndCallableExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        long startTime = System.nanoTime();
        Callable<String> callable = () -> {
            // Perform some computation
            System.out.println("Entered Callable " + Thread.currentThread().getName());
            Thread.sleep(4000);
            return "Hello from Callable";
        };

        System.out.println("Submitting Callable");
        Future<String> future = executorService.submit(callable);

        while(!future.isDone()) {
            System.out.println("Task is still not done... " + Thread.currentThread().getName());
            Thread.sleep(200);
            double elapsedTimeInSec = (System.nanoTime() - startTime)/1000000000.0;
            if(elapsedTimeInSec > 1) {
                future.cancel(true);
            }
        }

        if(!future.isCancelled()) {
            System.out.println("Task completed! Retrieving the result");
            String result = future.get(1,TimeUnit.SECONDS);
            System.out.println(result);
        } else {
            System.out.println("Task was cancelled");
        }
        executorService.shutdown();

    }
}
