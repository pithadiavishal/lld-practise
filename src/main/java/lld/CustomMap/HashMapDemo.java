package lld.CustomMap;

public class HashMapDemo {

    public static void main(String[] args) {
        MyHashMap<String,String> map = new MyHashMap<>();
        map.put("1","300");
        System.out.println(map.get("1"));

        map.put("1","Nitin");
        System.out.println(map.get("1"));
    }
}
