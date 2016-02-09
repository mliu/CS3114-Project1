/**
 * @author jordanrw
 * @author mliu95
 * @version 1
 * The KVPair class that is the element of the skipnodes in 
 * the skiplist
 * @param <K> A generic class that extends Comparable. Used as the key.
 * @param <E> A generic class that is used as the value.
 */
public class KVPair<K extends Comparable<K>, E> 
    implements Comparable<KVPair<K, E>> {

    /**
     * The key and value of this pair
     */
    private K key;
    private E value;
    
    /**
     * Constructor for KVPair
     * @param newKey - the key
     * @param newValue - the object or value
     */
    public KVPair(K newKey, E newValue) {
        key = newKey;
        value = newValue;
    }
    
    /**
     * compares a KVPair
     * @param it another KVPair to compare this KVPair to
     * @return 0 if the keys are equal, an integer less than 0 if
     * it is greater than this key, or an integer greater than 0 if
     * it is less than this key.
     */
    public int compareTo(KVPair<K, E> it) {
        return key.compareTo(it.key());
    }
    
    /**
     * Compares the key of this KVPair to the provided key
     * @param it the key to compare to
     * @return 0 if the keys are equal, an integer less than 0 if
     * it is greater than this key, or an integer greater than 0 if
     * it is less than this key.
     */
    public int compareTo(K it) {
        return key.compareTo(it);
    }
    
    /**
     * getter for key
     * @return key - the value of key
     */
    public K key() {
        return key;
    }
    
    /**
     * getter for the value
     * @return value the value of this KVPair
     */
    public E value() {
        return value;
    }
}
