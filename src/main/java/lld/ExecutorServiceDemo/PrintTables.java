package lld.ExecutorServiceDemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PrintTables {

    public static void main(String[] args) {
        printTables(new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10)),1,1000);
    }

    private static void printTables(List<Integer> numbers , int start , int end){
        long start1 = System.nanoTime();
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        for(int num : numbers){
            Runnable runnable = ()-> printTable(num,start,end);
            executorService.submit(runnable);
        }
        executorService.shutdown();
        long end1 = System.nanoTime();
        System.out.println("exec time = " + (end1-start1));
    }

    private static void printTable(int num, int start, int end){
        while (start <= end){
            System.out.println(Thread.currentThread().getName() + " :: " + num + " * " + start + " = " + num * start);
            start++;
        }
        System.out.println();
    }
}
