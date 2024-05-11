package lld.distributedcache;

public class HashFunction {
    public int getHash(String input){
        int hash = 7;

        for(int i = 0 ; i < input.length() ; i++){
            hash = 31*hash + input.charAt(i);
        }
        return hash;
    }
}
