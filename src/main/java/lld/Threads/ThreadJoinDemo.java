package lld.Threads;

public class ThreadJoinDemo {
    public static void main(String[] args) {
        ParallelTask task1 = new ParallelTask();
        ParallelTask task2 = new ParallelTask();
        ParallelTask task3 = new ParallelTask();

        Thread t1 = new Thread(task1,"Thread - 1");
        Thread t2 = new Thread(task2,"Thread - 2");
        Thread t3 = new Thread(task3,"Thread - 3");
        
        task2.setPredecessor(t1);
        task3.setPredecessor(t2);

        t1.start();
        t2.start();
        t3.start();
    }

    private static class ParallelTask implements Runnable {
        Thread predecessor;

        public void setPredecessor(Thread predecessor) {
            this.predecessor = predecessor;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " started ");
            if (predecessor != null) {
                try {
                    predecessor.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + " completed");
        }
    }
}
