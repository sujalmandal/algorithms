package algo;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class QueueUsingStack {
    public static final int ENQUEUE = 1;
    public static final int DEQUEUE = -1;
    public static void main(String[] args) {
        List<int[]> operations = List.of(
                new int[]{ENQUEUE,1},
                new int[]{ENQUEUE,2},
                new int[]{ENQUEUE,3},
                new int[]{DEQUEUE,DEQUEUE},
                new int[]{ENQUEUE,4},
                new int[]{DEQUEUE,DEQUEUE},
                new int[]{ENQUEUE,5},
                new int[]{DEQUEUE,DEQUEUE},
                new int[]{ENQUEUE,6},
                new int[]{DEQUEUE,DEQUEUE},
                new int[]{DEQUEUE,DEQUEUE},
                new int[]{DEQUEUE,DEQUEUE}
        );

        Queue<Integer> queue = new LinkedList<>();
        for(int[] operation : operations){
            if(operation[0]==ENQUEUE){
                queue.offer(operation[1]);
            } else {
                System.out.println("value : "+queue.remove());
            }
        }
        System.out.println("*********");
        DoubleStackQ dsq = new DoubleStackQ();
        for(int[] operation : operations){
            if(operation[0]==ENQUEUE){
                dsq.enqueue(operation[1]);
            } else {
                System.out.println("value : "+dsq.dequeue());
            }
        }
    }

    static class DoubleStackQ {

        Deque<Integer> stackIn = new LinkedList<>();
        Deque<Integer> stackOut = new LinkedList<>();

        public void enqueue(Integer number){
            stackIn.addFirst(number);
        }

        public Integer dequeue(){
            /* remove elements from the second stack where the data from the first stack is reversed */
            if(stackOut.isEmpty()){
                while(!stackIn.isEmpty()){
                    stackOut.add(stackIn.removeFirst());
                }
            }
            return stackOut.removeLast();
        }
    }


}
