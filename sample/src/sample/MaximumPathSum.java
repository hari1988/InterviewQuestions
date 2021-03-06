package sample;

public class MaximumPathSum {
	
	static int sum = Integer.MIN_VALUE;

	public static void main(String[] args) {
		Tree n1 = new Tree();
		Tree n2 = new Tree();
		Tree n3 = new Tree();
		Tree n4 = new Tree();
		Tree n5 = new Tree();
		Tree n6 = new Tree();
		Tree n7 = new Tree();
		Tree n8 = new Tree();
		
		n1.val = 10;n2.val =2;n3.val=10;
		n1.left=n2;n1.right=n3;
		n4.val=20;n5.val=1;n6.val = -25;
		n2.left=n4;n2.right=n5;
		n3.left=null;n3.right=n6;
		n4.left=null;n4.right=null;n5.left=null;n5.right=null;
		n7.val=3;n8.val=4;
		n6.left=n7;n6.right=n8;
		n7.left=null;n7.right=null;n8.left=null;n8.right=null;
		
		printMaxSum(n1);
		System.out.println(sum);
	}
	
	private static int printMaxSum(Tree root){
		if(root==null)
			return 0;
		
		int left = printMaxSum(root.left);
		int right= printMaxSum(root.right);
		
		int maximum_single = max(max(left,right)+root.val,root.val);
		
		int maximum = max(maximum_single,left+right+root.val);
		
		sum = max(sum,maximum);
		
		return maximum_single;
	}
	
	private static int max(int a,int b){
		if(a>b)
			return a;
		return b;
	}

}
