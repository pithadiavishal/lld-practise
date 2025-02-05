package lld.CustomMap;

public class MyHashMap<K,V>{

    private static final int INITIAL_CAPACITY = 1<<4;
    private static final int MAXIMUM_CAPACITY = 1<<30;

    public Entry<K,V>[] hashTable;

    public MyHashMap(){ hashTable = new Entry[INITIAL_CAPACITY];}

    public MyHashMap(int capacity){
        int tableSize  = getTableSizeForCapacity(capacity);
    }

    public V get(K key){
        int hashCode = key.hashCode() % hashTable.length;
        Entry<K,V> node = hashTable[hashCode];
        while (node != null){
            if(node.key.equals(key)) return node.value;
            node = node.next;
        }
        return null;
    }

    public void put(K key, V value){
        int hashCode = key.hashCode() % hashTable.length;
        Entry<K,V> node = hashTable[hashCode];
        if(node==null){
            Entry<K,V> newNode = new Entry<>(key,value);
            hashTable[hashCode] = newNode;
        }
        else{
            Entry<K,V> prevNode = node;
            while (node!=null){
                if(node.key.equals(key)){
                    node.value = value;
                    return;
                }
                prevNode = node;
                node = node.next;
            }
            prevNode.next = new Entry<>(key,value);
        }
    }

    private int getTableSizeForCapacity(int capacity){
        int n = capacity-1;
        n|=n>>>1;
        n|=n>>>2;
        n|=n>>>4;
        n|=n>>>8;
        n|=n>>>16;
        return (n<0) ? 1 : (n>=MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n+1;
    }
}

class Entry<K,V>{
    public K key;
    public V value;
    public Entry<K,V> next;

    public Entry(K key,V value){
        this.key = key;
        this.value = value;
    }

}
