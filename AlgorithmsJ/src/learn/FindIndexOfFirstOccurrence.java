package algo;

public class FindIndexOfFirstOccurrence {
    /* given a sorted array - yes just use binary search - find the index at which an element appears first */
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,4,4,4,5,6,7,8,9};
        int mid=0,left=0,right=arr.length-1;
        int searchValue = 4;
        while(left<=right){
            mid = left + (right-left)/2;
            int guessValue = arr[mid];
            if(guessValue>searchValue){
                right = mid-1;
            }
            if(guessValue<searchValue){
                left = mid+1;
            }
            if(guessValue==searchValue){
                if(arr[mid-1]==searchValue){
                    right = mid-1;
                }
                else {
                    break;
                }
            }
        }
        System.out.println(String.format("first index of %s is %s",searchValue,mid));
    }
}
