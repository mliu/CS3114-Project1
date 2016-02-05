
public class Rectangle {

    public int x, y, width, height;
    
    public Rectangle(int xPos, int yPos, int w, int h) {
        x = xPos;
        y = yPos;
        width = w;
        height = h;
    }
    
    public String toString() {
        return "(" + x + ", " + y + ", " + width + ", " + height + ")";
    }

}
