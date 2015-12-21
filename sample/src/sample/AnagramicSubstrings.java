package sample;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AnagramicSubstrings {

	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		for(int i=1;i<=t;i++){
			String str = sc.next();
			System.out.println(findNumberOfAnagramicSubstrings(str));
		}
	}
	
	private static int findNumberOfAnagramicSubstrings(String str){
		Map<String,Integer> hm = new HashMap<String, Integer>();
		for(int i=0;i<str.length();i++){
			for(int j=i;j<str.length();j++){
				String sub = str.substring(i,j+1);
				char[] subArr = sub.toCharArray();
				Arrays.sort(subArr);
				
				int val = hm.containsKey(new String(subArr))?hm.get(new String(subArr)):0;
				hm.put(new String(subArr), val+1);
			}
		}
		
		int count = 0;
		for(Map.Entry<String, Integer> entry: hm.entrySet()){
			int c = entry.getValue();
			count += ((c*(c-1))/2);
		}
		
		return count;
	}

}
