package sample;

import java.util.Arrays;

public class KMP {

	public static void main(String[] args) {
		String text = "xabananananasan";
		String pattern = "nasa";
		int[] prefix = computePrefix(pattern);
		System.out.println(Arrays.toString(prefix));
		findMatches(text,pattern,prefix);
	}
	
	private static void findMatches(String text,String pattern,int[] prefix){
		int i = 0;
		for(int j=0;j<text.length();j++){
			while(i>0 && pattern.charAt(i)!=text.charAt(j)){
				i = prefix[i-1];
			}
			
			if(pattern.charAt(i)==text.charAt(j)){
				i++;
			}
			
			if(i==pattern.length()){
				System.out.println(j-pattern.length()+1);
				i = prefix[i-1];
			}
			
			
		}
	}
	
	private static int[] computePrefix(String pattern){
		String pat = pattern;
		char[] c = pat.toCharArray();
		int[] prefix = new int[pat.length()];
		prefix[0] = 0;
		int i = 0;
		for(int j=1;j<c.length;j++){
			while(i>0 && c[j]!=c[i]){
				i = prefix[i];
			}
			
			if(c[j] == c[i]){
				i = i+1;
			}
			
			prefix[j] = i;
		}
		return prefix;
	}

}
