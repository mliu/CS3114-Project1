import student.TestCase;

/**
 * @author jordanrw
 * @author mliu95
 * @version 1
 */
public class RectangleTest extends TestCase {
    
    private Rectangle rect;
    
    /**
     * Helper method for the tests. Creates generic rectangle
     */
    public void setUp() {
        rect = new Rectangle("test", 1, 1, 5, 5);
    }
    
    /**
     * Tests the equals method of the rectangle
     */
    public void testEquals() {
        Object blah = new Object();
        Rectangle rect2 = new Rectangle("test2", 1, 1, 5, 5);
        Rectangle rect3 = new Rectangle("test3", 1, 1, 5, 6);
        
        assertFalse(rect.equals(blah));
        assertTrue(rect.equals(rect2));
        assertFalse(rect.equals(rect3));
    }
    
    /**
     * Tests the toString method of the rectangle
     */
    public void assertToString() {
        assertEquals("test, 1, 1, 5, 5", rect.toString());
    }

}
