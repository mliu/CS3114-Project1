
public class KVPair<K extends Comparable<K>, E> 
    implements Comparable<KVPair<K, E>> {

    private K key;
    private E value;
    
    public KVPair(K newKey, E newValue) {
        key = newKey;
        value = newValue;
    }
    
    public int compareTo(KVPair<K, E> it) {
        return key.compareTo(it.key());
    }
    
    public int compareTo(K it) {
        return key.compareTo(it);
    }
    
    public K key() {
        return key;
    }
    
    public E value() {
        return value;
    }
    
    public String toString() {
        return key.toString() + ", " + value.toString();
    }
}
