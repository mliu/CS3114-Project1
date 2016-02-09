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
        Rectangle rect4 = new Rectangle("test4", 1, 1, 6, 5);
        Rectangle rect5 = new Rectangle("test5", 1, 2, 5, 5);
        Rectangle rect6 = new Rectangle("test6", 2, 1, 5, 5);
        
        assertFalse(rect.equals(blah));
        assertTrue(rect.equals(rect2));
        assertFalse(rect.equals(rect3));
        assertFalse(rect.equals(rect4));
        assertFalse(rect.equals(rect5));
        assertFalse(rect.equals(rect6));
    }
    
    /**
     * Tests the toString method of the rectangle
     */
    public void assertToString() {
        assertEquals("test, 1, 1, 5, 5", rect.toString());
    }
    
    /**
     * Tests the intersects method
     */
    public void testIntersects() {
        Rectangle rect2 = new Rectangle("t", 1, 0, 5, 5);
        Rectangle rect3 = new Rectangle("t2", 0, 100, 5, 5);
        Rectangle rect4 = new Rectangle("t3", 100, 100, 5, 1);
        
        assertTrue(rect.intersects(rect2));
        assertFalse(rect.intersects(rect3));
        assertFalse(rect.intersects(rect4));
    }

}
