package algo;

import java.util.Arrays;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {1,4,2,6,19,-2};
        int target = 21;

        int[] sortedArray = Arrays.stream(nums).sorted().toArray();
        int leftPointer=0,rightPointer=sortedArray.length-1;
        int currentSum=0;

        while(leftPointer<rightPointer){
            int leftElement = sortedArray[leftPointer];
            int rightElement = sortedArray[rightPointer];
            currentSum= leftElement + rightElement;
            //System.out.println("currentSum = " + currentSum);
            /**
             * adjust the sum to be lower than the target
             */
            if(currentSum>target) rightPointer--;
            /**
             *  adjust the sum to be higher
             */
            if(currentSum<target) leftPointer++;
            if(currentSum==target) {
                System.out.println(String.format("%s + %s = %s", leftElement , rightElement , target));
                break;
            }
        }
    }
}
