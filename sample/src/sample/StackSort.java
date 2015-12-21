package sample;

import java.util.ArrayList;

class Stack {
	
	ArrayList<Integer> st;
	
	public ArrayList<Integer> getSt() {
		return st;
	}

	public void setSt(ArrayList<Integer> st) {
		this.st = st;
	}

	public Integer getTop(){
		if(st.size()==0){
			return null;
		}
		return st.get(st.size()-1);
	}
	
	public void push(int elem){
		st.add(elem);
	}
	
	public Integer pop(){
		if(this.isEmpty()){
			return null;
		}
		return st.remove(st.size()-1);
	}
	
	public boolean isEmpty(){
		return st.size()>0?false:true;
	}
}
public class StackSort {
	
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(30);
		list.add(-5);
		list.add(18);
		list.add(14);
		list.add(-3);
		Stack st = new Stack();
		st.setSt(list);
		
		for(int i : st.getSt())
			System.out.print(i+" ");
		
		System.out.println();
		stackSort(st);
		
		for(int i : st.getSt())
			System.out.print(i+" ");
	}
	
	private static void stackSort(Stack st){
		if(st==null || st.isEmpty())
			return;
		int temp = st.pop();
		stackSort(st);
		insertStack(st,temp);
	}
	
	private static void insertStack(Stack st, int num){
		if(st.isEmpty() || st.getTop()>num){
			st.push(num);
			return;
		}
		int temp = st.pop();
		insertStack(st, num);
		st.push(temp);
	}

}
