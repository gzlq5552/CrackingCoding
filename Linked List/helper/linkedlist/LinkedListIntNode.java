//package helper.linkedlist;
//
//
//// TODO: make this a generic class
//public class LinkedListIntNode {
//	public LinkedListIntNode mNext;
//	public LinkedListIntNode mPrev;
//	public int mData;
//	
//	public LinkedListIntNode (int data) {
//		mData = data;
//	}
//	
//	public static LinkedListIntNode createSinglyLinkedList (int[] dataArray) {
//		LinkedListIntNode head = new LinkedListIntNode(dataArray[0]);
//		LinkedListIntNode headNode = head;
//		for (int i = 1; i < dataArray.length; ++i) {
//			LinkedListIntNode next = new LinkedListIntNode(dataArray[i]);
//			head.mNext = next;
//			head = next;
//		}
//		head.mNext = null;
//		return headNode;
//	}
//	
//	public static void printList (LinkedListIntNode n) {
//		System.out.println("Printing the singly linked list items: ");
//		while (n != null) {
//			System.out.println(n.mData);
//			n = n.mNext;
//		}
//	}
//	
//	// TODO: implement a generic compare mData method
//}
