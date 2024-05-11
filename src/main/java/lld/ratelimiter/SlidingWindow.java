package lld.ratelimiter;

import java.util.LinkedList;
import java.util.Queue;

public class SlidingWindow implements RateLimiter{
    private int capacity;
    private int windowSizeInSec;
    private Queue<Long> queue;
    public SlidingWindow(int capacity, int windowSizeInSec){
        this.capacity = capacity;
        this.windowSizeInSec = windowSizeInSec;
        this.queue = new LinkedList<>();
    }
    @Override
    public synchronized boolean access(){
        long now = System.currentTimeMillis();
        while(!queue.isEmpty() && ((now-queue.peek())/1000<windowSizeInSec)){
            queue.remove();
        }
        if(queue.size()<capacity){
            queue.add(now);
            return true;
        }
        return false;
    }
}
