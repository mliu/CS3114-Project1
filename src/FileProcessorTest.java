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
    
    /**
     * Test the insert command
     */
    public void testInsert() {
        processor.parseString("insert test 1 1 1 1");
        assertFuzzyEquals("Rectangle inserted: (test, 1, 1, 1, 1)", 
                systemOut().getHistory());
        
        processor.parseString("insert test 1 1 0 1");
        assertTrue(systemOut().getHistory().contains("Rectangle rejected"));
        
        processor.parseString("insert test 1 1 1 0");
        assertTrue(systemOut().getHistory().contains("Rectangle rejected"));
        
        processor.parseString("insert test 1 1 1025 1");
        assertTrue(systemOut().getHistory().contains("Rectangle rejected"));
        
        processor.parseString("insert test -5 1 1 1");
        assertTrue(systemOut().getHistory().contains("Rectangle rejected"));
        
        processor.parseString("insert test 1 1 1 1025");
        assertTrue(systemOut().getHistory().contains("Rectangle rejected"));
        
        processor.parseString("insert test 1 -5 1 1");
        assertTrue(systemOut().getHistory().contains("Rectangle rejected"));
        
        processor.parseString("insert test -1 1 5 1");
        assertTrue(systemOut().getHistory().contains("Rectangle rejected"));
        
        processor.parseString("insert test 1 -1 1 5");
        assertTrue(systemOut().getHistory().contains("Rectangle rejected"));
    }
    
    /**
     * Test the search command
     */
    public void testSearch() {
        processor.parseString("search test");
        assertTrue(systemOut().getHistory().contains("Rectangle not found"));
        
        processor.parseString("insert test 1 1 1 1");
        processor.parseString("search test");
        assertTrue(systemOut().getHistory().contains("Rectangles found"));
    }
    
    /**
     * Test the remove command
     */
    public void testRemove() {
        processor.parseString("remove test");
        assertTrue(systemOut().getHistory().contains("Rectangle not removed"));
        
        processor.parseString("insert test 1 1 1 1");
        processor.parseString("remove test");
        assertTrue(systemOut().getHistory().contains("Rectangle removed"));
        
        processor.parseString("remove 1 1 0 1");
        assertTrue(systemOut().getHistory().contains("Rectangle rejected"));
        
        processor.parseString("remove 1 1 1 0");
        assertTrue(systemOut().getHistory().contains("Rectangle rejected"));
        
        processor.parseString("remove 1 1 1025 1");
        assertTrue(systemOut().getHistory().contains("Rectangle rejected"));
        
        processor.parseString("remove -5 1 1 1");
        assertTrue(systemOut().getHistory().contains("Rectangle rejected"));
        
        processor.parseString("remove 1 1 1 1025");
        assertTrue(systemOut().getHistory().contains("Rectangle rejected"));
        
        processor.parseString("remove 1 -5 1 1");
        assertTrue(systemOut().getHistory().contains("Rectangle rejected"));
        
        processor.parseString("remove -1 1 5 1");
        assertTrue(systemOut().getHistory().contains("Rectangle rejected"));
        
        processor.parseString("remove  1 -1 1 5");
        assertTrue(systemOut().getHistory().contains("Rectangle rejected"));
        
        processor.parseString("remove  1 1 1 5");
        assertTrue(systemOut().getHistory().contains("Rectangle not found"));
        
        processor.parseString("insert test 1 1 1 5");
        processor.parseString("remove  1 1 1 5");
        assertTrue(systemOut().getHistory().contains("Rectangle removed"));
    }
}
