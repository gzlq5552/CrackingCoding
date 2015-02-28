/*
 * Question 2.6: Given a circular linked list, implement an algorithm which returns the 
 * node at the beginning of the loop
 */
package findLoopHead;

import helper.linkedlist.LinkedListLoop;
import helper.linkedlist.LinkedListNode;

public class FindLoopingListHead {

	public static void main (String[] args) {
		int[] data = {1, 2, 3, 4, 5, 6, 7, 8};
		LinkedListLoop loopedList = new LinkedListLoop(data, 4);
		loopedList.printLoopStart();
		loopedList.print();
		LinkedListNode node = findLoopStart(loopedList.mHead);
		node.print();
	}
	
	static LinkedListNode findLoopStart (LinkedListNode head) {
		LinkedListNode slowRunner = head;
		LinkedListNode fastRunner = head;
		
		// Find meeting point. This will be LOOP_SIZE - k steps into the linked list.
		while (fastRunner != null && fastRunner.mNext != null) {
			slowRunner = slowRunner.mNext;
			fastRunner = fastRunner.mNext.mNext;
			if (slowRunner == fastRunner) {
				break;
			}
		}
		
		// Error check - no meeting point, and therefore no loop
		if (fastRunner == null || fastRunner.mNext == null) {
			return null;
		}
		
		/* Move slow to Head. Keep fast at Meeting Point. Each are k
		 * steps from the Loop Start. If they move at the same pace,
		 * they must meet at Loop Start. */
		
		slowRunner = head;
		while (slowRunner != fastRunner) {
			slowRunner = slowRunner.mNext;
			fastRunner = fastRunner.mNext;
		}
		
		// Both now point to the start of the loop
		return fastRunner;
	}
}
