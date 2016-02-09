/**
 * @author jordanrw
 * @author mliu95
 * @version 1
 * The SkipNode class that is used by the SkipList
 * @param <E> A generic class for the element this SkipNode holds
 */
public class SkipNode<E> {

    /**
     * Private variables that describe the SkipNode's data
     */
    private E element;
    /**
     * forward - the stack of SkipNodes this SkipNode links to
     */
    public SkipNode[] forward;
    
    /**
     * Creates a new SkipNode
     * @param newElement The element this SkipNode holds
     * @param newLevel The depth of this SkipNode's list
     */
    public SkipNode(E newElement, int newLevel) {
        element = newElement;
        forward = new SkipNode[newLevel + 1];
    }
    
    /**
     * Getter for the SkipNodes element
     * @return The element this SkipNode holds.
     */
    public E element() {
        return element;
    }
}
