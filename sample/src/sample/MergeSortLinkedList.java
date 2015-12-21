package sample;

import java.util.LinkedList;

public class MergeSortLinkedList {

	public static void main(String[] args) {
		LinkedListNode n1 = new LinkedListNode();
		LinkedListNode n2 = new LinkedListNode();
		LinkedListNode n3 = new LinkedListNode();
		LinkedListNode n4 = new LinkedListNode();
		LinkedListNode n5 = new LinkedListNode();
		LinkedListNode n6 = new LinkedListNode();
		n1.elem=5;n2.elem=4;n3.elem=3;n4.elem=2;n5.elem=1;n6.elem=6;
		n1.next = n2; n2.next = n3; n3.next = n4; n4.next = n5;
		n5.next = n6;n6.next = null;
		
		LinkedListNode sorted = mergeSort(n1);
		
		print(sorted);

	}
	
	
	private static void print(LinkedListNode node){
		while(node!=null){
			System.out.print(node.elem+" ");
			node = node.next;
		}
		System.out.println();
	}
	
	private static LinkedListNode mergeSort(LinkedListNode head){
		
		if(head==null ||head.next==null)
			return head;
		
		LinkedListNode a = head;
		
		//find mid point
		LinkedListNode mid = findMid(head);

		LinkedListNode b = mid;
		
		return MergeLists(mergeSort(a),mergeSort(b));
	}
	
	static LinkedListNode MergeLists(LinkedListNode list1, LinkedListNode list2) {
		  if (list1 == null) return list2;
		  if (list2 == null) return list1;

		  if (list1.elem < list2.elem) {
		    list1.next = MergeLists(list1.next, list2);
		    return list1;
		  } else {
		    list2.next = MergeLists(list2.next, list1);
		    return list2;
		  }
		}
	
	private static LinkedListNode merge(LinkedListNode a,LinkedListNode b){
		LinkedListNode res = new LinkedListNode();
		res.elem=-1;
		res.next = null;
		
		LinkedListNode c = res;
		while(a!=null && b!=null){
			if(a.elem<=b.elem){
				c.next = a;
				c = c.next;
				a = a.next;
			}
			else{
				c.next = b;
				c = c.next;
				b = b.next;
			}
		}
		
		while(a!=null){
			c.next = a;
			a = a.next;
			c = c.next;
		}
		
		while(b!=null){
			c.next = b;
			b = b.next;
			c = c.next;
		}
		
		return res.next;
	}
	
	private static LinkedListNode findMid(LinkedListNode node){
		LinkedListNode slow = node;
		LinkedListNode fast = node.next;
		
		while(fast!=null && fast.next!=null){
			slow = slow.next;
			fast = fast.next.next;
		}
		LinkedListNode ret = slow.next;
		slow.next = null;
		return ret;
	}

}
