package lld.LoadBalancer;

import java.util.Arrays;
import java.util.HashSet;

public class LoadBalancerDemo {
    public static void main(String[] args) {
        Service service = new Service();
        service.name=RequestType.GROUP.toString();
        service.destinations  = new HashSet<>(Arrays.asList(new Destination("107.109.204.52"), new Destination("107.109.204.53"), new Destination("107.109.204.54")));
        LoadBalancer loadBalancer = LoadBalancerFactory.createLoadBalancer("round-robin");
        loadBalancer.register(RequestType.GROUP, service);
        System.out.println(loadBalancer.balanceLoad(new Request("1", RequestType.GROUP)).ipAddress);
        System.out.println(loadBalancer.balanceLoad(new Request("2", RequestType.GROUP)).ipAddress);
        System.out.println(loadBalancer.balanceLoad(new Request("3", RequestType.GROUP)).ipAddress);
        System.out.println(loadBalancer.balanceLoad(new Request("4", RequestType.GROUP)).ipAddress);
        System.out.println(loadBalancer.balanceLoad(new Request("5", RequestType.GROUP)).ipAddress);
        System.out.println(loadBalancer.balanceLoad(new Request("6", RequestType.GROUP)).ipAddress);
        System.out.println(loadBalancer.balanceLoad(new Request("7", RequestType.GROUP)).ipAddress);
    }
}
