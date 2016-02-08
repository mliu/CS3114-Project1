
public class Rectangle {

    public int x;
    public int y;
    public int width;
    public int height;
    public String name;
    
    public Rectangle(String newName, int xPos, int yPos, int w, int h) {
        name = newName;
        x = xPos;
        y = yPos;
        width = w;
        height = h;
    }
    
    public String toString() {
        return "(" + name + ", " + x + ", " + y + 
                ", " + width + ", " + height + ")";
    }
    
    public int compareTo(Rectangle rect) {
        
    }

}
