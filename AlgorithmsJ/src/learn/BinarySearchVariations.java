package algo;

public class BinarySearchVariations {

	public static void main(String[] args) {
		int[] arr = {5,10,15,25,39,45,47,48,49,100};
		System.out.println("a peak element is : "+findPeak(arr));
		int[] inp = {1,2,4,5,7,8,10,14,16,89};
		//binarySearch(inp,89);
		//recursiveBinarySearch(0,inp,0,inp.length-1,89);
	}

	public static int findPeak(int[] arr) {
		int start=0;
		int last=arr.length-1;
		int mid=0;
		int i=0;
		while(start<=last) {
			mid=getMidIndex(start,last);
			//delayAndPrint("count: "+i+++" start: "+start+" last: "+last+" mid: "+mid+" element: "+arr[mid]);
			//peak found
			if(isPeak(arr,mid)) {
				return arr[mid];
			}
			//peak is on the left side
			if(arr[mid]>arr[mid+1]) {
				last=mid-1;
			}
			//peak is one the right side
			if(arr[mid]<arr[mid+1]) {
				start=mid+1;
			}
		}
		System.out.println("largest element: "+arr[mid]);
		return 0;
	}

	public static int getMidIndex(int r, int l){
		return l+((l-r)/2);
	}

	public static boolean isPeak(int[] arr,int mid) {
		//index out of bounds check
		int right=(mid+1>arr.length-1)?mid:mid+1;
		int left=(mid-1<0)?mid:mid-1;
		//left element & right element
		int midElement=arr[mid];
		int rightElement=arr[right];
		int leftElement=arr[left];
		
		if(midElement>=rightElement && midElement>=leftElement) {
			return true;
		}
		return false;
	}
  }
