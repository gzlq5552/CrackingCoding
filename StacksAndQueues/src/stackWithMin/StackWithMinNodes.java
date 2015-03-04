package stackWithMin;

import java.util.Stack;

public class StackWithMinNodes extends Stack<NodeWithMin> {

	public void push (int item) {
		NodeWithMin newMin = new NodeWithMin(item, Math.min(item, min()));
		push(newMin);
	}
	
	public int min () {
		if (isEmpty()) {
			return Integer.MAX_VALUE;
		}
		return peek().min;
	}
}
