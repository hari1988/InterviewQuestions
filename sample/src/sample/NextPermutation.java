package sample;

import java.util.Arrays;
import java.util.Scanner;

public class NextPermutation {
	
	static char[] a = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
	static char[] b = {'0','1','2','3','4','5','6','7','8','9'};

	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i=1;i<=t;i++){
			String str = sc.next();
			String next = findNextNum(str);
			if(next.equals(str)){
				System.out.println("no answer");
			}
			else{
				System.out.println(next);
			}
		}
	}
	
	private static String findPrev(String str){
		int[] arr = new int[str.length()];
		
		for(int i=0;i<arr.length;i++){
			arr[i] = str.charAt(i)-'a';
		}
		
		//from the end, keep going left as long as the sequence is decreasing
		int i = arr.length-1;
		while(i>0 && arr[i-1]<=arr[i]){
			i--;
		}
		
		if(i==0)
			return str;
		
		//find the right most number j>=i that is lesser than pivot
		int j= arr.length-1;
		for(;j>=i && arr[j]>=arr[i-1];j--);
		
		//swap arr[i-1] and arr[j]
		swap(arr,i-1,j);
		
		//Reverse suffix starting at i
		reverse(arr,i,arr.length-1);
				
		StringBuffer buf = new StringBuffer();
				
		for(i=0;i<arr.length;i++){
			buf.append(a[arr[i]]);
		}
		return buf.toString();
		
	}
	
	private static String findNextNum(String num){
		int[] arr = new int[num.length()];
		
		for(int i=0;i<arr.length;i++){
			arr[i] = num.charAt(i)-'0';
		}
		
		int i = arr.length-1;
		while(i>0 && arr[i-1]>=arr[i]){
			i--;
		}
		
		if(i==0){
			int j=num.length()-1;
			while(j>=0 && num.charAt(j)=='0'){
				j--;
			}
			StringBuffer buf = new StringBuffer();
			buf.append(num.charAt(j));
			buf.append(0);
			
			for(i=j+1;i<num.length();i++){
				buf.append(num.charAt(i));
			}
			
			for(i=j-1;i>=0;i--)
			{
				buf.append(num.charAt(i));
			}
			
			return buf.toString();
		}
		
		else{
			int j = arr.length-1;
			for(;j>=i && arr[j]<=arr[i-1];j--);
			
			swap(arr,i-1,j);
			
			//Reverse suffix starting at i
			reverse(arr,i,arr.length-1);
			
			StringBuffer buf = new StringBuffer();
			
			for(i=0;i<arr.length;i++){
				buf.append(b[arr[i]]);
			}
			return buf.toString();
		}
	}
	
	private static String findNext(String str){
		int[] arr = new int[str.length()];
		
		for(int i=0;i<arr.length;i++){
			arr[i] = str.charAt(i)-'a';
		}
		
		//System.out.println(Arrays.toString(arr));
		//find the largest i such that arr[i-1]<arr[i]
		int i = arr.length-1;
		while(i>0 && arr[i-1]>=arr[i]){
			i--;
		}
		
		if(i==0)
			return str;
		
		//find largest j such that j>=i and arr[j]>arr[i-1]
		int j = arr.length-1;
		for(;j>=i && arr[j]<=arr[i-1];j--);
		
		swap(arr,i-1,j);
		
		//Reverse suffix starting at i
		reverse(arr,i,arr.length-1);
		
		StringBuffer buf = new StringBuffer();
		
		for(i=0;i<arr.length;i++){
			buf.append(a[arr[i]]);
		}
		return buf.toString();
	}

	private static void swap(int[] arr,int a,int b){
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	
	private static void reverse(int[] arr,int i,int j){
		while(i<j){
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			i++;
			j--;
		}
	}
}
