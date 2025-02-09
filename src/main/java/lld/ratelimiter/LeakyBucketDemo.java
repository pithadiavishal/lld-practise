package lld.ratelimiter;

import java.time.Duration;

public class LeakyBucketDemo {

    public static void main(String[] args) {
        LeakyBucketRateLimiter rateLimiter = new LeakyBucketRateLimiter(10, Duration.ofSeconds(1));
        for (int i = 1; i <= 20; i++) {
            if (rateLimiter.grantAccess()) {
                System.out.println("Request " + i + " succeeded");
            } else {
                System.out.println("Request " + i + " failed");
            }
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
