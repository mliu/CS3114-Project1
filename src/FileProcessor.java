/**
 * 
 */

/**
 * @author jordanrw
 * @author mliu95
 * @version 1
 */
public class FileProcessor {

    /**
     * constructor for the FileProcessor
     */
    public FileProcessor() {

    }

    /**
     * Parses the insert command
     * @param args - string array of name x y w h
     */
    private void parseInsert(String[] args) {
        System.out.print("Rectangle inserted: (");

        for (int i = 1; i < args.length; i++) {
            System.out.print(args[i]);
            if (i != args.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println(")");
    }

    
    /**
     * Parses the regionSearch command
     * and prints out the parsed pieces
     * @param args - a string array of x, y
     */
    private void parseRegionsearch(String[] args) {
        System.out.println("Regionsearch results: ");
    }

    
    /**
     * Parses the remove command
     * @param args - a string array of either the name of rectangle
     * or the x y w h of a rectangle
     */
    private void parseRemove(String[] args) {
        if (args.length == 2) {
            System.out.println("Rectangle removed: ");
        }
        else {
            System.out.println("Rectangle removed: ");
        }
    }

    /**
     * parses the search command
     * @param args - string array containing the name of rectangle
     */
    private void parseSearch(String[] args) {
        System.out.println("Rectangles found: ");
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
        System.out.println("SkipList dump: ");
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
        }
    }
}
