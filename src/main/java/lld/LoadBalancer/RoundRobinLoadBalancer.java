package lld.LoadBalancer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class RoundRobinLoadBalancer extends LoadBalancer {
    private AtomicInteger counter = new AtomicInteger(1);
    @Override
    Destination balanceLoad(Request request) {
        Set<Destination> destinationSet = getDestinations(request);
        Destination destination = destinationSet.stream().collect(Collectors.toList()).get(counter.get()%destinationSet.size());
        counter.addAndGet(1);
        return destination;
    }

    private Queue<Destination> convertSetToQueue(Set<Destination> destinationSet) {
        return new LinkedList<>(destinationSet);
    }
}
