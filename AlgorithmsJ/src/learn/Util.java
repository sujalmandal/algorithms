package algo;

public class Util {
    static void printLL(Node curr) {
        while(curr !=null){
            System.out.println("val: "+ curr.val);
            curr = curr.next;
        }
    }
}
