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
	private Class<?> Rectangle1; 
	private Method main;
	private Rectangle1 rect;
    /**
     * This method sets up the tests that follow.
     */
    public void setUp()
    {
    	try {
    		this.Rectangle1 = reloadClassForName("Rectangle1");
    	} 
    	catch (Throwable e) {
    		if (e instanceof Error) {
    			throw e;
    		} else {
    			throw new RuntimeException(e);
    		}
    	}
    }


    // ----------------------------------------------------------
    /**
     * This method is simply to get code coverage of the class declaration.
     */
    public void testRInit()
    {
        Rectangle1 dum = new Rectangle1();
        assertNotNull(dum);
    }
    
    public void testWrongArgCount() {
    	String[] param1 = { "SyntaxTest.txt" };
    	String[] param2 = { "SyntaxTest.txt" };
    	Object[] args = { param1, param2 }; 
    	
    	this.main = getMethod(this.Rectangle1, "main", String[].class);
    	
    	try {
    		invokeEx(null, this.main, args);
    	} 
    	catch (Exception e) { 
    		e.printStackTrace(); 
    	}
    }
}
