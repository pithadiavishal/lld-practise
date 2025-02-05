package lld.LoadBalancer;

public class LoadBalancerFactory {
    public static LoadBalancer createLoadBalancer(String loadBalType) {
        LoadBalancer loadBalancer = null;
        switch (loadBalType){
            case "round-robin" : loadBalancer = new RoundRobinLoadBalancer();
            break;
            case "least-connection" : loadBalancer = new LeastConnectionLoadBalancer();
            break;
            default: loadBalancer = new RoutedLoadBalancer();
        }
        return loadBalancer;
    }
}
