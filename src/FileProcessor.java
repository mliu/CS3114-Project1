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
        list = new SkipList();
    }
    
    /**
     * prints the command out
     * @param args - the array of values to consoled
     */
    private void printOut(String[] args) {

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
        
        //print what happened
        System.out.print("Rectangle inserted: (");
        this.printOut(args);
        
        //run the command
        String name = args[1];
        int x = Integer.parseInt(args[2]);
        int y = Integer.parseInt(args[3]);
        int w = Integer.parseInt(args[4]);
        int h = Integer.parseInt(args[5]);
        
        Rectangle rect = new Rectangle(name, x, y, w, h);
        KVPair<String, Rectangle> pair = new KVPair(name, rect);
        list.insert(pair);
    }

    
    /**
     * Parses the regionSearch command
     * and prints out the parsed pieces
     * @param args - a string array of x, y
     */
    private void parseRegionsearch(String[] args) {
        System.out.print("Regionsearch results: (");
        this.printOut(args);
        
        int x = Integer.parseInt(args[1]);
        int y = Integer.parseInt(args[2]);
        int w = Integer.parseInt(args[3]);
        int h = Integer.parseInt(args[4]);
    }

    
    /**
     * Parses the remove command
     * @param args - a string array of either the name of rectangle
     * or the x y w h of a rectangle
     */
    private void parseRemove(String[] args) {
        if (args.length == 2) {
            System.out.print("Rectangle removed: (");
            this.printOut(args);
            
            String name = args[1];
        }
        else {
            System.out.print("Rectangle removed: (");
            this.printOut(args);
            
            int x = Integer.parseInt(args[1]);
            int y = Integer.parseInt(args[2]);
            int w = Integer.parseInt(args[3]);
            int h = Integer.parseInt(args[4]);
        }
    }

    /**
     * parses the search command
     * @param args - string array containing the name of rectangle
     */
    private void parseSearch(String[] args) {
        System.out.println("Rectangles found:");
        
        String name = args[1];
        ArrayList<Rectangle> rectList = list.search(name);
        
        if (rectList == null) {
            System.out.println("Rectangle not found: " + name);
            return;
        }

        for(int i = 0; i < rectList.size(); i++) {
            rectList.get(i).toString();
        }
    }

    /**
     * parses the intersection command
     */
    private void parseIntersections() {
        System.out.println("Intersection pairs: ");
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
