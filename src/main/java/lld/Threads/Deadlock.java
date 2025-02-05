package lld.Threads;

class DeadLock {
    static final String resource1= "Printer";
    static final String resource2= "Scanner";
    public static void main(String[] args) {
        ThreadDemo1 Thread1 = new ThreadDemo1();
        ThreadDemo2 Thread2 = new ThreadDemo2();
        Thread1.start();
        Thread2.start();
    }
    private static class ThreadDemo1 extends Thread {
        public void run() {
            synchronized (resource1) {
                System.out.println("Desktop "+ ": locked" + resource1);
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                }
            }
            System.out.println("Desktop " + ": waiting for" + resource2+"......");
            synchronized (resource2) {
                System.out.println("Desktop "+ ": locked" + resource2);
            }
        }
    }
    private static class ThreadDemo2 extends Thread {
        public void run() {
            synchronized (resource2) {
                System.out.println("Laptop "+": locked" + resource2);
                try {
                    Thread.sleep(100);
                } catch (Exception e) {
                }
            }
            System.out.println("Laptop " + ": waiting for" + resource1+"......");
            synchronized (resource1) {
                System.out.println("Laptop "+ ": locked" + resource1);
            }
        }
    }
}