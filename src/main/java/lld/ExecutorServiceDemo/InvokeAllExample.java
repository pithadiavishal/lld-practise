package lld.ExecutorServiceDemo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class InvokeAllExample {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        List<Callable<String>> taskList = new ArrayList<>();
        for(int i = 1; i <=100 ; i++){
            AtomicInteger num = new AtomicInteger(i);
            Callable<String> task = ()->{
                for(int j = 1 ; j <=100 ; j++){
                    System.out.println(num + " * " + j + " = " + num.get() *j);
                }
                return " table for " + num.get() + " generated";
            };
            taskList.add(task);
        }

        List<Future<String>> futures = executorService.invokeAll(taskList);
       // String result = executorService.invokeAny(taskList);
        //System.out.println(result);



        for(Future<String> future: futures) {
            // The result is printed only after all the futures are complete. (i.e. after 5 seconds)
            System.out.println(future.get());
        }

        executorService.shutdown();
    }
}
