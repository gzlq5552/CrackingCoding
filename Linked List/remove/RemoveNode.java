/*
 * Question 2.3: Implement an algorithm to delete a node in the 
 * middle of a singly linked list, given only access to that node
 */

package remove;

import kth2last.FindKth2Last;
import helper.linkedlist.LinkedList;
import helper.linkedlist.LinkedListNode;

public class RemoveNode {
	public static void main (String[] args) {
		int[] data = {1, 3, 3, 2, 5, 6};
		LinkedList l = new LinkedList(data);
		LinkedListNode head = l.mHead;
		final int KTH_2_LAST = 3;
		LinkedListNode node = FindKth2Last.findKth2LastIter(l.mHead, KTH_2_LAST);	
		System.out.println("List before: ");
		LinkedList.print(head);
		removeNode(node);
		System.out.println("List after: ");
		LinkedList.print(head);
	}

	
	static boolean removeNode (LinkedListNode node) {
		if (node == null || node.mNext == null)
			return false; // failed to remove, set this to dummy node
		
		node.mData = node.mNext.mData;
		node.mNext = node.mNext.mNext;
		return true;
	}
}
