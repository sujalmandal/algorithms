package algo;

public class IsBST {
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
        System.out.println(isBST(root));
    }

    public static boolean isBST(BNode node){
        if(node==null) return true;

        boolean isThisNodeBST = false;
        if(node.getLeft()==null && node.getRight()!=null
                && node.getValue()<node.getRight().getValue()){
            isThisNodeBST=true;
        }
        if(node.getRight()==null && node.getLeft()!=null
                && node.getValue()>node.getLeft().getValue()){
            isThisNodeBST=true;
        }
        if(node.getRight()==null && node.getLeft()==null){
            isThisNodeBST=true;
        }
        if(node.getRight()!=null && node.getLeft()!=null
                && node.getValue()<node.getRight().getValue()
                && node.getValue()>node.getLeft().getValue()){
            isThisNodeBST=true;
        }
        boolean isLeftNodeBST = isBST(node.getLeft());
        boolean isRightNodeBST = isBST(node.getRight());
        return isThisNodeBST && isLeftNodeBST && isRightNodeBST;
    }
}
