package addition.linkedlist;

import helper.linkedlist.LinkedList;
import helper.linkedlist.LinkedListNode;


public class LinkedListAddition {

	public static void main (String[] args) {
		int[] ary1 = {4, 1, 2}; 
		int[] ary2 = {9, 7, 5}; 
		
		LinkedList l1 = new LinkedList(ary1);
		LinkedList l2 = new LinkedList(ary2);
		LinkedListNode sum = addNodes(l1.mHead, l2.mHead, 0); // 214 + 579 = 793
		LinkedList.print(sum);
		sum = addListsForward(l1.mHead, l2.mHead); // 412 + 975 = 1387
		LinkedList.print(sum);
	}
	
	public static LinkedListNode addNodes (LinkedListNode n1, LinkedListNode n2, int carry) {
		if (n1 == null && n2 == null && carry == 0) {
			return null;
		}
		
		LinkedListNode sum = new LinkedListNode(carry);
		
		int sum_value = carry;
		
		if (n1 != null) {
			sum_value += n1.mData;
		}
		
		if (n2 != null) {
			sum_value += n2.mData;
		}
		
		sum.mData = sum_value % 10;
		
		if (n1 != null ||  n2 != null) {
			LinkedListNode next = addNodes(n1 == null ? null : n1.mNext,
											  n2 == null ? null : n2.mNext, 
											  (int) (sum_value / 10));
			sum.mNext = next;
		}
		return sum;		
	}
	
	static LinkedListNode addListsForward (LinkedListNode n1, LinkedListNode n2) {
		int len1 = LinkedList.length(n1);
		int len2 = LinkedList.length(n2);
		
		if (len1 < len2) {
			n1 = padZeros (n1, len2 - len1);
		} else {
			n2 = padZeros (n2, len1 - len2);
		}
		
		PartialSum sum = addHelper(n1, n2);
		
		if (sum.carry == 0){
			return sum.sum;
		} else {
			LinkedListNode result = insertBefore(sum.sum, sum.carry);
			return result;
		}
		
	}

	static LinkedListNode padZeros(LinkedListNode n, int padding) {
		LinkedListNode head = n;
		for (int i = 0; i < padding; ++i) {
			LinkedListNode n0 = new LinkedListNode(0, null, null);
			head.mPrev = n0;
			n0.mNext = head;
			head = n0;
		}		
		return head;
	}


	static PartialSum addHelper(LinkedListNode n1, LinkedListNode n2) {
		if (n1 == null && n2 == null) {
			return new PartialSum();
		}
		
		// recurse: add smaller digits
		PartialSum sum = addHelper(n1.mNext, n2.mNext);
		int sumValue = sum.carry + n1.mData + n2.mData;
		
		// insert sum of current digits
		LinkedListNode fullSum = insertBefore(sum.sum, sumValue % 10);
		
		// return sum so far and carry
		sum.sum = fullSum;
		sum.carry = sumValue / 10;
		
		return sum;		
	}

	static LinkedListNode insertBefore(LinkedListNode n, int data) {
		LinkedListNode node = new LinkedListNode(data, null, null);
		if (n != null) {
			n.mPrev = node;
			node.mNext = n;
		}
		return node;
	}
}
