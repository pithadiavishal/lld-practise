package lld.distributedcache;


public interface LoadBalancer {
    void addServer(CacheNode cacheNode);
    void removeServer(CacheNode cacheNode);
    CacheNode getServer(String key);
}
