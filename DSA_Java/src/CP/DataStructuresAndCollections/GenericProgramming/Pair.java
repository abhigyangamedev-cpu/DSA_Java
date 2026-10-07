package CP.DataStructuresAndCollections.GenericProgramming;

public class Pair<K,V> {

    private K key;
    private V value;

    public Pair() {}

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public Pair<K,V> setKey(K key) {
        this.key = key;
        return this;
    }

    public Pair<K,V> setValue(V value) {
        this.value = value;
        return this;
    }

    public static void main(String[] args){
        // Pair Example
        Pair<String,Integer> p1 = new Pair<>("id",2506666);

        System.out.println(p1.getKey());
        System.out.println(p1.getValue());

        p1.setKey("roll number");

        System.out.println(p1.getKey());
        System.out.println(p1.getValue());

    }
}
