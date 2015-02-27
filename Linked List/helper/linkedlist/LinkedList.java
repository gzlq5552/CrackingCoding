package helper.linkedlist;

public class LinkedList {

	final static String SYMBOL = "->";
	final static String LOG_PRINT = "Printing the list: ";
	public LinkedListNode mHead = null;
	
	public LinkedList () {}
	
	public LinkedList (LinkedListNode head) {
		mHead = head;
	}
	
	public LinkedList (int[] data) {
		LinkedListNode head = new LinkedListNode(data[0]);
		mHead = head;
		for (int i = 1; i < data.length; ++i) {
			LinkedListNode next = new LinkedListNode(data[i]);
			head.mNext = next;
			head = next;
		}
	}
	
	public void print () {
		print(mHead);
	}
	
	public static void print (LinkedListNode n) {
		System.out.println(LOG_PRINT);
		while (n != null) {
			System.out.print(n.mData);
			n = n.mNext;
			if (n != null) {
				System.out.print(SYMBOL);
			}
		}
		System.out.println();
	}
	
	public static int length (LinkedListNode n) {
		int l = 0; 
		while (n != null) {
			++l;
			n = n.mNext;
		}
		return l;
	}
	
}
