import student.TestCase;

/**
 * @author jordanrw
 * @author mliu95
 * @version 1
 */
public class KVPairTest extends TestCase {
    
    private KVPair pair;
    
    /**
     * Helper method for the tests. Creates generic KVPair
     */
    public void setUp() {
        pair = new KVPair("hello", 5);
    }
    
    /**
     * Tests the compare to method of the KVPair
     */
    public void testCompareTo() {
        KVPair pair2 = new KVPair("hello", 3);
        String pair3 = "hello";
        
        assertEquals(0, pair.compareTo(pair2));
        assertEquals(0, pair.compareTo(pair3));
    }
}
