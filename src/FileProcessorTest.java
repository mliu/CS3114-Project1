import student.TestCase;

/**
 * @author jordanrw
 * @author mliu95
 * @version 1
 */

public class FileProcessorTest extends TestCase {
    
    private FileProcessor processor;
    
    /**
     * Set up the test case
     */
    public void setUp() {
        processor = new FileProcessor();
    }
    
    /**
     * Tests that the file processor doesn't print anything
     * for an invalid command
     */
    public void testWrongCommand() {
        processor.parseString("peanuts 7");
        assertFuzzyEquals("", systemOut().getHistory());
    }
    
    public void testInsert() {
        processor.parseString("insert test 1 1 1 1");
        assertFuzzyEquals("Rectangle inserted: (test, 1, 1, 1, 1)", systemOut().getHistory());
        
        processor.parseString("insert test 1 1 0 1");
        assertTrue(systemOut().getHistory().contains("Rectangle rejected"));
        
        processor.parseString("insert test 1 1 1 0");
        assertTrue(systemOut().getHistory().contains("Rectangle rejected"));
    }
}
