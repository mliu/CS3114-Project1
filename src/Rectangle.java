
public class Rectangle {

    public int x, y, width, height;
    public String name;
    
    public Rectangle(String newName, int xPos, int yPos, int w, int h) {
        name = newName;
        x = xPos;
        y = yPos;
        width = w;
        height = h;
    }
    
    public String toString() {
        return "(" + x + ", " + y + ", " + width + ", " + height + ")";
    }

}
