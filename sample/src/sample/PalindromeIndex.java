package sample;

import java.util.Scanner;

public class PalindromeIndex {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i=1;i<=t;i++){
			String str = sc.next();
			System.out.println(findPalindromeIndex(str));
		}
	}
	
	private static int findPalindromeIndex(String str){
		if(isPalindrome(str)){
			return -1;
		}
		
		for(int i=0;i<str.length();i++){
			if(isPalindrome(str.substring(0, i)+str.substring(i+1))){
				return i;
			}
		}
		return -1;
	}
	
	private static boolean isPalindrome(String str){
		if(str.length()==1)
			return true;
		int i = 0, j =str.length()-1;
		while(i<j){
			if(str.charAt(i)!=str.charAt(j))
				return false;
			i++;
			j--;
		}
		return true;
	}

}
