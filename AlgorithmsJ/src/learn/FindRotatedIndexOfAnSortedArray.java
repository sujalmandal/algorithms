package algo;

public class FindRotatedIndexOfAnSortedArray {

    public static void main(String[] args) {
        /* array is sorted ascendingly but rotated from the i=1th index */
        int[] arr = {3,4,5,6,1,2};
        int leftMostElem = arr[0];
        int left=0,right=arr.length-1,mid=0;
        while(left<=right){
            mid = left + (right-left)/2;
            int guessValue = arr[mid];
            if(guessValue>arr[mid+1]){
                System.out.println("found the index at : "+mid);
                break;
            }
            /* search right */
            if(guessValue>=leftMostElem){
                left = mid+1;
            }
            /* search left */
            else {
                right=mid-1;
            }
        }
    }

}
