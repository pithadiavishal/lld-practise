package lld.interview.outbrain;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.atomic.AtomicInteger;

public class Round2 {


}

interface ClicksCounter {
    void onClick();

    int get5MinutesSnapshot();
}

class ClickCounterImplementation implements ClicksCounter{
    public class Pair{
        public AtomicInteger value;
        public Instant key;
    }
    private Queue<Instant> clickInstants;
    private ConcurrentLinkedDeque<Pair> clickCounters;
    // {T, 1}, {T+1, 2},
    private final int WINDOW_SIZE_IN_SEC = 5*60;

    public  ClickCounterImplementation(){
        //clickInstants = new LinkedList<>();
        clickInstants = new ConcurrentLinkedDeque<>();
    }

    @Override
    public void onClick() {
        clickInstants.add(Instant.now());
    }

    public void _onClick(){
        Pair latestCounter = null;
        if(!clickCounters.isEmpty()){
            latestCounter = clickCounters.removeLast();
        }
        if(Instant.now().equals(latestCounter.key)){
            latestCounter.value.incrementAndGet();
        }
    }
    @Override
    public synchronized int get5MinutesSnapshot() {
        Instant currentInstance = Instant.now();
        Instant fiveMinutesEarlierInstance = subtract5Minutes(currentInstance);
        while(!clickInstants.isEmpty()&&clickInstants.peek().isBefore(fiveMinutesEarlierInstance)){
            clickInstants.remove();
        }
        return clickInstants.size();
    }

    private Instant subtract5Minutes(Instant instant){
        instant.minus(5, ChronoUnit.MINUTES);
        return instant;
    }
}