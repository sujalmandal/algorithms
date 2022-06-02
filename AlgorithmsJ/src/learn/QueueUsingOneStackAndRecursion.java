package algo;

import java.util.Stack;

public class QueueUsingOneStackAndRecursion {
    public static void main(String[] args) {
        CustomQueue q = new CustomQueue();
        q.queue(1);
        q.queue(2);
        q.queue(3);
        q.queue(4);
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
    }

    static class CustomQueue{
        private Integer poppedElement=null;
        private Stack<Integer> internalStack = new Stack<>();

        public void queue(Integer item){
            internalStack.push(item);
        }

        public Integer dequeue(){
            _dequeue();
            return poppedElement;
        }

        private void _dequeue(){
            int sizeBeforePop = internalStack.size();
            if(sizeBeforePop==0) return;
            Integer itemInFrame = internalStack.pop();
            _dequeue();
            if(sizeBeforePop==1) this.poppedElement = itemInFrame;
            if(sizeBeforePop>1) internalStack.push(itemInFrame);
        }
    }

}
