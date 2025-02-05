package lld.ratelimiter;

public class RateLimiterTest {
    public static void main(String[] args) {
        simpleRateLimiter();
        //userBasedRateLimiting();
    }

    private static void simpleRateLimiter() {
        RateLimiterFactory rateLimiterFactory = new RateLimiterFactory();
        RateLimiter slidingWindowRateLimiter = rateLimiterFactory.getRateLimiter("sliding-window",60,10);
        for (int i = 0; i < 30; i++) {
            if (slidingWindowRateLimiter.grantAccess()) System.out.println("Request" + i + " allowed");
            else System.out.println("Request " + i + " denied");
        }
    }

    private static void userBasedRateLimiting() {
        UserRequestRateLimiter limiter = new UserRequestRateLimiter(60, 2);
        for (int i = 0; i < 10; i++) {
            String userId = "user" + (i % 2); // simulate 2 users making requests
            if (limiter.allowRequest(userId)) {
                System.out.println("User " + userId + " request " + i + " allowed");
            } else {
                System.out.println("User " + userId + " request " + i + " denied");
            }

        }
    }
}
