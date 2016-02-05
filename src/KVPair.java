
public class KVPair implements Comparable<KVPair> {

    private String key;
    private Rectangle value;
    
    public KVPair(String newKey, Rectangle newValue) {
        key = newKey;
        value = newValue;
    }
    
    public int compareTo(KVPair it) {
        return key.compareTo(it.key());
    }
    
    public int compareTo(String it) {
        return key.compareTo(it);
    }
    
    public String key() {
        return key;
    }
    
    public Rectangle value() {
        return value;
    }
    
    public java.lang.String toString() {
        return key + ", " + value.toString();
    }
}
