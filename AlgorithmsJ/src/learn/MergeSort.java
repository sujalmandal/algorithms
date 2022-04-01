package algo;

import java.util.Arrays;

/* precursor to merge sort, here I will try to split an array down to individual elements by repeatedly dividing the
array into halves until there is only one element left
 */
public class MergeSort {
    public static void main(String[] args) {
        int arr[] = {9,3,8,2,10};
        int[] sortedArray = mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(sortedArray));
    }

    public static int[] mergeSort(int[] originalArr, int left, int right){
        if(right==left){
            return new int[] {originalArr[left]};
        } else {
            int mid = left + (right-left)/2;
            int leftArr[] = mergeSort(originalArr,left,mid);
            int rightArr[] = mergeSort(originalArr,mid+1,right);

            System.out.println(String.format("left array: %s right array : %s",
                    Arrays.toString(leftArr),
                    Arrays.toString(rightArr))
            );
            return mergeAndSort(leftArr, rightArr);
        }
    }

    private static int[] mergeAndSort(int[] leftArr, int[] rightArr) {
        int mergedArrIndex = 0;
        int leftArrIndex=0;
        int rightArrIndex=0;
        int sortedSubArr[] = new int[(leftArr.length+rightArr.length)];
        /* compare and merge the arrays */
        while(leftArrIndex<leftArr.length && rightArrIndex<rightArr.length){
            if(leftArr[leftArrIndex]<= rightArr[rightArrIndex]){
                sortedSubArr[mergedArrIndex]= leftArr[leftArrIndex];
                leftArrIndex++;
            } else {
                sortedSubArr[mergedArrIndex]= rightArr[rightArrIndex];
                rightArrIndex++;
            }
            mergedArrIndex++;
        }
        /* copy the remaining elements from leftArr if any */
        while(leftArrIndex<leftArr.length){
            sortedSubArr[mergedArrIndex++]= leftArr[leftArrIndex++];
        }
        /* copy the remaining elements from rightArr if any */
        while(rightArrIndex<rightArr.length){
            sortedSubArr[mergedArrIndex++]= rightArr[rightArrIndex++];
        }

        return sortedSubArr;
    }
}
