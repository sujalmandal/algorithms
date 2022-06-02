package algo;

public class InPlaceLinkedListReverse {
    public static void main(String[] args) {
        Node head = Node.of(1);
        head.setNext(Node.of(2)).setNext(Node.of(3)).setNext(Node.of(4));
        Node curr = head;
        Util.printLL(curr);

        curr = head;
        Node prev = null;
        Node next = null;

        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        System.out.println("El reverso");
        Util.printLL(prev);
    }

}
