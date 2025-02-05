package lld.ConsistentHashing;

import java.util.ArrayList;
import java.util.List;

public class Server {
    String ipAddress;

    public Server(String ipAddress) {
        this.ipAddress = ipAddress;
        this.entryList = new ArrayList<>();
    }



    List<Entry<String,String>> entryList;

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public List<Entry<String, String>> getEntryList() {
        return entryList;
    }

    public void setEntryList(List<Entry<String, String>> entryList) {
        this.entryList = entryList;
    }

    public void addEntry(Entry<String, String> entry){
        this.entryList.add(entry);
    }

    public void removeEntry(Entry<String, String> entry){
        this.entryList.remove(entry);
    }

    public Entry<String,String> findEntryForGivenKeys(String key){
       return this.entryList.stream().filter(x->x.key.equals(key)).findAny().orElse(null);
    }
}
