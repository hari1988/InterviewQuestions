package sample;

public class NToLastElementLinkedList {

	public static void main(String[] args) {
		LinkedListNode n1 = new LinkedListNode();
		LinkedListNode n2 = new LinkedListNode();
		LinkedListNode n3 = new LinkedListNode();
		LinkedListNode n4 = new LinkedListNode();
		LinkedListNode n5 = new LinkedListNode();
		
		n1.elem =1;n2.elem =2;n3.elem =3;n4.elem =4;n5.elem =5;
		n1.next = n2; n2.next = n3; n3.next = n4;n4.next = n5;n5.next = null;
		
		int n = 6;
		LinkedListNode last = findNToLastElement(n1,n);
		if(last==null)
			System.out.println("nothing");
		else
			System.out.println(last.elem);

	}
	
	private static LinkedListNode findNToLastElement(LinkedListNode n1,int n){
		if(n1==null)
			return n1;
		
		if(n==1)
			return null;
		
		LinkedListNode curr = n1;
		int count = 0;
		
		while(curr!=null && count<n){
			curr = curr.next;
			count++;
		}
		if(count<n)
			return null;
		//curr now points the right node
		while(curr!=null){
			curr = curr.next;
			n1 = n1.next;
		}
		
		return n1;
			
	}

}
