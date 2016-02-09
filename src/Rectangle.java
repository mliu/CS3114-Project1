/**
 * Rectangle holds the values of a rectangle
 * 
 * @author jordanrw
 * @author mliu95
 * @version 1
 */
public class Rectangle {

    public int x, y, width, height;
    public String name;
    
    /**
     * Constructor of the Rectangle
     * 
     * @param newName - string of the rectangle
     * @param xPos - x of rectangle
     * @param yPos - y of rectangle
     * @param w - width of rectangle
     * @param h - height of rectangle
     */
    public Rectangle(String newName, int xPos, int yPos, int w, int h) {
        name = newName;
        x = xPos;
        y = yPos;
        width = w;
        height = h;
    }
    
    /**
     * Equality checker
     * @param rect The Rectangle to check equality for
     * @return true if the two rectangles share the same x, y, w, and h. Otherwise false.
     */
    public boolean equals(Rectangle rect) {
        return (x == rect.x && y == rect.y && 
                width == rect.width && height == rect.height);
    }
    
    /**
     * toString for Rectangle
     * @return string of rectangles values
     */
    public String toString() {
        return "(" + name + ", " + x + ", " + y + ", " + width + ", " + height + ")";
    }

    /**
     * getter for x of rectangle
     * @return x 
     */
    public int getX() {
        return x;
    }
    
    /**
     * getter for the y of rectangle
     * @return y
     */
    public int getY() {
        return y;
    }
    
    /**
     * getter for width of rectangle
     * @return width 
     */
    public int getW() {
        return width;
    }
    
    /**
     * getter for height of rectangle
     * @return height
     */
    public int getH() {
        return height;
    }
    
    /**
     * Checks rectangle intersection
     * @param rect Rectangle to check intersection
     * @return true if this Rectangle intersects rect, otherwise false
     */
    public boolean intersects(Rectangle rect) {
        return (Math.abs(x - rect.x) * 2 < (width + rect.width)) &&
                (Math.abs(y - rect.y) * 2 < (height + rect.height));
    }
}
