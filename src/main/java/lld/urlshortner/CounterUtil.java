package lld.urlshortner;

import java.util.concurrent.atomic.AtomicInteger;

public class CounterUtil {
    private static AtomicInteger counter = new AtomicInteger(1);

    public static Integer getCounter(){
        return counter.getAndIncrement();
    }
}
