package sample;

public class BinaryTreeToLinkedList {

	public static void main(String[] args) {
		Tree n1 = new Tree();
		Tree n2 = new Tree();
		Tree n3 = new Tree();
		Tree n4 = new Tree();
		Tree n5 = new Tree();
		n1.val = 1;n2.val = 2;n3.val = 3;n4.val = 4;n5.val = 5;
		
	}

}

class Tree{
	int val;
	Tree left;
	Tree right;
	int horizontalDistance;
	
	public String toString(){
		return String.valueOf(val);
	}
}
