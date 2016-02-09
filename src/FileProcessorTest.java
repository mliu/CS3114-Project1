import student.TestCase;

/**
 * @author jordanrw
 * @author mliu95
 * @version 1
 */

public class FileProcessorTest extends TestCase {
    
    private FileProcessor processor;
    
    // Set up the test case
    public void setUp() {
        processor = new FileProcessor();
    }
    
    // Test the file processor doesn't print anything
    // for an invalid command
    public void testWrongCommand() {
        processor.parseString("peanuts 7");
        assertFuzzyEquals("", systemOut().getHistory());
    }

}
