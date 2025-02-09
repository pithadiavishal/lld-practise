package lld.ratelimiter;

public class TokenBucket implements RateLimiter{
    private int capacity;
    private int available;
    private long lastRequestTimeStamp;
    private int ratePerSecond;

    public TokenBucket(int capacity, int available, long lastRequestTimeStamp, int ratePerSecond){
        this.capacity = capacity;
        this.available = available;
        this.lastRequestTimeStamp = lastRequestTimeStamp;
        this.ratePerSecond = ratePerSecond;
    }

    @Override
    public synchronized boolean grantAccess(){
        refill();
        if(available>1){
            available--;
            return true;
        }
        return false;
    }

    private void refill() {
        long now = System.currentTimeMillis();
        int refilled = (int) ((now-lastRequestTimeStamp) * (ratePerSecond/100));
        if(refilled>0){
            available = Math.min(capacity, available+refilled);
            lastRequestTimeStamp=now;
        }

    }
}
