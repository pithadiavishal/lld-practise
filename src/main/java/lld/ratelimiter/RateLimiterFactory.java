package lld.ratelimiter;

import java.time.Duration;

public class RateLimiterFactory {

    public RateLimiter getRateLimiter(String rateLmt,int windowSize,int reqLimit){
        RateLimiter rateLimiter = null;
        switch (rateLmt){
            case "sliding-window" : rateLimiter = new SlidingWindow(windowSize,reqLimit);
            break;
            case "leaky-bucket" : rateLimiter = new LeakyBucketRateLimiter(reqLimit, Duration.ofSeconds(1));
            break;
        }
        return rateLimiter;
    }
}
