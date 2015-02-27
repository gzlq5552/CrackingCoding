package helper.linkedlist;


// TODO: make this a generic class
public class LinkedListNode {
	public LinkedListNode mNext;
	public LinkedListNode mPrev;
	public int mData;
	
	public LinkedListNode (int data) {
		mData = data;
	}
	public LinkedListNode (int data, LinkedListNode prev, LinkedListNode next) {
		mPrev = prev;
		mNext = next;
		mData = data;
	}
	
	public void print () {
		System.out.println("Printing node: " + mData);
	}
	
	
	// TODO: implement a generic compare mData method
}

