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
        pair2 = new KVPair("hello", 3);
        pair3 = new KVPair("hea", 5);
        
        assertTrue(pair.compareTo(pair2));
        assertFalse(pair.compareTo(pair3));
    }
}
