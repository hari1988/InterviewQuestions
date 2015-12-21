package sample;

import java.util.Arrays;

public class InsertionSort {
	
	public static void main(String[] args)throws Exception {
		int[] array = {22, 11, 99, 88, 9, 7, 42};
		int n = array.length;
		for(int i=1;i<n;i++){
			int t = array[i];
			int j;
			for(j=i-1;j>=0 && t<array[j];j--){
				array[j+1] = array[j];
			}
			array[j+1] = t;
		}
		System.out.println(Arrays.toString(array));
	}
}


