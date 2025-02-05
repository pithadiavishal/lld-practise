package lld.designpatterns.iterator;

public class NamingRepository implements Container {
    String[] names = new String[]{"n1", "n2", "n3", "n4"};
    @Override
    public Iterator getIterator() {
        return new NameIterator();
    }
    private class NameIterator implements Iterator {
        int index;
        public NameIterator() {
            index = 0;
        }
        @Override
        public boolean hasNext() {
            return index<names.length;
        }

        @Override
        public Object next() {
            if(hasNext()){
                return names[index++];
            }
            return null;
        }
    }
}
