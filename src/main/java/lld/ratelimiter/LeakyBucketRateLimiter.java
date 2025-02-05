package lld.ratelimiter;

import java.time.Duration;
import java.time.Instant;

public class LeakyBucketRateLimiter {

    private int capacity;
    private int tokens;
    private Instant lastRefillTime;
    private Duration refillInterval;

    public LeakyBucketRateLimiter(int capacity, Duration refillInterval) {
        this.capacity = capacity;
        this.tokens = capacity;
        this.refillInterval = refillInterval;
        this.lastRefillTime = Instant.now();
    }

    public synchronized boolean tryConsume(int tokens) {
        refillTokens();
        if (this.tokens >= tokens) {
            this.tokens -= tokens;
            return true;
        }
        return false;
    }

    private void refillTokens() {
        Instant now = Instant.now();
        long timeSinceLastRefill = Duration.between(lastRefillTime, now).toMillis();
        int tokensToAdd = (int) (timeSinceLastRefill / refillInterval.toMillis());
        this.tokens = Math.min(this.tokens + tokensToAdd, this.capacity);
        this.lastRefillTime = now;
    }
}

