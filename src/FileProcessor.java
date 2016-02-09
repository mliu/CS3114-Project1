import java.util.ArrayList;

/**
 * 
 */

/**
 * @author jordanrw
 * @author mliu95
 * @version 1
 */
public class FileProcessor {

    private SkipList<String, Rectangle> list;
    /**
     * constructor for the FileProcessor
     */
    public FileProcessor() {
        list = new SkipList<String, Rectangle>();
    }
    
    /**
     * prints the command out
     * @param args - the array of values to consoled
     */
    private void printOut(String[] args) {
        System.out.print("(");
        for (int i = 1; i < args.length; i++) {
            System.out.print(args[i]);
            if (i != args.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println(")");
    }

    
    /**
     * Parses the insert command
     * @param args - string array of name x y w h
     */
    private void parseInsert(String[] args) {        
        //run the command
        String name = args[1];
        int x = Integer.parseInt(args[2]);
        int y = Integer.parseInt(args[3]);
        int w = Integer.parseInt(args[4]);
        int h = Integer.parseInt(args[5]);
        
        // Check for rejections
        if (w <= 0 || h <= 0 || (x + w > 1024) || (x + w < 0) ||
                (y + h > 1024) || (y + h < 0)) {
            System.out.print("Rectangle rejected: (");
            this.printOut(args);
            return;
        }
        
        Rectangle rect = new Rectangle(name, x, y, w, h);
        KVPair<String, Rectangle> pair = new KVPair<String, Rectangle>(name, rect);
        if (list.insert(pair)) {
            System.out.print("Rectangle inserted: (");
            this.printOut(args);
        }
    }

    
    /**
     * Parses the regionSearch command
     * and prints out the parsed pieces
     * @param args - a string array of x, y
     */
    private void parseRegionsearch(String[] args) {
        int x = Integer.parseInt(args[1]);
        int y = Integer.parseInt(args[2]);
        int w = Integer.parseInt(args[3]);
        int h = Integer.parseInt(args[4]);
        
        if (w <= 0 || h <= 0) {
            System.out.println("Rectangle rejected: (" + x + ", " + y + ", " + w + ", " + h + ")");
            return;
        }
        
        ArrayList<Rectangle> rectList = list.regionSearch(x, y, w, h);

        System.out.println("Rectangles intersecting region (" + x + ", " + y + ", " + w + ", " + h + "):");
        for (int i = 0; i < rectList.size(); i++) {
            System.out.println(rectList.get(i).toString());
        }
    }

    
    /**
     * Parses the remove command
     * @param args - a string array of either the name of rectangle
     * or the x y w h of a rectangle
     */
    private void parseRemove(String[] args) {
        if (args.length == 2) {         
            String name = args[1];
            
            Rectangle rect = list.remove(name);
            
            if (rect == null) {
                System.out.println("Rectangle not removed: " + name);
                return;
            }
            
            System.out.println("Rectangle removed: " + rect.toString());
        }
        else {            
            int x = Integer.parseInt(args[1]);
            int y = Integer.parseInt(args[2]);
            int w = Integer.parseInt(args[3]);
            int h = Integer.parseInt(args[4]);
            
            // Check for rejections
            if (w <= 0 || h <= 0 || (x + w > 1024) || (x + w < 0) ||
                    (y + h > 1024) || (y + h < 0)) {
                System.out.print("Rectangle rejected: (");
                this.printOut(args);
                return;
            }
            
            Rectangle temp = new Rectangle("", x, y, w, h);
            Rectangle rect = list.remove(temp);
            
            if (rect == null) {
                System.out.println("Rectangle not found: (" + x + ", " + y +
                        ", " + w + ", " + h + ")");
                return;
            }
            
            System.out.println("Rectangle removed: " + rect.toString());
        }
    }

    /**
     * parses the search command
     * @param args - string array containing the name of rectangle
     */
    private void parseSearch(String[] args) {        
        String name = args[1];
        ArrayList<Rectangle> rectList = list.search(name);
        
        if (rectList == null) {
            System.out.println("Rectangle not found: " + name);
            return;
        }

        System.out.println("Rectangles found:");
        for (int i = 0; i < rectList.size(); i++) {
            System.out.println(rectList.get(i).toString());
        }
    }

    /**
     * parses the intersection command
     */
    private void parseIntersections() {
        System.out.println("Intersection pairs: ");
        
        ArrayList<Rectangle[]> rectList = list.intersections();
        
        for(int i = 0; i < rectList.size(); i++) {
            System.out.println(rectList.get(i)[0].toString() + "|" + rectList.get(i)[1].toString());
        }
    }

    /**
     * parses the dump command
     */
    private void parseDump() {
        System.out.println("SkipList dump:");
        list.dump();
    }

    
    /**
     * The initial method which is called from outside the class
     * It uses a deliminator and then passes on that string array
     * to another method inside this class for further parsing
     * @param str - a whole line from the input file
     */
    public void parseString(String str) {
        String plusSpaceDelim = "[ +]+";
        String[] tokens = str.trim().split(plusSpaceDelim);

        switch(tokens[0]) {
            case "insert":
                parseInsert(tokens);
                break;
            case "remove":
                parseRemove(tokens);
                break;
            case "regionsearch":
                parseRegionsearch(tokens);
                break;
            case "search":
                parseSearch(tokens);
                break;
            case "intersections":
                parseIntersections();
                break;
            case "dump":
                parseDump();
                break;
            default:
                break;
        }
    }
}
