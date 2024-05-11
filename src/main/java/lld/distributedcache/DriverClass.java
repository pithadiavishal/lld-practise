package lld.distributedcache;

public class DriverClass {


    public static void main(String[] args) {
        HashFunction hashFunction = new HashFunction();
        LoadBalancer loadBalancer = new ConsistentHashing(hashFunction, 3);
        CacheClient cacheClient = new CacheClient(loadBalancer);

        CacheNode cacheNode1 = new CacheNode("107.109.204.1", 10);
        CacheNode cacheNode2 = new CacheNode("207.109.204.2", 10);
        CacheNode cacheNode3 = new CacheNode("307.109.204.3", 10);

        loadBalancer.addServer(cacheNode1);
        loadBalancer.addServer(cacheNode2);
        loadBalancer.addServer(cacheNode3);

        cacheClient.put("name", "vishal");
        cacheClient.put("age", "26");
        cacheClient.put("profession", "sse");
        System.out.println(cacheClient.get("name"));
        System.out.println(cacheClient.get("age"));
        System.out.println(cacheClient.get("profession"));
    }
}
