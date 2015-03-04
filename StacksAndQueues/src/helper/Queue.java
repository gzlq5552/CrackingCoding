package helper;

import helper.linkedlist.LinkedListNode;

public class Queue {

	LinkedListNode first;
	LinkedListNode last;
	
	public Object peek() {
		if (first != null) {
			return first.mData;
		}
		System.out.println("Queue is empty!");
		return null;
	}
	
	public Object dequeue() {
		if (first != null) {
			Object item = first.mData;
			first = first.mNext;
			return item;
		}
		return null;
	}
	
	public void enqueue (int item) {
		if (first == null) {
			first.mData = item;
			last = first;
		} else {
			last.mNext = new LinkedListNode(item, last, null);
			last = last.mNext;
		}
	}
}
