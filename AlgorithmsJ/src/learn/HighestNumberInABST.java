package algo;

public class HighestNumberInABST {
    public static void main(String[] args) {
        BNode root = BNode.of(100)
                .setLeft(
                        BNode.of(50)
                                .setLeft(BNode.of(45))
                                .setRight(BNode.of(59)))
                .setRight(
                        BNode.of(110)
                                .setLeft(BNode.of(105))
                                .setRight(BNode.of(190)));
        System.out.println(getHighest(root,Integer.MIN_VALUE));
    }

    public static int getHighest(BNode node,int lastHighest){
        if(node!=null){
            lastHighest = getHighest(node.getRight(),Math.max(lastHighest, node.getValue()));
        }
        return lastHighest;
    }
}
