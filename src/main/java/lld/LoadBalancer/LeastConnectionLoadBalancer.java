package lld.LoadBalancer;

import java.util.Comparator;

public class LeastConnectionLoadBalancer extends LoadBalancer{
    @Override
    Destination balanceLoad(Request request) {
       return getDestinations(request).stream().min(Comparator.comparingInt(d->d.requestsBeingServed)).orElse(null);
    }
}
