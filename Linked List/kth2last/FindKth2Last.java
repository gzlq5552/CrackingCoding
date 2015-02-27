package kth2last;

import helper.linkedlist.LinkedList;
import helper.linkedlist.LinkedListNode;

public class FindKth2Last {

	public static void main (String[] args) {
//		Object[] dataArray = {"a", "b", "C", "c2", "3", "c", "b"};
		int[] data = {1, 3, 3, 2, 5, 6};
		LinkedList l = new LinkedList(data);
		final int KTH_2_LAST = 3;
		printKth2Last(l.mHead, KTH_2_LAST);	
		IntWrapper i = new IntWrapper();
		LinkedListNode node = findKth2LastWithWrapper(l.mHead, KTH_2_LAST, i);
		node.print();
		node = findKth2LastIter(l.mHead, KTH_2_LAST);
		node.print();
		
	}
	
	// Both recursive solution takes O(n) space
	// Approach A: instead of returning the element, print the kth to last element
	static int printKth2Last (LinkedListNode head, int k) {
		if (head == null) {
			return 0;
		}
		
		int counter = printKth2Last(head.mNext, k) + 1;
		if (counter == k) {
			System.out.println("The " + k + "th to the last element is: " + head.mData);
		}
		return counter;
	}
	
	// Approach B: use a wrapper class to mimic passing by reference of a counter value
	// that keeps track of what node we are at
	static LinkedListNode findKth2LastWithWrapper (LinkedListNode head, int k, IntWrapper i) {
		if (head == null) 
			return null;
		
		LinkedListNode node = findKth2LastWithWrapper(head.mNext, k, i);
		i.value += 1;
		if (i.value == k) {
			return head;
		}
		return node;
	}
	
	
	// Approach C: have two pointers walk the list k - 1 steps apart; when one reaches
	// the end, then the other one reaches length - k, assuming length unknown
	public static LinkedListNode findKth2LastIter (LinkedListNode head, int k) {
		if (k <= 0 || head == null) return null;
		
		LinkedListNode p1 = head;
		LinkedListNode p2 = head;
		
		for (int i = 0; i < k - 1; ++i) {
			if (p1 == null) return null;
			p1 = p1.mNext;
		}
		
		while (p1.mNext != null) {
			p1 = p1.mNext;
			p2 = p2.mNext;
		}
		
		return p2;
	}
}
