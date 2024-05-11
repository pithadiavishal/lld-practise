package lld.distributedcache;

public class CacheClient {
    private LoadBalancer loadBalancer;

    public CacheClient(LoadBalancer loadBalancer){
        this.loadBalancer = loadBalancer;
    }

    public void put(String key, Object value){
        CacheNode cacheNode = this.loadBalancer.getServer(key);
        cacheNode.put(key, value);
    }

    public Object get(String key){
        CacheNode cacheNode = this.loadBalancer.getServer(key);
        return cacheNode.get(key);
    }
}
