
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
        return name + ", " + x + ", " + y + 
                ", " + width + ", " + height;
    }
    
    public boolean equals(Rectangle rect) {
        return (x == rect.x && y == rect.y && width == rect.width && height == rect.height);
    }
    
    public boolean intersects(Rectangle rect) {
        return ((rect.x + rect.width) < x || (x + width) < rect.x || (rect.y + rect.height) < y || (y + height) < rect.y);
    }

}
