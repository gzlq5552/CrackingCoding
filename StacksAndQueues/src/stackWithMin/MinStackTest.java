package stackWithMin;

public class MinStackTest {

	public static void main(String[] args) {
		StackWithMin stack = new StackWithMin();
		stack.push(5);
		stack.push(8);
		stack.push(7);
		stack.push(3);
		stack.push(2);
		
		System.out.println("Min: " + stack.min());
		stack.pop();
		System.out.println("Min: " + stack.min());
		stack.pop();
		System.out.println("Min: " + stack.min());
		stack.pop();
		System.out.println("Min: " + stack.min());
		
		System.out.println();
		
		StackWithMinNodes stackOfNodes = new StackWithMinNodes();
		stackOfNodes.push(5);
		stackOfNodes.push(8);
		stackOfNodes.push(7);
		stackOfNodes.push(3);
		stackOfNodes.push(2);
		
		System.out.println("Min: " + stackOfNodes.min());
		stackOfNodes.pop();
		System.out.println("Min: " + stackOfNodes.min());
		stackOfNodes.pop();
		System.out.println("Min: " + stackOfNodes.min());
		stackOfNodes.pop();
		System.out.println("Min: " + stackOfNodes.min());
	}

}
 