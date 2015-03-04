/**
 * Question 3.1: Describe how you could use a single array to implement three stacks
 */
package array3stacks;

public class Array3Stacks {

	int stackSize = 100;
	int[] buffer = new int[stackSize * 3];
	int[] stackPointer = {-1, -1, -1};
	
	public void push (int value, int stackNumber) throws Exception {
		if (stackPointer[stackNumber] + 1 >= stackSize) {
			throw new Exception("Stack is full");
		}
		++stackPointer[stackNumber];
		int index = absTopIndexOfStack(stackNumber);
		buffer[index] = value;
	}
	
	public int top (int stackNumber) throws Exception {
		int index = absTopIndexOfStack(stackNumber);
		if (index == -1) {
			throw new Exception("Stack is empty");
		}
		
		return buffer[index];
	}
	
	public int pop (int stackNumber) throws Exception {
		int value = top(stackNumber);
		--stackPointer[stackNumber];
		return value;
	}
	
	int absTopIndexOfStack (int stackNumber) {
		return stackNumber * stackSize + stackPointer[stackNumber];
	}
	
	public boolean isEmpty (int stackNumber) {
		return stackPointer[stackNumber] == -1;
	}
	
	public void popAndPrintStack (int stackNumber) throws Exception {
		System.out.println("Popping stack " + stackNumber + " elements: ");
		while(!isEmpty(stackNumber)) {
			System.out.print(pop(stackNumber) + " ");
		}
		System.out.println();
	}
}
