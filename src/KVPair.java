/**
 * The KVPair for the program
 * 
 * @author jordanrw
 * @author mliu95
 * @version 1
 */
public class KVPair<K extends Comparable<K>, E> 
    implements Comparable<KVPair<K,E>> {

    private K key;
    private E value;
    
    /**
     * Costructor for KVPair
     * @param newKey - the key
     * @param newValue - the object or value
     */
    public KVPair(K newKey, E newValue) {
        key = newKey;
        value = newValue;
    }
    
    /**
     * compares a KVPair
     */
    public int compareTo(KVPair<K,E> it) {
        return key.compareTo(it.key());
    }
    
    /**
     * compares a key to the 
     * @param it - what to compare to key
     * @return
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
     * @return value
     */
    public E value() {
        return value;
    }
    
    /**
     * @return a string of all the fields 
     */
    public String toString() {
        return key.toString() + ", " + value.toString();
    }
}
