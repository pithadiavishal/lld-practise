package lld.ExecutorServiceDemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorsServiceExample {
    public static void main(String[] args) {
        System.out.println("Inside : " + Thread.currentThread().getName());
        System.out.println("Creating Executor Service..." + Thread.currentThread().getName());

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(new EvenNumbers());
        executorService.submit(new OddNumbers());
        executorService.shutdown();
    }
}
class EvenNumbers implements Runnable{
    @Override
    public void run() {
        for(int i = 0 ; i<=10 ;i+=2){
            System.out.println(  Thread.currentThread().getName() + " Even :" + i);
        }
    }
}

class OddNumbers implements Runnable{

    @Override
    public void run() {
        for(int i = 1 ; i<=10 ;i+=2){
            System.out.println(  Thread.currentThread().getName() + " Odd :" + i);
        }
    }
}
