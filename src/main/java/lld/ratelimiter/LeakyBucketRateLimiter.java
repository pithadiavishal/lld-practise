package lld.ratelimiter;

import java.time.Duration;
import java.time.Instant;

public class LeakyBucketRateLimiter implements RateLimiter{

    private int capacity;
    private int level;
    private Instant lastRefillTime;
    private Duration refillInterval;

    public LeakyBucketRateLimiter(int capacity, Duration refillInterval) {
        this.capacity = capacity;
        this.level = 0;
        this.refillInterval = refillInterval;
        this.lastRefillTime = Instant.now();
    }

    @Override
    public synchronized boolean grantAccess() {
        refillTokens();
        if(level<capacity){
            level++;
            return true;
        }
        return false;
    }

    private void refillTokens() {
        Instant now = Instant.now();
        long timeSinceLastRefill = Duration.between(lastRefillTime, now).toMillis();
        int leaks = (int) (timeSinceLastRefill / refillInterval.toMillis());
        if(leaks>0){
            level = Math.max(0, level-leaks);
        }
        this.lastRefillTime = now;
    }
}

