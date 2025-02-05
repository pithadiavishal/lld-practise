package lld.ConsistentHashing;

public interface MapClient {

    public boolean addServerToHashRing(Server server);

    public boolean removeServerFromHashRing(Server server);

    public Server getServerFromGivenKey(String key);

    public Boolean put(String k,String v);

    public Entry get(String k);
}
