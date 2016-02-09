import student.TestCase;

/**
 * @author jordanrw
 * @author mliu95
 * @version 1
 */

public class RectangleTest extends TestCase {
    
    private Rectangle rect;
    
    public void setUp() {
        rect = new Rectangle("test", 1, 1, 5, 5);
    }
    
    public void testEquals() {
        Object blah = new Object();
        Rectangle rect2 = new Rectangle("test2", 1, 1, 5, 5)
        assertFalse(rect.equals(blah));
    }

}
