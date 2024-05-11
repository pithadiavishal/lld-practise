package lld.distributedcache;

import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class ConsistentHashing implements LoadBalancer{
    private SortedMap<Integer, CacheNode> cacheRing;
    private final HashFunction hashFunction;
    private final int noOfReplicas;

    public ConsistentHashing(HashFunction hashFunction, int noOfReplicas){
        this.cacheRing = new TreeMap<>();
        this.hashFunction = hashFunction;
        this.noOfReplicas = noOfReplicas;
    }

    @Override
    public void addServer(CacheNode cacheNode) {
        for(int i=0;i<noOfReplicas;i++){
            int hashKey = hashFunction.getHash(cacheNode.getIpAddress() + "_" + i);
            cacheRing.put(hashKey, cacheNode);
        }
    }

    @Override
    public void removeServer(CacheNode cacheNode) {
        for(int i=0;i<noOfReplicas;i++){
            int hasKey = hashFunction.getHash(cacheNode.getIpAddress() + "_" + i);
            cacheRing.remove(hasKey);
        }
    }

    @Override
    public CacheNode getServer(String key) {
        int hashKey = hashFunction.getHash(key);
        SortedMap<Integer, CacheNode> tailMap = cacheRing.tailMap(hashKey);
        int nodeHash = tailMap.isEmpty()?cacheRing.firstKey():tailMap.firstKey();
        return cacheRing.get(nodeHash);
    }
}
