package sample;

import java.util.Arrays;

public class MoveZerosToRight {
	
	public static void main(String[] args){
		int[] a = {0,0,1,0,2,0,3};
		int zeroIndex = -1;
		for(int i=0;i<a.length;i++){
			if(a[i]==0 && zeroIndex==-1){
				zeroIndex = i;
			}
			else if(a[i]!=0 && zeroIndex!=-1){
				swap(a,zeroIndex,i);
				zeroIndex++;
			}
		}
		
		System.out.println(Arrays.toString(a));
	}
	
	private static void swap(int[] a,int i,int j){
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

}
