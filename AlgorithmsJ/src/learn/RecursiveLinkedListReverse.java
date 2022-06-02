package algo;

import static algo.Util.printLL;

public class RecursiveLinkedListReverse {
    public static void main(String[] args) {
        Node head = Node.of(1);
        head.setNext(Node.of(2)).setNext(Node.of(3)).setNext(Node.of(4));
        Node curr = head;
        printLL(curr);
        curr = head;
        Node reversedHead = reverse(curr);
        printLL(reversedHead);
    }

    public static Node reverse(Node curr){
        Node next = curr.next;
        if(next==null) { return curr; }
        Node reversedHead = reverse(next);
        System.out.println("curr: "+curr.val + ", next: "+next.val);
        /** reverse the links */
        curr.next=null;
        next.next=curr;
        return reversedHead;
    }
}
