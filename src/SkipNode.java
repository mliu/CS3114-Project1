
public class SkipNode<E> {

    private E element;
    public SkipNode[] forward;
    
    public SkipNode(E newElement, int newLevel) {
        element = newElement;
        forward = new SkipNode[newLevel-1];
    }
    
    public E element() {
        return element;
    }
}
