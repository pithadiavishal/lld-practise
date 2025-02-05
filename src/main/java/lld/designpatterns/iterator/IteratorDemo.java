package lld.designpatterns.iterator;

public class IteratorDemo {
    public static void main(String[] args) {
        NamingRepository namingRepository = new NamingRepository();
        Iterator iterator = namingRepository.getIterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
