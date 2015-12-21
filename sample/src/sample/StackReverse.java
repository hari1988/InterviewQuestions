package sample;

import java.util.ArrayList;

public class StackReverse {

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
		stackReverse(st);
		
		for(int i : st.getSt())
			System.out.print(i+" ");
		
	}
	
	private static void stackReverse(Stack st){
		if(st==null || st.isEmpty())
			return;
		
		int temp = st.pop();
		stackReverse(st);
		insertStackAtBottom(st,temp);
	}
	
	private static void insertStackAtBottom(Stack st, int num){
		if(st.isEmpty()){
			st.push(num);
			return;
		}
		//pop the top
		int temp = st.pop();
		insertStackAtBottom(st, num);
		st.push(temp);
	}
	

}
