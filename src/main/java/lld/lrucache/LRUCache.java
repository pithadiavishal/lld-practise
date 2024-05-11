package lld.lrucache;

import java.util.*;

public class LRUCache {
    private int capacity;
    private Set<Integer> keys;
    private Deque<Integer> deque;
    public LRUCache(int capacity){
        this.capacity = capacity;
        this.keys = new HashSet<>();
        this.deque = new LinkedList<>();
    }

    public void refer(int key){
        if(keys.contains(key)) {
            deque.remove(key);
        }else{
            while(deque.size()==capacity){
                deque.removeFirst();
            }
        }
        deque.push(key);
        keys.add(key);
    }
}
