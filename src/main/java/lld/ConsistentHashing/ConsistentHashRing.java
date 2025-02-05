package lld.ConsistentHashing;

import java.util.SortedMap;
import java.util.TreeMap;

public class ConsistentHashRing implements MapClient{

    private final SortedMap<Integer,Server> hashRing;

    private int numberOfReplicas;

    private HashFunction hashFunction;

    public ConsistentHashRing(int numberOfReplicas, HashFunction hashFun) {
        this.hashRing = new TreeMap<>();
        this.numberOfReplicas = numberOfReplicas;
        this.hashFunction = hashFun;
    }

    @Override
    public boolean addServerToHashRing(Server server) {
        for(int i = 0 ; i < numberOfReplicas ; i++){
            String hashKey = server.ipAddress + "_" + i;
            Integer hashedValue = hashFunction.getHash(hashKey);
            this.hashRing.put(hashedValue,server);
        }
        return true;
    }

    @Override
    public boolean removeServerFromHashRing(Server server) {
        for(int i = 0 ; i < numberOfReplicas ; i++){
            String hashKey = server.ipAddress + "_" + i;
            Integer hashedValue = hashFunction.getHash(hashKey);
            Server serverToDelete = this.hashRing.get(hashedValue);
            this.hashRing.remove(hashedValue);

            serverToDelete.entryList.forEach(s->{
                put(s.getKey(),s.getValue());
            });
        }
        return true;
    }

    @Override
    public Server getServerFromGivenKey(String key) {
        if(hashRing.isEmpty()) return null;

        Integer hash = hashFunction.getHash(key);

        if(hashRing.containsKey(hash)) return hashRing.get(hash);

        Integer resultServer = hashRing.keySet().stream().filter(x->x>hash).findFirst().orElse(null);
        Server result_server = resultServer == null ? null : hashRing.get(resultServer);

        if(result_server==null){
            Integer serverWithMinHashKey = hashRing.keySet().stream().min(Integer::compare).orElse(null);
            result_server = hashRing.get(serverWithMinHashKey);
        }
        return result_server;
    }

    @Override
    public Boolean put(String k, String v) {
        // No Server is present on hashRing
        Server serverForGivenKey = getServerFromGivenKey(k);

        if (serverForGivenKey == null) {
            return Boolean.FALSE;
        }

        serverForGivenKey.addEntry(new Entry<>(k, v));
        return true;
    }

    @Override
    public Entry get(String k) {
        // No Server is present on hashRing
        Server serverForGivenKey = getServerFromGivenKey(k);

        if (serverForGivenKey == null) {
            return null;
        }

        return serverForGivenKey.findEntryForGivenKeys(k);
    }
}
