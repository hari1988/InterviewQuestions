package sample;

public class BinarySearch {

	public static void main(String[] args) {
		int[] arr = {2,4,6,7,10,12};
		
		System.out.println(binarySearch(arr,10));
		System.out.println(recursiveBinarySearch(arr, 0, arr.length-1, 10));
	}
	
	private static int recursiveBinarySearch(int[] arr,int left,int right,int elem){
		int mid = left+((right-left)/2);
		if(arr[mid]==elem)
			return mid;
		if(arr[mid]>elem)
			return recursiveBinarySearch(arr, left, mid-1, elem);
		if(arr[mid]<elem)
			return recursiveBinarySearch(arr, mid+1, right, elem);
		return -1;
	}

	private static int binarySearch(int[] arr,int element){
		int left = 0;
		int right = arr.length-1;
		
		while(left<=right){
			int mid = left+((right-left)/2);
			if(arr[mid]==element){
				return mid;
			}
			else if(arr[mid]>element){
				right = mid-1;
			}
			else{
				left = mid+1;
			}
		}
		return -1;
	}
}
