package stackWithMin;

import java.util.Stack;

/*
 * Question 3.2: How would you design a stack which, in addition to push and pop, also has a
 * function min which returns the minimum element? Push, pop and min should all operate in 0(1)
 * time
 */
public class StackWithMin extends Stack<Integer> {

	Stack<Integer> auxStack;
	
	public StackWithMin() {
		auxStack = new Stack<Integer> ();
	}
	
	public void push (int item) {
		if (item <= min()) {
			auxStack.push(item);
		}
		super.push(item);
	}
	
	public Integer pop () {
		int value = super.pop();
		if (value == min()) {
			auxStack.pop();
		}
		return value;
	}
	
	public int min() {
		if (auxStack.isEmpty()) {
			return Integer.MAX_VALUE;
		}
		return auxStack.peek();
	}
}
