/*
 * Question 2.7: Implement a function to check if a linked list is a palindrome
 */
package isPalindrome;

import java.util.Stack;

import helper.linkedlist.LinkedList;
import helper.linkedlist.LinkedListNode;

public class CheckIfPalindrome {

	public static void main (String[] args) {
		int[] data = {1, 2, 3, 4, 5, 4, 3, 2, 1};
		LinkedList l = new LinkedList(data);
		boolean ispal = isPalindrome(l.mHead);
		System.out.println("Is palindrome: " + ispal);
		ispal = isPalindrome2(l.mHead);
		System.out.println("Is palindrome: " + ispal);
	}
	
	static boolean isPalindrome (LinkedListNode head) {
		LinkedListNode fast = head;
		LinkedListNode slow = head;
		
		Stack<Integer> stack = new Stack<Integer>();

		/* Push elements from first half of linked list onto stack. When
		 * fast runner (which is moving at 2x speed) reaches the end of
		 * the linked list, then we know we're at the middle */
		while (fast != null && fast.mNext != null) {
			stack.push(slow.mData);
			slow = slow.mNext;
			fast = fast.mNext.mNext;
		}
		
		// Has odd number of elements, so skip the middle element
		if (fast != null) {
			slow = slow.mNext;
		}
		
		while (slow != null) {

			int top = stack.pop().intValue();
			if (slow.mData != top) {
				return false;
			}
			slow = slow.mNext;
		}
		return true;
	}
	
	static Result isPanlindromeRecurse (LinkedListNode head, int length) {
		if (head == null || length == 0) {
			return new Result(null, true);
		} else if (length == 1) {
			return new Result(head.mNext, true);
		} else if (length == 2) {
			return new Result(head.mNext.mNext, head.mData == head.mNext.mData);
		}

		Result res = isPanlindromeRecurse(head.mNext, length - 2);
		if (!res.mResult || res.mNode == null) {
			return res;
		} else {
			res.mResult = head.mData == res.mNode.mData;
			res.mNode = res.mNode.mNext;
			return res;
		}
	}
	
	static boolean isPalindrome2 (LinkedListNode head) {
		Result res = isPanlindromeRecurse(head, LinkedList.length(head));
		return res.mResult;
	}
}

