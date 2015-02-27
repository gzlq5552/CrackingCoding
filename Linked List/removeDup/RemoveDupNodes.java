package removeDup;

import helper.linkedlist.LinkedList;
import helper.linkedlist.LinkedListNode;

import com.sun.org.apache.xalan.internal.xsltc.runtime.Hashtable;

public class RemoveDupNodes {
	public static void main (String[] args) {
		int[] data = {1, 3, 3, 2, 5, 6};
		LinkedList l = new LinkedList(data);
		removeDups(l.mHead);	
		l.print();
		
		int[] data1 = {1, 3, 3, 2, 5, 6, 7, 7};
		LinkedList l1 = new LinkedList(data1);
		removeDupsWithoutBuffer(l1.mHead);
		l1.print();
	}
	
	static void removeDups (LinkedListNode n) {
		Hashtable table = new Hashtable();
		LinkedListNode prev = null;
		
		while (n != null) {
			if (table.containsKey(n.mData)) {
				prev.mNext = n.mNext;
			} else {
				table.put(n.mData, true);
				prev = n;
			}
			
			n = n.mNext;
		}
	}
	
	static void removeDupsWithoutBuffer (LinkedListNode n) {
		if (n == null) return;
		
		LinkedListNode current = n;
		while (current != null) {
			LinkedListNode runner = current;
			
			while (runner.mNext != null) {
				if (runner.mNext.mData == current.mData) {
					runner.mNext = runner.mNext.mNext;
				} else {
					runner = runner.mNext;
				}
			}
			current = current.mNext;
		}
	}

}
