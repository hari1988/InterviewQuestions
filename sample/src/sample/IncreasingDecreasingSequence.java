package sample;

public class IncreasingDecreasingSequence {
	
	public static void main(String[] args){
		int[] arr = {1,2,3,4,1};
		
		System.out.println(findChangingPoint(arr,0,arr.length-1));
	}
	
	private static int findChangingPoint(int[] a,int left,int right){
		int mid = left+((right-left)/2);
		
		if((mid-1)>=left && a[mid-1]<a[mid] && (mid+1)<=right && a[mid]>a[mid+1])
			return mid;
		
		if((mid-1)>=left && a[mid-1]>a[mid] && (mid+1)<=right && a[mid]>a[mid+1])
			return findChangingPoint(a, left, mid);
		
		if((mid-1)>=left && a[mid-1]<a[mid] && (mid+1)<=right && a[mid]<a[mid+1])
			return findChangingPoint(a, mid, right);
		
		return -1;
	}

}
