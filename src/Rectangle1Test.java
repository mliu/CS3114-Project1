import student.TestCase;

/**
 * @author ayaan
 * @version 2
 */
public class Rectangle1Test
    extends TestCase
{
	private Rectangle1 rect;
    /**
     * This method sets up the tests that follow.
     */
    public void setUp()
    {
        rect = new Rectangle1();
    }


    // ----------------------------------------------------------
    /**
     * This method is simply to get code coverage of the class declaration.
     */
    public void testRInit()
    {
        Rectangle1 dum = new Rectangle1();
        assertNotNull(dum);
        Rectangle1.main(null);
        assertFuzzyEquals("Hello, World\n", systemOut().getHistory());
    }
    
    public void testWrongArgCount() {
    	String[] params = { "SyntaxTest.txt" };
    	Object[] args = { params }; try {
    	invokeEx(null, this.main, args[0]);
    	} catch (Exception e) { e.printStackTrace(); }
    }
}
