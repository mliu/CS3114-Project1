/**
 *
 */
//package Tests;

import java.lang.reflect.Method;
import student.TestCase;
import student.testingsupport.annotations.Hint;
import student.testingsupport.annotations.ScoringWeight;

import static student.testingsupport.ReflectionSupport.*;

/**
 * @author ayaan
 *
 */
public class Rectangle1Test extends TestCase {
	private Class<?> Rectangle1;
	private Method main;

	public void setUp() {

	}

	@Hint("Please check the format and syntax of your output.")
	@ScoringWeight(0.0)
	public void testRectangle1() {
		try {
			this.Rectangle1 = reloadClassForName("Rectangle1");
		} catch (Throwable e) {
			if (e instanceof Error) {
				throw e;
			} else {
				throw new RuntimeException(e);
			}
		}

		this.main = getMethod(this.Rectangle1, "main", String[].class);

		String[] params = { "SyntaxTest.txt" };
		Object[] args = { params };

		try {
			invokeEx(null, this.main, args[0]);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
