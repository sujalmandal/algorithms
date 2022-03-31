package algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* works in O(n) time! only if the range of values is known and is reasonably small */
public class CountingSort {
    public static void main(String[] args) {
         int num[] = {1,3,2,1,3,5,4,9,8,7,12,3,9};
         //assume the highest value of element - reasonable assumption?
         int maxValueOfElements = 100;
         int countArray[] = new int[maxValueOfElements];
         //count the frequency of elements present in the array to sort
         for(int index=0;index<num.length;index++){
            int indexInCountArr = num[index];
            int previousCount = countArray[indexInCountArr];
            countArray[indexInCountArr] = previousCount+1;
         }
        List<Integer> sortedArray = new ArrayList<>();
         //the total time is O(n) because the sum of all counts in this array is always n, the size of the input
        //the order information hides in the count array as we always start iterating from the left to the right (increasing index)
        for(int currentNumber = 0; currentNumber < countArray.length; currentNumber++){
            int totalCountOfNumber = countArray[currentNumber];
            while(totalCountOfNumber>0){
                sortedArray.add(currentNumber);
                totalCountOfNumber--;
            }
        }
        System.out.println(sortedArray);
    }
}
