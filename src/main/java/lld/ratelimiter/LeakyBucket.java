package lld.ratelimiter;

public class LeakyBucket implements RateLimiter{

    private long lastRequestTime;
    private final long capacity;
    private final long ratePerSecond;

    public LeakyBucket(long capacity, long ratePerSecond) {
        this.capacity = capacity;
        this.ratePerSecond = ratePerSecond;
        this.lastRequestTime = System.currentTimeMillis();
    }
    @Override
    public synchronized boolean grantAccess() {
        long now = System.currentTimeMillis();
        long elapsedTime = now - lastRequestTime;
        long availableCapacity = Math.max(0, capacity - elapsedTime * ratePerSecond / 1000);
        if (availableCapacity > 0) {
            lastRequestTime = now;
            return true;
        } else {
            return false;
        }
    }
}
