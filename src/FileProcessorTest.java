import student.TestCase;

/**
 * @author jordanrw
 * @author mliu95
 * @version 1
 */

public class FileProcessorTest extends TestCase {
    
    private FileProcessor processor;
    
    public void setUp() {
        processor = new FileProcessor();
    }
    
    public void testWrongCommand() {
        processor.parseString("peanuts 7");
        assertFuzzyEquals("", systemOut().getHistory());
    }

}
