
public class KVPair<String extends Comparable<String>, Rectangle> implements Comparable<KVPair<String, Rectangle>> {

    private String key;
    private Rectangle value;
    
    public KVPair(String newKey, Rectangle newValue) {
        key = newKey;
        value = newValue;
    }
    
    public int compareTo(KVPair<String, Rectangle> it) {
        return strcmp(key, it.key());
    }
}
