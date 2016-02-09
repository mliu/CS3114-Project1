import student.TestCase;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author jordanrw
 * @author mliu95
 * @version 1
 */

public class SkipListTest extends TestCase {
    
    private SkipList list;
    
    /**
     * Sets up the test case
     */
    public void setUp() {
        list = new SkipList();
    }
    
    /**
     * Helper method used to add rectangles to an empty SkipList
     */
    private void addValidStuff() {
        Rectangle rect1 = new Rectangle("rect1", 2, 2, 4, 4);
        Rectangle rect2 = new Rectangle("rect2", 2, 2, 4, 4);
        Rectangle rect3 = new Rectangle("rect3", 1, 1, 2, 2);
        Rectangle rect4 = new Rectangle("sameName", 300, 300, 10, 10);
        Rectangle rect5 = new Rectangle("rect5", 0, 0, 1024, 100);
        Rectangle rect6 = new Rectangle("sameName", 50, 50, 5, 5);
        
        KVPair kv1 = new KVPair("rect1", rect1);
        KVPair kv2 = new KVPair("rect2", rect2);
        KVPair kv3 = new KVPair("rect3", rect3);
        KVPair kv4 = new KVPair("sameName", rect4);
        KVPair kv5 = new KVPair("rect5", rect5);
        KVPair kv6 = new KVPair("sameName", rect6);
        
        
        list.insert(kv1);
        list.insert(kv2);
        list.insert(kv3);
        list.insert(kv4);
        list.insert(kv5);
        list.insert(kv6);
    }
    
    /**
     * Tests the insert method of the skiplist
     */
    public void testInsert() {
        Rectangle rect1 = new Rectangle("rect1", 2, 2, 4, 4);
        Rectangle rect2 = new Rectangle("rect2", -1, -1, 4, 4);
        Rectangle rect3 = new Rectangle("rect3", 2, -1, 4, 4);
        Rectangle rect4 = new Rectangle("rect4", 0, 0, 1025, 100);
        Rectangle rect5 = new Rectangle("rect5", 1, 1, -3, 4);
        Rectangle rect6 = new Rectangle("rect6", 2, 1, -5, -5);
        
        KVPair kv1 = new KVPair("rect1", rect1);
        KVPair kv2 = new KVPair("rect2", rect2);
        KVPair kv3 = new KVPair("rect3", rect3);
        KVPair kv4 = new KVPair("rect4", rect4);
        KVPair kv5 = new KVPair("rect5", rect5);
        KVPair kv6 = new KVPair("rect6", rect6);
        
        list.insert(kv1);
        list.insert(kv2);
        list.insert(kv3);
        list.insert(kv4);
        list.insert(kv5);
        list.insert(kv6);
        
        assertEquals(6, list.getSize());
    }
    
    /**
     * Tests the intersections method of the skiplist
     */
    public void testIntersections() {
        this.addValidStuff();
        ArrayList<Rectangle> rectList = list.intersections();
        
        assertEquals(14, rectList.size());
    }
    
    /**
     * Tests the skiplist search by name functionality
     */
    public void testSearch() {
        this.addValidStuff();
        
        ArrayList<Rectangle> rectList = new ArrayList();
        String sameName = "sameName";
        rectList = list.search(sameName);
        
        ArrayList<Rectangle> rectList2 = list.search("aaaa");
        ArrayList<Rectangle> rectList3 = list.search("rect3");
        
        assertEquals(1, rectList3.size());
        assertEquals(null, rectList2);
        assertEquals(2, rectList.size());
    }
    
    /**
     * Tests the skiplist regionsearch method
     */
    public void testRegionSearch() {
        
        this.addValidStuff();
        ArrayList<Rectangle> rectList = list.regionSearch(3, 3, 3, 3);
        
        assertEquals(4, rectList.size());
        
        ArrayList<Rectangle> rectList2 = list.regionSearch(65, 65, 5, 10);
        
        assertEquals(1, rectList2.size());
    }
    
    /**
     * Tests the skiplist remove by name method
     */
    public void testRemoveName() {
        this.addValidStuff();
        
        list.remove("rect1");
        list.remove("rect1");
        
        assertEquals(5, list.getSize());
        
        list.remove("rect5");
        
        assertEquals(4, list.getSize());
        
        list.remove("rect3");
        list.remove("rect2");
        list.remove("sameName");
        list.remove("sameName");
        
        assertEquals(0, list.getSize());
    }
    
    /**
     * Tests the skiplist remove by coordinates method
     */
    public void testRemoveCoordinates() {
        this.addValidStuff();
        
        Rectangle test = new Rectangle("", 2, 2, 4, 4);
        
        list.remove(test);
        list.remove(test);
        list.remove(test);
        
        assertEquals(4, list.getSize());
        
        Rectangle test2 = new Rectangle("", 0, 0, 1024, 100);
        
        list.remove(test2);
        
        assertEquals(3, list.getSize());
    }
    
    /**
     * Tests the dump method of the skiplist
     */
    public void testDump() {
//      Random rand = new Random();
//      int random = rand.nextInt(1);
        this.addValidStuff();
    
        list.dump();
        
//      assertFuzzyEquals("SkipList dump:"
//              + "Node has depth 4, Value (\"rect1\", 2, 2, 4, 4)"
//              + "Node has depth 1, Value (\"rect2\", 2, 2, 4, 4)"
//              + "Node has depth 1, Value (\"rect3\", 1, 1, 2, 2)"
//              + "Node has depth 3, Value (\"rect4\", 300, 300, 10, 10)"
//              + "Node has depth 4, Value (\"rect5\", 0, 0, 1024, 100)"
//              + "Node has depth 2, Value (\"rect6\", 50, 50, 5, 5)","
//                + "systemOut().getHistory());
        
        assertEquals(6, list.getSize());
    }
    
}