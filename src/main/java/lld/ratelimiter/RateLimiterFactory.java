package lld.ratelimiter;

public class RateLimiterFactory {

    public RateLimiter getRateLimiter(String rateLmt,int windowSize,int reqLimit){
        RateLimiter rateLimiter = null;
        switch (rateLmt){
            case "sliding-window" : rateLimiter = new SlidingWindow(windowSize,reqLimit);
            break;
            case "leaky-bucket" : rateLimiter = new LeakyBucket(reqLimit,windowSize);
            break;
        }
        return rateLimiter;
    }
}
