package sample;

import java.util.Arrays;

public class Heap {

	public static void main(String[] args) {
		
		int[] arr = {1,2,3,4,5};
		int[] tempArr = {1,2,3,4,5};
		
		Heaps h = new Heaps();
		h.setArr(arr);
		h.setSize(arr.length);
		
		//Heapify the array
		heapify(h,0);
		print(h.getArr(),h.getSize());
		
		//Get the max element
		System.out.println("\n"+getMax(h, h.getSize()));
		
		//heap After removing max 
		print(h.getArr(),h.getSize());
		
		heapify(h, 0);
		
		System.out.println();
		
		print(h.getArr(),h.getSize());
		
		//find the 4th largest element in the array
		h.setArr(tempArr);
		h.setSize(tempArr.length);
		int val=-1;
		for(int i=1;i<=2;i++){
			val = getMax(h, h.getSize());
		}
		System.out.println("\n"+val);

	}
	
	private static void print(int[] arr,int size){
		for(int i=0;i<size;i++)
			System.out.print(arr[i]+" ");
	}
	
	private static int getMax(Heaps h,int len){
		heapify(h,0);
		int elem = h.getArr()[0];
		h.getArr()[0] = h.getArr()[h.getSize()-1];
		h.setSize(h.getSize()-1);
		heapify(h, 0);
		return elem;
	}
	
	private static void heapify(Heaps h,int index){
		int left = 2*index+1;
		int right = 2*index+2;
		
		if(left>=h.getSize() && right>=h.getSize())
			return;
		
		if(left<h.getSize())
			heapify(h,left);
		if(right<h.getSize())
			heapify(h,right);
		
		if(left<h.getSize() && right>=h.getSize()){
			if(h.getArr()[left]>h.getArr()[index])
				swap(h.getArr(),index,left);
		}
		
		if(left<h.getSize() && right < h.getSize() && h.getArr()[left]>h.getArr()[right]){
			if(h.getArr()[left]>h.getArr()[index])
				swap(h.getArr(),index,left);
		}
		
		else if(left<h.getSize() && right < h.getSize() && h.getArr()[left]<h.getArr()[right]){
			if(h.getArr()[right]>h.getArr()[index])
				swap(h.getArr(),index,right);
		}
	}
	
	private static void swap(int[] arr,int i,int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}

class Heaps{
	int[] arr;
	int size;
	
	public int[] getArr() {
		return arr;
	}
	public void setArr(int[] arr) {
		this.arr = arr;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	
	
}
