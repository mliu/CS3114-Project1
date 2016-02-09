import java.lang.reflect.Method;

import student.TestCase;
import static student.testingsupport.ReflectionSupport.*;

/**
 * @author ayaan
 * @version 2
 */
public class Rectangle1Test
    extends TestCase
{
    private Method main;
    private Rectangle1 rect;
    
    /**
     * This method sets up the tests that follow.
     */
    public void setUp()
    {
        rect = new Rectangle1();
    }

    /**
     * Tests that Rectangle1 opens up the proper test file
     */
    public void testFile() {
        String[] param1 = { "SyntaxTest.txt" };
        Object[] args = { param1 }; 

        try {
            Rectangle1.main(param1);
        }
        catch (Exception e) { 
            e.printStackTrace();
        }
    }
}
