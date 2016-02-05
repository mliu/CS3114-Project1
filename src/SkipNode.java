
public class SkipNode<E> {

    private E key;
    private SkipNode forward;
    
    public SkipNode(E newKey, SkipNode pointer) {
        key = newKey;
        forward = pointer;
    }
}
