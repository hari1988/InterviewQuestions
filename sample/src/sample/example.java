package sample;

import java.util.Arrays;
import java.util.Scanner;

public class example {

	public static void main(String[] args)throws Exception {
		
		/*Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		for(int i=1;i<=t;i++){
			String a = sc.next();
			String b = sc.next();
			System.out.println(isSubstring(a,b)?"YES":"NO");
		}*/
		
		String str = "HOMEDEPOT DLVRY AGENT,ACE COURIER ZONE,SUNDAY,120,,,";
		String[] s = str.split(",");
		System.out.println(s.length);
		if(null!=s[5]){
			System.out.println("hi");
		}
		System.exit(0);
	}
	
	private static boolean isSubstring(String a,String b){
		char[] ac = a.toCharArray();
		char[] bc = b.toCharArray();
		
		if(ac.length<bc.length){
			Arrays.sort(bc);
			return findIndex(ac,bc);
		}
		else{
			Arrays.sort(ac);
			return findIndex(bc,ac);
		}
	}
	
	private static boolean findIndex(char[] small,char[] big){
		for(char c: small){
			boolean flag = isPresent(c,big,0,big.length-1);
			if(flag)
				return true;
		}
		return false;
	}
	
	private static boolean isPresent(char c, char[] big,int left,int right){
		
		if(right < left)
			return false;
		
		int mid = left + ((right - left)/2);
		
		if(big[mid] == c)
			return true;
		
		if(big[mid]>c)
			return isPresent(c, big, left, mid-1);
		
		return isPresent(c,big,mid+1,right);
	}

}
