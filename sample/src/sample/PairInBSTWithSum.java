package sample;

import java.util.ArrayList;

class StackForTree {
	
	ArrayList<Tree> st;
	
	public StackForTree(){
		st = new ArrayList<Tree>();
	}
	
	public ArrayList<Tree> getSt() {
		return st;
	}

	public void setSt(ArrayList<Tree> st) {
		this.st = st;
	}

	public Tree getTop(){
		if(st.size()==0){
			return null;
		}
		return st.get(st.size()-1);
	}
	
	public void push(Tree elem){
		st.add(elem);
	}
	
	public Tree pop(){
		if(this.isEmpty()){
			return null;
		}
		return st.remove(st.size()-1);
	}
	
	public boolean isEmpty(){
		return st.size()>0?false:true;
	}
}

public class PairInBSTWithSum {
	
	public static void main(String[] args){
		Tree n1 = new Tree();
		Tree n2 = new Tree();
		Tree n3 = new Tree();
		Tree n4 = new Tree();
		Tree n5 = new Tree();
		Tree n6 = new Tree();
		Tree n7 = new Tree();
			
		n1.val = 15;n2.val = 10; n3.val = 20;
		n1.left = n2; n1.right = n3;
		n4.val = 8;n5.val = 12; n6.val = 16;n7.val = 25;
		n2.left = n4; n2.right = n5; n3.left = n6;n3.right = n7;
		n4.left = null;n4.right = null;n5.left=null;n5.right=null;
		n6.left = null;n6.right = null;n7.left=null;n7.right = null;
		
		int sum = 37;
		System.out.println(findPair(n1,sum));
	}
	
	private static boolean findPair(Tree root,int sum){
		StackForTree s1= new StackForTree();
		StackForTree s2 = new StackForTree();
		
		Tree inOrderNode = root;int currInorderVal =0; boolean inOrderFinished=false;
		Tree reverseinOrderNode = root;int currReverseInorderVal =0; boolean reverseinOrderFinished=false;
		while(true){
			//find the next inorder node 
			
			while(!inOrderFinished){
				
				if(inOrderNode!=null){
					s1.push(inOrderNode);
					inOrderNode = inOrderNode.left;
				}
				else{
					if(s1.isEmpty())
						inOrderFinished=true;
					else{
						inOrderNode = s1.pop();
						currInorderVal = inOrderNode.val;
						inOrderFinished = true;
						inOrderNode = inOrderNode.right;
					}
				}
			}
			
			while(!reverseinOrderFinished){
				
				if(reverseinOrderNode!=null){
					s2.push(reverseinOrderNode);
					reverseinOrderNode = reverseinOrderNode.right;
				}
				else{
					
					if(s2.isEmpty())
						reverseinOrderFinished=true;
					else{
						reverseinOrderNode = s2.pop();
						currReverseInorderVal = reverseinOrderNode.val;
						reverseinOrderFinished = true;
						reverseinOrderNode = reverseinOrderNode.left;
					}
				}
			}
			
			if(currInorderVal!= currReverseInorderVal && currInorderVal+currReverseInorderVal==sum){
				return true;
			}
			
			else if(currInorderVal+currReverseInorderVal<sum){
				inOrderFinished = false;
			}
			else if(currInorderVal+currReverseInorderVal>sum){
				reverseinOrderFinished = false;
			}
			
			if(currInorderVal>=currReverseInorderVal)
				return false;
			
		}
		
		
		
		
	}

}
