/**
 * The KVPair for the program
 * 
 * @author jordanrw
 * @author mliu95
 * @version 1
 * 
 * @param K generic class for a key that extends Comparable
 * @param E generic class for a value
 */
public class KVPair<K extends Comparable<K>, E> 
    implements Comparable<KVPair<K, E>> {

    /**
     * The key and value of this pair
     */
    private K key;
    private E value;
    
    /**
     * Comstructor for KVPair
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
