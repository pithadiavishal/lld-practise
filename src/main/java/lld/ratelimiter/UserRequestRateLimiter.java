package lld.ratelimiter;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class UserRequestRateLimiter {
    private final int windowSize; // window size in seconds
    private final int requestLimit; // maximum number of requests allowed in the window
    private final Map<String, Deque<Instant>> userRequestTimes; // map to keep track of user request times

    public UserRequestRateLimiter(int windowSize, int requestLimit) {
        this.windowSize = windowSize;
        this.requestLimit = requestLimit;
        this.userRequestTimes = new HashMap<>();
    }

    public synchronized boolean allowRequest(String userId) {
        Instant now = Instant.now();
        Instant windowStart = now.minus(Duration.ofSeconds(windowSize));
        Deque<Instant> requestTimes = userRequestTimes.computeIfAbsent(userId, k -> new ArrayDeque<>(requestLimit));

        while (!requestTimes.isEmpty() && requestTimes.peek().isBefore(windowStart)) requestTimes.poll();

        if (requestTimes.size() < requestLimit) {
            requestTimes.offer(now);
            return true;
        } else return false;
    }

}
