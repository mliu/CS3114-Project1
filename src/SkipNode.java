
public class SkipNode<E> {

    private E key;
    private SkipNode[] forward;
    
    public SkipNode(E newKey, int newLevel) {
        key = newKey;
        forward = new SkipNode[newLevel];
    }
    
    public E element() {
        return key;
    }
    
    public SkipNode[] forward() {
        return forward;
    }
}
