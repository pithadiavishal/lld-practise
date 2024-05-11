package lld.ratelimiter;

public class LeakyBucket implements RateLimiter{
    private int capacity;
    private int content;
    private long lastRequestTimeStamp;
    private int leakRate;

    public LeakyBucket(int capacity, int content, long lastRequestTimeStamp, int leakRate){
        this.capacity = capacity;
        this.content = content;
        this.lastRequestTimeStamp = lastRequestTimeStamp;
        this.leakRate = leakRate;
    }

    @Override
    public synchronized boolean access(){
        leak();
        if(content+1<capacity){
            content+=1;
            return true;
        }
        return false;
    }

    private void leak() {
        long now = System.currentTimeMillis();
        int leak = (int) ((now-lastRequestTimeStamp)*(leakRate/1000));
        if(leak>0){
            content=Math.max(0, content-leak);
            lastRequestTimeStamp=now;
        }
    }
}
