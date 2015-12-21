package sample;

//1->2->3->4->5->6 ------ 1->6->2->5->3->4

//merge 1->2->3 and 6->5->4 ==== 1->6->2->5->3->4 

class LinkedListNode{
	int elem;
	LinkedListNode next;
}

public class RearrangeLinkedList {

	public static void main(String[] args) {
		LinkedListNode n1 = new LinkedListNode();
		LinkedListNode n2 = new LinkedListNode();
		LinkedListNode n3 = new LinkedListNode();
		LinkedListNode n4 = new LinkedListNode();
		LinkedListNode n5 = new LinkedListNode();
		LinkedListNode n6 = new LinkedListNode();
		n1.elem=1;n2.elem=2;n3.elem=3;n4.elem=4;n5.elem=5;n6.elem=6;
		n1.next = n2; n2.next = n3; n3.next = n4; n4.next = n5;
		n5.next = n6;n6.next = null;
		
		//find the mid
		LinkedListNode mid = findMid(n1);
		
		//reverse the list from middle
		LinkedListNode rev = reverse(mid);
		
		//print(rev);
		
		print(rearrange(n1,rev));
	}
	
	private static LinkedListNode rearrange(LinkedListNode p1, LinkedListNode p2){
		LinkedListNode ret = p1;
		while(p1!=null && p2!=null){
			LinkedListNode temp = p1.next;
			LinkedListNode temp2 = p2.next;
			p1.next = p2;
			if(p2!=temp)
				p2.next = temp;
			p1 = temp;
			p2 = temp2;
		}
		return ret;
	}
	
	private static void print(LinkedListNode node){
		while(node!=null){
			System.out.print(node.elem+" ");
			node = node.next;
		}
		System.out.println();
	}
	
	private static LinkedListNode reverse(LinkedListNode head){
		if(head==null)
			return null;
		if(head.next==null)
			return head;
		LinkedListNode prev = null;
		
		while(head!=null){
			LinkedListNode temp = head.next;
			head.next = prev;
			prev = head;
			head = temp;
		}
		return prev;
	}
	
	private static LinkedListNode findMid(LinkedListNode head){
		if(head==null)
			return null;
		
		LinkedListNode slow = head;
		LinkedListNode fast = head;
		while(fast!=null && fast.next!=null){
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}
	
}
