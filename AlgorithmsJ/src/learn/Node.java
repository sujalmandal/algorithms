package algo;

public class Node {
    int val;
    Node next;

    public static Node of(int val){
        Node n = new Node();
        n.val = val;
        return n;
    }

    public Node setNext(Node n){
        this.next = n;
        return n;
    }
}
