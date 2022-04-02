package algo;

import java.util.Arrays;
import java.util.stream.IntStream;

public class ProductOfAllNumbersExceptOneAtIndex {
    /* given an array, [1,4,2,8,9,12,90], find the product of all numbers at each index expect the number at the index */
    public static void main(String[] args) {
        int arr[] = {1,2,3,4};

        int after[] = new int[arr.length];
        //set the after of the last element to one as it is going to be used in multiplication
        after[arr.length-1] = 1;
        for(int i=arr.length-2;i>=0;i--){
            after[i] = after[i+1]*arr[i+1];
        }
        int before[] = new int[arr.length];
        //set the before of the first element to one as it will be used in multiplication
        before[0]=1;
        for(int i=1;i< arr.length;i++){
            before[i] = before[i-1] * arr[i-1];
        }
        System.out.println("after : " + Arrays.toString(after));
        System.out.println("before : " + Arrays.toString(before));

        System.out.println("arr : " + Arrays.toString(arr));

        IntStream.range(0, arr.length).forEach(i->
            System.out.print(String.format("[i=%d , product=%d] ", arr[i], before[i] * after[i]))
        );
    }
}
