/**
 * 
 */

/**
 * @author jordanrw
 * @author mliu95
 */
public class FileProcessor {

	public FileProcessor() {
	
	}

	public void parseInsert(String[] args){
	    System.out.print("Rectangle inserted: ");
	}
	
	public void parseRegionsearch(String[] args) {
	    System.out.print("Regionsearch results: ");
	}
	
	public void parseRemove(String[] args) {
	    
	}
    
    public void parseSearch(String[] args) {
        
    }
    
    public void parseIntersections() {
        
    }
    
    public void parseDump() {
        
    }
    
	public void parseString(String str) {
	    String plusSpaceDelim = "[ +]+";
        String[] tokens = str.split(plusSpaceDelim);
        
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
