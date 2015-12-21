package sample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class Entry implements Comparable{
	String sign;
	String word;
	
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	@Override
	public String toString() {
		return "Entry [sign=" + sign + ", word=" + word + "]";
	}
	@Override
	public int compareTo(Object obj) {
		Entry e = (Entry)obj;
		return this.getSign().compareTo(e.getSign());
	}
	
	
	
	
}

public class Anagram {

	public static void main(String[] args) {
		String[] words = {"pans","pots","opt","snap","stop","tops"};
		ArrayList<Entry> entries = new ArrayList<Entry>();
		
		//First sort the words and put them in the format (sortedword sort)
		for(String s: words){
			String sorted = sort(s.toCharArray());
			Entry e = new Entry();
			e.setSign(sorted);
			e.setWord(s);
			entries.add(e);
		}
		
		//Sort the entries based on sign
		Collections.sort(entries);
		
		//Write the anagrams on a single line
		String prev="";
		for(int i=0;i<entries.size();i++){
			if(!entries.get(i).getSign().equals(prev) && i!=0){
				System.out.println();
			}
			prev = entries.get(i).getSign();
			System.out.print(entries.get(i).getWord()+" ");
		}
		System.out.println();
		
	}
	
	private static String sort(char[] s){
		Arrays.sort(s);
		return new String(s);
	}

}
