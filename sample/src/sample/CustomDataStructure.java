package sample;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomDataStructure {

	public static void main(String[] args) {
		DataStructure ds = new DataStructure();
		ds.put(1);ds.put(2);ds.put(3);ds.put(4);
		ds.print();
		System.out.println("Random: "+ds.getRandom());
		System.out.println("Random: "+ds.getRandom());
		System.out.println("Random: "+ds.getRandom());
		System.out.println("Search: "+ds.search(3));
	}

}

class DataStructure{
	Map<Integer,Integer> map;
	List<Integer> list;
	
	public DataStructure(){
		map = new HashMap<Integer, Integer>();
		list = new ArrayList<Integer>();
	}
	
	public void print(){
		for(Integer a : list){
			System.out.println(a+" "+map.get(a));
		}
	}
	
	public int search(int x){
		if(!map.containsKey(x))
			return -1;
		return map.get(x);
	}
	
	public void put(int x){
		int size = list.size();
		list.add(x);
		map.put(x, size);
	}
	
	public boolean remove(int x){
		if(!map.containsKey(x))
			return false;
		
		//get current index of element
		int currIndex = map.get(x);
		
		//find the element at last index
		int lastelement = list.get(list.size()-1);
		
		//copy last element into currIndex and remove last element.this makes the remover operation O(1) 
		list.set(currIndex, lastelement);
		list.remove(list.size()-1);
		
		//update index of last element in map
		map.put(lastelement, currIndex);
		
		//remove old mapping
		map.remove(x);
		
		return true;
	}
	
	public int getRandom(){
		int index = (int)(Math.random()*list.size());
		return list.get(index);
	}
}
