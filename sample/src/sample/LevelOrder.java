package sample;

public class LevelOrder {

	public static void main(String[] args) {
		Tree n1 = new Tree();
		Tree n2 = new Tree();
		Tree n3 = new Tree();
		Tree n4 = new Tree();
		Tree n5 = new Tree();
		n1.val = 1;n2.val = 2;n3.val = 3;n4.val = 4;n5.val = 5;
		n1.left = n2;n1.right=n3;n2.left = n4;n2.right=n5;
		n4.left=null;n4.right = null; n5.left = null; n5.right = null;
		n3.left = null;n3.right = null;
		printLevelOrder(n1);
		
	}

	private static void printLevelOrder(Tree root){
		if(root==null)
			return;
		boolean ltr= true;
		for(int i=1;i<=height(root);i++){
			printLevel(root,i,ltr);
			ltr = !ltr;
		}
	}
	
	private static void printLevel(Tree root, int level,boolean ltr){
		if(root==null)
			return;
		if(level==1)
			System.out.println(root.val);
		if(ltr){
			printLevel(root.left, level-1,ltr);
			printLevel(root.right, level-1,ltr);
		}
		else{
			printLevel(root.right, level-1,ltr);
			printLevel(root.left, level-1,ltr);
		}
	}
	
	private static int height(Tree root){
		if(root==null)
			return 0;
		int leftH = height(root.left);
		int rightH = height(root.right);
		return max(leftH,rightH)+1;
	}
	
	private static int max(int i,int j){
		if(i<j)
			return j;
		return i;
	}
}
