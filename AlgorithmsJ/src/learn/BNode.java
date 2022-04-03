package algo;

public class BNode {
    private int value;
    private BNode left;
    private BNode right;
    public int depth;

    public static BNode of(int val){
        BNode n = new BNode();
        n.value = val;
        return n;
    }

    public int getValue() {
        return value;
    }

    public BNode getLeft() {
        return left;
    }

    public BNode getRight() {
        return right;
    }

    public BNode setValue(int value) {
        this.value = value;
        return this;
    }

    public BNode setLeft(BNode left) {
        this.left = left;
        return this;
    }

    public BNode setRight(BNode right) {
        this.right = right;
        return this;
    }
}
