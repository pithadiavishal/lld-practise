package lld.distributedcache;

import java.util.*;

public class CacheNode {
    // cache with lru stategy
    private final String ipAddress;
    private Map<String, Object> cache;
    private Deque<String> deque;
    private int capacity;

    public CacheNode(String ipAddress, int capacity){
        this.ipAddress = ipAddress;
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.deque = new LinkedList<>();
    }

    public void put(String key, Object value){
        System.out.println(String.format("adding value with key: %s in cache node with ip: %s", key, ipAddress));
        if(cache.containsKey(key)){
            cache.remove(key);
            deque.remove(key);
        }
        if(deque.size()>capacity){
            deque.removeFirst();
        }
        cache.put(key, value);
        deque.offerLast(key);
    }

    public Object get(String key){
        System.out.println(String.format("fetching value with key: %s in cache node with ip: %s", key, ipAddress));
        Object value = null;
        if(cache.containsKey(key)){
            value = cache.get(key);
            deque.remove(key);
            deque.offerLast(key);
        }
        return value;
    }

    public String getIpAddress(){
        return this.ipAddress;
    }
}
