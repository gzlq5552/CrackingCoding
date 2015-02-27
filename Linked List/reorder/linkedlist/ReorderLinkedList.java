package reorder.linkedlist;

import helper.linkedlist.*;

public class ReorderLinkedList {
	public static void main (String[] args) {
		int[] dataArray = {3, 2, 8, 72, 0, 5, 9};
		LinkedList l = new LinkedList(dataArray);
		int x = 5;
		LinkedListNode newHead = reorderSinglyLinkedList(l.mHead, x);
		LinkedList.print(newHead);
		
		System.out.println("Check out the new list: ");
		LinkedListNode newHead1 = reorderWithLessSpace(newHead, x);
		LinkedList.print(newHead1);
	}
	
	// Approach A: use two separate lists to keep track of before and after elms,
	// and then merge the two
	public static LinkedListNode reorderSinglyLinkedList (LinkedListNode head, int x) {
		LinkedListNode beforeStart = null, 
				beforeEnd = null,
				afterStart = null,
				afterEnd = null;
		
		while (head != null) {
			
			LinkedListNode next = head.mNext;
			head.mNext = null;
			
			// if string is before x, add it to before list
			if (head.mData < x) {
				if (beforeStart == null) {
					beforeStart = head;
					beforeEnd = beforeStart;
				} else {
					beforeEnd.mNext = head;
					beforeEnd = head;
				}
			} else {
				if (afterStart == null) {
					afterStart = head;
					afterEnd = afterStart;
				} else {
					afterEnd.mNext = head;
					afterEnd = head;
				}
			}
			
			head = next;
		}
		
		if (beforeStart == null)
			return afterStart;
		
		// combine the before and after lists
		beforeEnd.mNext = afterStart;
		
		return beforeStart;
	}
	
	// Approach B: keep two lists only and insert nodes in front of them instead
	public static LinkedListNode reorderWithLessSpace (LinkedListNode head, int x) {
		LinkedListNode beforeList = null, afterList = null;
		
		while (head != null) {
			LinkedListNode next = head.mNext;
			
			// if smaller, insert it in front of afterList
//			if (head.mData.toString().compareTo(x) < 0) {
			if (head.mData < x) {
				head.mNext = beforeList;
				beforeList = head;
			} else {
				head.mNext = afterList;
				afterList = head;
			}
			
			head = next;
		}
		
		if (beforeList == null) return afterList;
		
		LinkedListNode newHead = beforeList;
		while (beforeList.mNext != null) {
			beforeList = beforeList.mNext;
		}
		beforeList.mNext = afterList;
		return newHead;
	}
}
