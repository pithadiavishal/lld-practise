package lld.LoadBalancer;

import java.util.List;
import java.util.stream.Collectors;

public class RoutedLoadBalancer extends LoadBalancer {
    @Override
    Destination balanceLoad(Request request) {
        List<Destination> destinationList = getDestinations(request).stream().collect(Collectors.toList());
        return destinationList.get(request.id.hashCode() % destinationList.size());
    }
}
