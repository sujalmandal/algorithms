package algo;

import java.util.LinkedList;
import java.util.Queue;

public class SearchElementInBinaryTree {
    public static void main(String[] args) {
        BNode root = BNode.of(10)
                                .setLeft(
                                    BNode.of(3)
                                        .setLeft(BNode.of(19))
                                        .setRight(BNode.of(21)))
                                .setRight(
                                    BNode.of(2)
                                        .setLeft(BNode.of(5))
                                        .setRight(BNode.of(9)));
        System.out.println("**** DFS ****");
        dfs(root);
        System.out.println("**** BFS ****");
        bfs(root);
    }

    private static void bfs(BNode currentNode) {
        Queue<BNode> queue = new LinkedList<>();
        queue.add(currentNode);
        while(!queue.isEmpty()){
            BNode currentElem = queue.poll();
            System.out.println("value : "+currentElem.getValue());
            BNode leftNode = currentElem.getLeft();
            BNode rightNode = currentElem.getRight();
            if(leftNode !=null) queue.add(leftNode);
            if(rightNode !=null) queue.add(rightNode);
        }
    }

    private static void dfs(BNode currentNode){
        if(currentNode!=null){
            dfs(currentNode.getLeft());
            dfs(currentNode.getRight());
            System.out.println("value : "+currentNode.getValue());
        }
    }

}
