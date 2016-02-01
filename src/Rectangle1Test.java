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

    // ----------------------------------------------------------
    /**
     * This method is simply to get code coverage of the class declaration.
     */
    public void testRInit()
    {
        assertNotNull(rect);
        rect.main(null);
    }
    
    public void testFile() {
    	String[] param1 = { "SyntaxTest.txt" };
    	Object[] args = { param1 }; 
    	
    	this.main = getMethod(Rectangle1, "main", String[].class);
    	
    	try {
    		invokeEx(null, this.main, args[0]);
    	}
    	catch (Exception e) { 
    		e.printStackTrace();
    	}
    }
}
