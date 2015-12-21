package sample;

public class MergeLinkedLists {
	
	public static void main(String[] args){
		LinkedListNode n1 = new LinkedListNode();
		LinkedListNode n2 = new LinkedListNode();
		LinkedListNode n3 = new LinkedListNode();
		LinkedListNode n4 = new LinkedListNode();
		LinkedListNode n5 = new LinkedListNode();
		LinkedListNode n6 = new LinkedListNode();
		n1.elem=1;
		n2.elem=2;
		n3.elem=3;
		n4.elem=4;
		n5.elem=5;
		n6.elem=6;
		n1.next = n2; n2.next = n3; n3.next = null; 
		n6.next = n5;n5.next = n4;n4.next = null;
		LinkedListNode head = n1;
		LinkedListNode head1 = n1; LinkedListNode head2 = n6;
		while(head1!=null && head2!=null){
			LinkedListNode temp1 = head1.next;
			LinkedListNode temp2 = head2.next;
			head1.next = head2;
			if(temp1!=null)
				head2.next = temp1;
			
			head1 = temp1;
			head2 = temp2;
		}
		
		while(head!=null){
			System.out.print(head.elem+" ");
			head = head.next;
		}
		
	}

}
