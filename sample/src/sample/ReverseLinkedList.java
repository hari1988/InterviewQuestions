package sample;

public class ReverseLinkedList {
	
	public static void main(String[] args){
		LinkedListNode n1 = new LinkedListNode();
		LinkedListNode n2 = new LinkedListNode();
		LinkedListNode n3 = new LinkedListNode();
		LinkedListNode n4 = new LinkedListNode();
		LinkedListNode n5 = new LinkedListNode();
		LinkedListNode n6 = new LinkedListNode();
		n1.elem=1;n2.elem=2;n3.elem=3;n4.elem=4;n5.elem=5;n6.elem=6;
		n1.next = n2; n2.next = n3; n3.next = n4; n4.next = n5;
		n5.next = n6;n6.next = null;
		
		LinkedListNode rev = reverse(n1);
		
		print(rev);
	}
	
	private static void print(LinkedListNode n){
		while(n!=null){
			System.out.print(n.elem+" ");
			n = n.next;
		}
		System.out.println();
	}
	
	private static LinkedListNode reverse(LinkedListNode head){
		if(head==null || head.next==null)
			return head;
		
		LinkedListNode prev = null;
		
		while(head!=null){
			LinkedListNode tmp = head.next;
			head.next = prev;
			prev = head;
			head = tmp;
		}
		return prev;
	}

}
