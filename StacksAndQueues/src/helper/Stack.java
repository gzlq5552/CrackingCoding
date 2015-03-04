package helper;

import helper.linkedlist.LinkedListNode;

public class Stack {
	LinkedListNode top;
	
	public Object top () {
		if (top != null) {
			return top.mData;
		}
		System.out.println("Stack is empty!");
		return null;
	}
	
	public Object pop () {
		if (top != null) {
			Object item = top.mData;
			top = top.mNext;
			return item;
		}
		System.out.println("Stack is empty!");
		return null;
	}
	
	public void push (int item) {
		LinkedListNode newTop = new LinkedListNode(item, null, top);
		top = newTop;
		
	}
}
