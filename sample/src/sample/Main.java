package sample;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Main {
	
    public static void main(String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String str;
        while ((str = buffer.readLine()) != null) {
           Map<Item,Integer> hm = new HashMap<Item,Integer>();
           hm.clear();
           
           for(int i=0;i<str.length();i++){
			for(int j=i;j<str.length();j++){
				String sub = str.substring(i,j+1);
				Item itm = new Item();
				itm.start = i;
				itm.end = j;
				itm.s = sub;
				Item insideItem = itemPresent(hm,itm);
				if(insideItem==null)
					hm.put(itm, 1);
				else{
					int c = hm.get(insideItem);
					hm.put(insideItem, c+1);
				}
			}
		}
		
		Iterator<Map.Entry<Item, Integer>> itr = hm.entrySet().iterator();
		
		while(itr.hasNext()){
			Map.Entry<Item, Integer> entry = itr.next();
			if(entry.getValue()==1 ||entry.getKey().s.trim().length()==0)
				itr.remove();
		}
		
		if(hm.isEmpty()){
			System.out.println("NONE");
		}
		else{
			ArrayList<Item> items = new ArrayList<Item>();
			items.addAll(hm.keySet());
			Collections.sort(items);
			System.out.println(items.get(0).s);
		}
            
        }
        
        System.exit(0);
    }
    
    private static Item itemPresent(Map<Item,Integer> hm,Item item){
		for(Map.Entry<Item, Integer> entry: hm.entrySet()){
			Item i = entry.getKey();
			
			boolean overlap = item.start <= i.end && i.start <= item.end;
			
			overlap = !overlap && i.s.equalsIgnoreCase(item.s);
			
			if(overlap)
				return i;
		}
		
		return null;
	}
}

class Item implements Comparable{
	String s;
	int start;
	int end;
	
	public String toString(){
		return s+" "+start+" "+end;
	}

	@Override
	public int compareTo(Object o) {
		Item other = (Item) o;
		
		if(this.s.length()>other.s.length())
			return -1;
		
		else if(this.s.length()<other.s.length())
			return 1;
		
		else if(this.start<other.start)
			return -1;
		
		return 1;
	}
	
	
}