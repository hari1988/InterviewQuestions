package sample;

import java.util.Arrays;
import java.util.Scanner;

class Suffix implements Comparable{
	String str;
	int start;
	@Override
	public int compareTo(Object o) {
		Suffix other = (Suffix) o;
		return this.str.compareToIgnoreCase(other.str);
	}
	
	public String toString(){
		return this.str;
	}
}

public class LRS {

    // return the longest common prefix of s and t
    public static String lcp(String s, String t) {
        int n = Math.min(s.length(), t.length());
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) != t.charAt(i))
                return s.substring(0, i);
        }
        return s.substring(0, n);
    }


    // return the longest repeated string in s
    public static String lrs(String s) {

        // form the N suffixes
        int N  = s.length();
        Suffix[] suffixes = new Suffix[N];
        for (int i = 0; i < N; i++) {
        	Suffix sf = new Suffix();
        	sf.start = i;
        	sf.str = s.substring(i, N);
            suffixes[i] = sf;
        }

        // sort them
        Arrays.sort(suffixes);

        // find longest repeated substring by comparing adjacent sorted suffixes
        String lrs = "";
        for (int i = 0; i < N - 1; i++) {
            String x = lcp(suffixes[i].str, suffixes[i+1].str);
            if (x.length() > lrs.length() && Math.abs(suffixes[i].start-suffixes[i+1].start)>=x.length())
                lrs = x;
        }
        return lrs;
    }



    // read in text, replacing all consecutive whitespace with a single space
    // then compute longest repeated substring
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        String s = sc.next();
   
        System.out.println(lrs(s));
    }
}
