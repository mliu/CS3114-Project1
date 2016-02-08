
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
        return (Math.abs(x - rect.x) * 2 < (width + rect.width)) &&
                (Math.abs(y - rect.y) * 2 < (height + rect.height));
    }

}
