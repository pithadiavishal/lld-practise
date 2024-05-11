package lld.multithreading;

public class MainClass {
    public static class OddEven{
        private static Object lock=new Object();
        int current;
        int max;
        public OddEven(int max){
            this.current = 1;
            this.max = max;
        }
        public void printOdd(){
            while (current<max){
                synchronized (lock){
                    if(current%2==0){
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    System.out.println(current++);
                    lock.notify();
                }
            }
        }
        public void printEven() {
            while (current<max){
                synchronized (lock){
                    if(current%2==1){
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    System.out.println(current++);
                    lock.notify();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        OddEven oddEven = new OddEven(10);
        Thread odd = new Thread(()->oddEven.printOdd());
        Thread even = new Thread(()->oddEven.printEven());
        odd.start();
        even.start();
        odd.join();
        even.join();
    }
}
