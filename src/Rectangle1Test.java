import student.TestCase;

/**
 * @author ayaan
 * @version 2
 */
public class Rectangle1Test
    extends TestCase
{

    /**
     * This method sets up the tests that follow.
     */
    public void setUp()
    {
        // Nothing here yet
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

}
