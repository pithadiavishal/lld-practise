package lld.ratelimiter;

import java.time.Duration;
import java.time.Instant;
import java.util.Deque;
import java.util.concurrent.ConcurrentLinkedDeque;

public class SlidingWindow implements RateLimiter{

    private final int windowSize; // window size in seconds

    private final int requestLimit; // maximum number of requests allowed in the window

    private final Deque<Instant> slidingWindow; // queue to keep track of request times

    public SlidingWindow(int windowSize , int requestLimit){
        this.windowSize = windowSize;
        this.requestLimit = requestLimit;
        this.slidingWindow = new ConcurrentLinkedDeque<>();
    }
    @Override
    public boolean grantAccess() {
        Instant now = Instant.now();
        Instant windowStart = now.minus(Duration.ofSeconds(windowSize));

        while (!slidingWindow.isEmpty() && slidingWindow.peek().isBefore(windowStart)){
            slidingWindow.poll(); // remove requests that are outside of the window
        }
        if(slidingWindow.size() < requestLimit) {
            slidingWindow.offer(now);  // add current request time to the queue
        return true; // allow the request
        }
        return false; // request limit exceeded
    }
}
