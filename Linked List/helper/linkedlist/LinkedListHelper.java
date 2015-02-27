//package helper.linkedlist;
//
//import java.util.Arrays;
//
//public class LinkedListHelper {
//	
//	public static LinkedListNode createSinglyLinkedList (Object[] dataArray) {
//		String[] strArray = Arrays.copyOf(dataArray, dataArray.length, String[].class);
//		LinkedListNode head = new LinkedListNode(strArray[0]);
//		LinkedListNode headNode = head;
//		for (int i = 1; i < dataArray.length; ++i) {
//			LinkedListNode next = new LinkedListNode(dataArray[i]);
//			head.mNext = next;
//			head = next;
//		}
//		head.mNext = null;
//		return headNode;
//	}
//	
//	
//	public static void printList (LinkedListNode n) {
//		System.out.println("Printing the singly linked list items: ");
//		while (n != null) {
//			System.out.println(n.mData);
//			n = n.mNext;
//		}
//	}
//	
//	public static void printNode (LinkedListNode node) {
//		System.out.println("Node is: " + node.mData.toString());
//	};
//}
