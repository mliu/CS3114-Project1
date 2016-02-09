import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

/**
 * @author jordanrw
 * @author mliu95
 * @version 1
 * An implementation of the SkipList data structure.
 * @param <K> A generic class that extends Comparable. Is used as a key
 * to determine the value of the SkipNodes when sorting and inserting etc.
 * @param <E> A generic class that extends Comparable. Is used as a value
 * for the Key-Value pairs of the SkipNodes.
 */
public class SkipList<K extends Comparable<K>, E> {

    /**
     * Private variables used to keep track of the state of the skiplist
     */
    private Random rnd = new Random();
    
    private int level;
    private int size;
    
    private SkipNode<KVPair<K, E>> head;
    
    /**
     * Constructor for the SkipList. Creates empty head skipnode.
     */
    public SkipList() {
        level = 0;
        head = new SkipNode<KVPair<K, E>>(null, level);
        size = 0;
    }
    
    /**
     * Updates the size of the head skipnode array to reflect any changes in 
     * depth.
     * @param newLevel The new depth that the head skipnode should be set to
     */
    private void adjustHead(int newLevel) {
        SkipNode<KVPair<K, E>> newHead = new 
                SkipNode<KVPair<K, E>>(null, newLevel);
        for (int x = 0; x <= level; x++) {
            newHead.forward[x] = head.forward[x];
        }
        head = newHead;
        level = newLevel;
    }

    /**
     * Binomial distribution helper method for randomly choosing the next 
     * skipnode depth
     * @return A random integer
     */
    private int randomLevel() {
        int lev = 0;
        while (rnd.nextInt(2) == 0) {
            lev++;
        }
        return lev;
    }
    
    /**
     * Dumps the contents of this skiplist
     */
    public void dump() {
        System.out.println("Node has depth " + (level + 1) + ", Value (null)");
        SkipNode<KVPair<K, E>> tempNode = head;
        for (int i = 0; i < size; i++) {
            tempNode = tempNode.forward[0];
            System.out.println("Node has depth " +
                    tempNode.forward.length + ", Value "
                    + ((KVPair<?, ?>) tempNode.element()).value().toString());
        }
        //skip list size
        System.out.println("SkipList size is: " + size);
    }
    
    /**
     * Getter method for the skiplist's size
     * @return An integer of the number of skipnodes in the skiplist.
     * Does not include the header skipnode.
     */
    public int getSize() {
        return size;
    }

    /** Insert a KVPair into the skiplist 
     * @param it The new KVPair to insert into the skiplist
     * @return True if the value was inserted, false otherwise
     */
    public boolean insert(KVPair<K, E> it) {
        int newLevel = randomLevel();
        Comparable<K> k = it.key();
        if (level < newLevel)
            adjustHead(newLevel);
        @SuppressWarnings("unchecked") // Generic array allocation
        SkipNode[] update = new SkipNode[level + 1];
        SkipNode<KVPair<K, E>> x = head;        // Start at header node
        for (int i = level; i >= 0; i--) { // Find insert position
            while ((x.forward[i] != null) && (k.compareTo(
                    ((KVPair<K, E>) (x.forward[i]).element()).key()) > 0))
                x = x.forward[i];
            update[i] = x;               // Track end at level i
        } 
        x = new SkipNode<KVPair<K, E>>(it, newLevel);
        for (int i = 0; i <= newLevel; i++) {      // Splice into list
            x.forward[i] = update[i].forward[i]; // Who x points to
            update[i].forward[i] = x;            // Who y points to
        }
        size++;                       // Increment dictionary size
        return true;
    }
    
    /**
     * Calculates any intersections between Rectangles in the skiplist
     * and returns an arraylist of length 2 arrays which contain intersecting
     * rectangles.
     * @return An Arraylist of arrays all length 2 that both hold rectangles.
     */
    public ArrayList<E[]> intersections() {
        SkipNode<E> outerIterator = head.forward[0];
        SkipNode<E> innerIterator = head.forward[0];
        ArrayList<E[]> intersectionList = new ArrayList<E[]>();
        
        for (int i = 0; i < size; i++) {
            Rectangle outerRect = (Rectangle) 
                    ((KVPair<K, E>) outerIterator.element()).value();
            for (int j = i; j < size; j++) {
                Rectangle innerRect = (Rectangle) 
                        ((KVPair<K, E>) innerIterator.element()).value();
                
                if (i != j && outerRect.intersects(innerRect)) {
                    Rectangle[] temp = new Rectangle[2];
                    temp[0] = outerRect;
                    temp[1] = innerRect;
                    intersectionList.add((E[]) temp);
                }
                
                innerIterator = innerIterator.forward[0];
            }
            outerIterator = outerIterator.forward[0];
            innerIterator = outerIterator;
        }
        
        return intersectionList;
    }
    
    /**
     * Returns any rectangles in the skiplist that overlap the 
     * bounds given in the parameters.
     * @param x The x position of the top left point in the area
     * @param y The y position of the top left point in the area
     * @param w The width of the area
     * @param h The height of the area
     * @return An arraylist of rectangles that overlap the given area.
     */
    public ArrayList<E> regionSearch(int x, int y, int w, int h) {
        ArrayList<E> foundList = new ArrayList<E>();
        
        //search for the given region
        SkipNode<KVPair<K, E>> tempNode = head;
        for (int i = 0; i < size; i++) {
            //upate the node
            tempNode = tempNode.forward[0];
            
            //grab the current rectangle
            Rectangle rect = (Rectangle) ((KVPair<K, E>) 
                    tempNode.element()).value();
            
            //check to see if no intersection
            if ( (rect.x + rect.width) < x || (x + w) < rect.x || 
                    (rect.y + rect.height) < y || (y + h) < rect.y ) {
                //do nothing
            } else {
                //there was an intersection, so add to array
                foundList.add((E)((KVPair<K, E>) tempNode.element()).value());
            }
        }
        
        return foundList;
    }
    
    /**
     * Searches for the first instance of the key in the skipnode values and 
     * removes it from the skiplist
     * @param key The key value of the skipnode to remove
     * @return The value of the KVPair belonging to the skipnode that was 
     * removed. Null if no element was removed.
     */
    public E remove(Comparable<K> key) {
        E removed = null;
        SkipNode<KVPair<K, E>> x = head;
        SkipNode<KVPair<K, E>> remove = null;
        for (int i = level; i >= 0; i--) {
            while ((x.forward[i] != null) && 
                    key.compareTo(((KVPair<K, E>) 
                            x.forward[i].element()).key()) > 0) {
                // Search until we find the first instance of a 
                // SkipNode with key
                x = x.forward[i];
            }
            if ((x.forward[i] != null) && key.compareTo(((KVPair<K, E>) 
                    x.forward[i].element()).key()) == 0) {
                // We've found the SkipNode we want to remove. 
                // Break out of the search.
                remove = x.forward[i];
                break;
            }
        }
        
        if (remove == null) {
            // The loop has run all the way through and we've found nothing.
            return null;
        }
        
        x = head;
        for (int i = remove.forward.length - 1; i >= 0; i--) {
            // Move forward in the current depth until we've found the SkipNode
            while (x.forward[i] != remove) {
                x = x.forward[i];
            }
            // Decouple the SkipNode at this level
            x.forward[i] = remove.forward[i];
        }
        
        size--;
        return (E) ((KVPair<K, E>) remove.element()).value();
    }
    
    /**
     * Searches for the first instance of the value in the skipnode KVPair 
     * values and removes it from the skiplist
     * @param value The value of the KVPair of the skipnodes to remove
     * @return The value of the KVPair belonging to the skipnode that was 
     * removed. Null if no element was removed.
     */
    public E remove(E value) {
        E removed = null;
        
        SkipNode<KVPair<K, E>> x = head;
        SkipNode<KVPair<K, E>> remove = null;
        
        while (x.forward[0] != null && !value.equals(
                ((KVPair<K, E>) x.forward[0].element()).value())) {
            // Search until we find the first instance of a SkipNode with key
            x = x.forward[0];
        }
        if ((x.forward[0] != null) && value.equals(
                ((KVPair<K, E>) x.forward[0].element()).value())) {
            // We've found the SkipNode we want to remove. 
            // Break out of the search.
            remove = x.forward[0];
        }
        
        if (remove == null) {
            // The loop has run all the way through and we've found nothing.
            return null;
        }
        
        x = head;
        for (int i = remove.forward.length - 1; i >= 0; i--) {
            // Move forward in the current depth until we've found the SkipNode
            while (x.forward[i] != remove) {
                x = x.forward[i];
            }
            // Decouple the SkipNode at this level
            x.forward[i] = remove.forward[i];
        }
        
        size--;
        return (E) ((KVPair<K, E>) remove.element()).value();
    }
    
    /** 
     * Searches for all instances of the key value in the skipnodes and
     * returns all values of KVPairs of matching skipnodes
     * @param key The key of skipnodes we want to search for
     * @return An arraylist full of values of the KVPairs belonging
     * to the skipnodes
     */
    public ArrayList<E> search(Comparable<K> key) {
        boolean found = false;
        SkipNode<KVPair<K, E>> x = head;
        for (int i = level; i >= 0; i--) {
            while ((x.forward[i] != null) && (key.compareTo(
                  ((KVPair<K, E>) x.forward[i].element()).key()) > 0)) {
                x = x.forward[i];              // Go one last step
            }
        }
        x = x.forward[0];  // Move to actual record, if it exists
        if ((x != null) && (key.compareTo(
                ((KVPair<K, E>) x.element()).key()) == 0)) {
            ArrayList<E> foundList = new ArrayList<E>();            
            while ((x != null) && 
                    key.compareTo(((KVPair<K, E>) x.element()).key()) == 0) {
                foundList.add((E)((KVPair<K, E>) x.element()).value());
                x = x.forward[0];
            }
            return foundList;
        }
        else
            return null;
    }

}
