package algo;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class LargestInStack {
    public static void main(String[] args) {
        Deque<Integer> queue = new LinkedList<>();
        Deque<Integer> largestElements = new LinkedList<>();
        int[] arr = {1,2,4,5,2,8,10,43,2,9};
        MaxStack maxStack = new MaxStack();
        for(int num : arr) maxStack.push(num);
        System.out.println("Largest element is : "+maxStack.getMaxElement());
        maxStack.pop();
        maxStack.pop();
        maxStack.pop();
        System.out.println("Largest element is : "+maxStack.getMaxElement());

    }

    public static class MaxStack extends Stack<Integer>{
        private Stack<Integer> maxStackHistory;

        public MaxStack(){
            maxStackHistory = new Stack<>();
        }

        public Integer getMaxElement(){
            return maxStackHistory.peek();
        }

        @Override
        public Integer push(Integer item) {
            if(!maxStackHistory.isEmpty()){
                Integer currentHighest = maxStackHistory.peek();
                if(currentHighest<item){
                    maxStackHistory.push(item);
                }
            }
            else {
                maxStackHistory.push(item);
            }
            return super.push(item);
        }

        @Override
        public Integer pop() {
            Integer removedItem = super.pop();
            if(maxStackHistory.peek().equals(removedItem)){
                maxStackHistory.pop();
            }
            return removedItem;
        }
    }
}
