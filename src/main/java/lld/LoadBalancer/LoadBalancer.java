package lld.LoadBalancer;

/**
 * courtesy
 * https://github.com/InterviewReady/Low-Level-Design/blob/main/LoadBalancer.java
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public abstract class LoadBalancer {

    Map<RequestType, Service> serviceMap = new HashMap<>();

    abstract Destination balanceLoad(Request request);

    public void register(RequestType requestType, Service service) {
        serviceMap.put(requestType, service);
    }

    Set<Destination> getDestinations(Request request) {
        Service service = serviceMap.get(request.requestType);
        return service.destinations;
    }


}
