package sample;

public class LeavesToDLL {
	
	static Tree head = null;

	public static void main(String[] args){
		Tree n1 = new Tree();
		Tree n2 = new Tree();
		Tree n3 = new Tree();
		Tree n4 = new Tree();
		Tree n5 = new Tree();
		Tree n6 = new Tree();
		Tree n7 = new Tree();
		Tree n8 = new Tree();
		Tree n9 = new Tree();
		Tree n10 = new Tree();
		
		n1.val = 1;n2.val = 2;n3.val = 3;n4.val = 4;n5.val = 5;
		n6.val = 6;n7.val = 7;n8.val = 8;n9.val = 9;n10.val = 10;
		n1.left = n2;n1.right =n3;
		n2.left = n4;n2.right = n5;
		n3.left = null;n3.right = n6;
		n4.left = n7;n4.right = n8;
		n5.left = null;n5.right = null;
		n6.left = n9;n6.right = n10;
		n7.left = null;n7.right = null;
		n8.left = null;n8.right = null;
		n9.left = null;n9.right = null;
		n10.left = null;n10.right = null;
		
		Tree newRoot = convert(n1);
		
		print(newRoot);
		
		System.out.println();
		
	}
	
	private static void print(Tree node){
		
		if(node==null)
			return;
		
		System.out.println(node.val);
		
		print(node.left);
		print(node.right);
	}
	
	private static Tree convert(Tree root){
		if(root==null)
			return null;
		
		if(root.left==null && root.right==null){
			root.right = head;
			
			if(head!=null){
				head.left = root;
			}
			
			head = root;
			
			return null;
		}
		
		root.right = convert(root.right);
		root.left = convert(root.left);
	
		return root;
	}
}
