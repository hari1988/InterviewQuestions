package sample;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class BottomViewBinaryTree {

	public static void main(String[] args) {
		Tree n1 = new Tree();
		Tree n2 = new Tree();
		Tree n3 = new Tree();
		Tree n4 = new Tree();
		Tree n5 = new Tree();
		Tree n6 = new Tree();
		Tree n7 = new Tree();
		Tree n8 = new Tree();
		
		n1.val = 20;n2.val = 8; n3.val = 22;
		n1.left = n2; n1.right = n3;
		n4.val = 5;n5.val = 3; n6.val = 25;
		n2.left = n4; n2.right = n5; n3.right = n6;n3.left = null;
		n7.val = 10; n8.val = 14;
		n5.left = n7; n5.right = n8;
		n7.left = null;n7.right = null;
		n8.left = null; n8.right = null;
		
		Map<Integer,Tree> map = new HashMap<Integer,Tree>();
		printBottomView(n1,0,map);
		
		for(Map.Entry<Integer, Tree> entry : map.entrySet()){
			System.out.println(entry.getValue());
		}
	}
	
	private static void printBottomView(Tree root,int val,Map<Integer,Tree> map){
		if(root==null)
			return;
		
		root.horizontalDistance = 0;
		ArrayList<Tree> queue = new ArrayList<Tree>();
		queue.add(root);
		
		
		while(!queue.isEmpty()){
			Tree curr = queue.remove(0);
			if(curr.left!=null){
				curr.left.horizontalDistance = curr.horizontalDistance-1;
				queue.add(curr.left);
			}
			if(curr.right!=null){
				curr.right.horizontalDistance = curr.horizontalDistance+1;
				queue.add(curr.right);
			}
			map.put(curr.horizontalDistance, curr);
		}
	}

}
