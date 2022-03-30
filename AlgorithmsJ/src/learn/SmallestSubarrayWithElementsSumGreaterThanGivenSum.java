package algo;

import java.util.Arrays;

public class SmallestSubarrayWithElementsSumGreaterThanGivenSum {

    public static void main(String[] args) {
        int givenSum = 13;
        int[] arr = {1,2,9,2,7,0,8,4,5,1,5,6};
        int left = 0;
        int right = 0;
        int bestSubArrSize = Integer.MAX_VALUE;
        int currentRunningSum = 0;
        int bestLeft=0;
        while (pointersDidNotReachEndOfArray(arr, left, right)){
            //grow the window to get a suitable sum first
            if(currentRunningSum<givenSum) {
                currentRunningSum+=arr[right];
                right++;
            }//we have matched the criteria
            else {
                //is this the smallest sub array?
                if(bestSubArrSize>right-left){
                    bestSubArrSize = right-left;
                    bestLeft=left;
                }
                //we run this loop until we violate the condition - the subarray sum becomes lower than the given sum
                //the above loop will start growing the right pointer and the subarray once that happens
                while (pointersDidNotReachEndOfArray(arr, left, right) && currentRunningSum>=givenSum){
                    //is this the smallest sub array?
                    if(bestSubArrSize>right-left){
                        bestSubArrSize = right-left;
                        bestLeft=left;
                    }
                    //if the current running sum is still greater or equal to the given sum
                    //we will try to shrink the sub array by incrementing the left and subtracting the element that
                    //leaves our subarray window
                    currentRunningSum=currentRunningSum-arr[left];
                    left++;
                }
            }
        }
        System.out.println(String.format("Smallest subarray size is %d whose element greater than %d ",
                bestSubArrSize,
                givenSum)
        );
        for(int i=bestLeft;i<bestLeft+bestSubArrSize;i++){
            System.out.print(arr[i]+" ");
        }
    }

    private static boolean pointersDidNotReachEndOfArray(int[] arr, int left, int right) {
        return left < arr.length && right < arr.length;
    }

}