
public class KVPair<String extends Comparable<String>, Rectangle> implements Comparable<KVPair<String, Rectangle>> {

    private String key;
    private Rectangle value;
    
    public KVPair(String newKey, Rectangle newValue) {
        key = newKey;
        value = newValue;
    }
    
    public int compareTo(KVPair<String, Rectangle> it) {
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
    
    public String toString() {
        return key + ", " + Rectangle.toString();
    }
}
