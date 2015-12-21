package sample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Items implements Comparable{
	String s;
	int start;
	int end;
	
	public String toString(){
		return s+" "+start+" "+end;
	}

	@Override
	public int compareTo(Object o) {
		
		Items other = (Items)o;
		
		if(this.s.compareToIgnoreCase(other.s)==0){
			if(this.start<other.start)
				return -1;
			else
				return 1;
		}
		
		return this.s.compareToIgnoreCase(other.s);
	}
}

public class LongestRepeatingSubstring {
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		HashMap<String,Integer> strings = new HashMap<String,Integer>();
		List<Items> itemsList = new ArrayList<Items>();
		strings.clear();itemsList.clear();
		for(int i=0;i<str.length();i++){
			for(int j=i;j<str.length();j++){
				String sub = str.substring(i,j+1);
				Items itm = new Items();
				itm.start = i;
				itm.end = j;
				itm.s = sub;
				if(!strings.containsKey(sub)){
					itemsList.add(itm);
					strings.put(sub,itemsList.size()-1);
				}
				else{
					int index = strings.get(sub);
					Items itemInList = itemsList.get(index);
					boolean overlap = itemInList.start <= itm.end && itm.start <= itemInList.end;
					if(!overlap){
						itemsList.add(itm);
					}
				}
			}
		}
		
		Collections.sort(itemsList);
		int len = Integer.MIN_VALUE;
		Items ret=null;
		String prev=null;
		for(int i=0;i<itemsList.size();i++){
			String thisStr = itemsList.get(i).s;
			if(!thisStr.equalsIgnoreCase(prev) && ((i+1)<itemsList.size() && thisStr.equalsIgnoreCase(itemsList.get(i+1).s))){
				prev = thisStr;
				if(thisStr.length()>len){
					ret = itemsList.get(i);
					len = itemsList.get(i).s.length();
				}
				
				else if(thisStr.length()==len && itemsList.get(i).start<ret.start){
					ret = itemsList.get(i);
				}
			}
		}
		
		if(ret==null || ret.s.trim().length()==0)
			System.out.println("NONE");
		else
			System.out.println(ret.s);
		
		System.exit(0);
		
	}
	
	private static List<Items> itemPresent(Map<String,List<Items>> hm,Items item){
		if(hm.containsKey(item.s)){
			return hm.get(item.s);
		}
		return null;
	}

}


