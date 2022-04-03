package algo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class IterativeDFS {
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

        Stack<BNode> stack = new Stack<>();
        stack.push(root);
        List<Integer> items = new ArrayList<>();
        while(!stack.isEmpty()){
            BNode node = stack.pop();
            items.add(node.getValue());
            BNode left = node.getLeft();
            BNode right = node.getRight();
            if(left !=null) stack.push(left);
            if(right !=null) stack.push(right);
        }
        Collections.reverse(items);
        System.out.println(items);
    }
}
