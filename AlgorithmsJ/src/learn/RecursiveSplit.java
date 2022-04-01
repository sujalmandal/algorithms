package algo;

/* precursor to merge sort, here I will try to split an array down to individual elements by repeatedly dividing the
array into halves until there is only one element left
 */
public class RecursiveSplit {
    public static void main(String[] args) {
        int arr[] = {1,2,3};
        atomize(arr,0,arr.length-1);
    }

    public static void atomize(int[] originalArr, int left, int right){
        if(right==left){
            System.out.println("value : "+originalArr[left]);
        } else {
            int mid = left + (right-left)/2;
            atomize(originalArr,left,mid);
            atomize(originalArr,mid+1,right);
        }
    }
}
