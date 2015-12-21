package sample;

import java.util.Arrays;

public class QuickSort {

	public static void main(String[] args) {

		int[] array = {10,3,1};
		quickSort(array);
		System.out.println(Arrays.toString(array));
		int med = (array.length-1)/2;
		System.out.println(findMedian(array,0,array.length-1,0));
	}
	
	private static void quickSort(int[] arr){
		quickSort(arr,0,arr.length-1);
	}
	
	private static void quickSort(int[] arr,int p,int r){
		
		if(p<r){
			int q = partition(arr,p,r);
			quickSort(arr,p,q);
			quickSort(arr,q+1,r);
		}
	}
	
	private static int findMedian(int[] arr,int p,int r,int med){
		if(p<=r){
			int q = partition(arr, p, r);
			System.out.println("q= "+q+", med: "+med);
			
			if(q == med)
				return arr[q];
			else if(q<med)
				return findMedian(arr,q+1,r,med);
			else
				return findMedian(arr, p, q-1,med);
		}
		return -1;
	}
	
	private static int partition(int[] arr,int p,int r){
		int x = arr[p];
		int i = p-1;
		int j = r+1;
		
		while(true){
		do{
			i++;
		}while(i<r && arr[i]<x);
		
		do{
			j--;
		}while(j>p && arr[j]>x);
		
		if(i<j)
			swap(arr,i,j);
		
		else
			return j;
		
		}	
	}
	
	private static void swap(int[] arr,int i,int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
