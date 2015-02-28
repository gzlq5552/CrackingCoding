package helper.linkedlist;

public class LinkedListLoop {
	
	public int mLength = 0;
	public LinkedListNode mHead;
	int mLoopStart = 1;
	LinkedListNode mLoopStartNode;
	
	final String LOG_DELIM = "->";
	
	public LinkedListLoop (int[] data, int loopStart) {
		mLength = data.length;
		mHead = new LinkedListNode(data[0], null, null);
		
		if (data.length <= 0 || loopStart >= data.length) {
			mLoopStart = 0;
			mLoopStartNode = mHead;
		} else {
			mLoopStart = loopStart;
		}
		LinkedListNode current = mHead;
		for (int i = 1; i < data.length; ++i) {
			current.mNext = new LinkedListNode(data[i], current, null);
			current = current.mNext;
			if (i == loopStart) {
				mLoopStartNode = current;
			}
		}
		current.mNext = mLoopStartNode;
	}
	
	public void printLoopStart() {
		System.out.println("The cicular list start node value is: " + mLoopStartNode.mData);
	}
	
	public void print() {
		System.out.println("Print the circular list: ");
		LinkedListNode current = mHead;
		for (int i = 0; i < mLength + mLength - mLoopStart; ++i) {
			System.out.print(current.mData + LOG_DELIM);
			current = current.mNext;
		}
		System.out.print(current.mData + "\n");
	}
}
