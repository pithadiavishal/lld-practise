package lld.LoadBalancer;

import java.util.Set;

public class Service {
    String name;
    Set<Destination> destinations;

    public void addDestinations(Destination destination) {
        destinations.add(destination);
    }

    public void removeDestination(Destination destination) {
        destinations.remove(destination);
    }
}
