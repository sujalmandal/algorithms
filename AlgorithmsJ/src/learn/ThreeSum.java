package algo;

import java.util.*;

public class ThreeSum {

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        List<Integer> sortedList = new ArrayList<>();
        Arrays.stream(nums).sequential().sorted().forEach(sortedList::add);
        System.out.println("sortedSet = " + sortedList);
        sortedList.forEach(firstNumber->printThreeSum(firstNumber,sortedList));
    }

    private static void printThreeSum(int firstNum, List<Integer> sortedList) {
        int leftPointer=0;
        int rightPointer=sortedList.size()-1;
        while(leftPointer<rightPointer){
            Integer secondNum = sortedList.get(leftPointer);
            Integer thirdNum = sortedList.get(rightPointer);
            if(secondNum == firstNum){
                leftPointer++;
                continue;
            }
            if(thirdNum == firstNum){
                rightPointer--;
                continue;
            }
            /** sum became greater than 0, try to reduce it */
            if(secondNum+thirdNum+firstNum>0) rightPointer--;
            /** sum became smaller than 0, try to increase it */
            if(secondNum+thirdNum+firstNum<0) leftPointer++;
            /** found the triplet, quit */
            if(firstNum+secondNum+thirdNum==0){
                System.out.printf("firstNum = %s, secondNum = %s, thirdNum = %s = 0 \n", firstNum,secondNum,thirdNum);
                break;
            }
        }
    }


}
