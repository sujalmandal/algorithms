package algo;

import java.util.Arrays;

public class QuickSelect {

    public static void main(String[] args) {
        int arr[] = {9,8,7,6,5,3,2,1,4};
        int pivotElem = arr[arr.length-1];
        System.out.println("pivotElem = " + pivotElem);
        System.out.println();
        int left=0;
        int right=arr.length-2;
        while(left<right){
            int leftElem = arr[left];
            int rightElem = arr[right];
            if(leftElem<pivotElem) {
                left++;
                continue;
            }
            if(rightElem>pivotElem) {
                right--;
                continue;
            }
            System.out.println("rightElem = " + rightElem);
            System.out.println("leftElem = " + leftElem);

            swap(arr, left, right);
            System.out.println("arr = " + Arrays.toString(arr));
        }
        System.out.println("right = " + right);
        System.out.println("left = " + left);
        swap(arr, left, arr.length-1);
        System.out.println("arr = " + Arrays.toString(arr));
    }

    private static void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

}
