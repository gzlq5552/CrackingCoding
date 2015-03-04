package array3stacks;


public class Test3Stacks {

	static int numOfStacks = 3;
	static int defaultSize = 4;
	static int totalSize = defaultSize * numOfStacks;
	static StackData[] stacks = {new StackData(0, defaultSize),
								 new StackData(defaultSize, defaultSize),
								 new StackData(defaultSize * 2, defaultSize)};
	
	static int[] buffer = new int[totalSize];
	
	public static void main(String[] args) throws Exception {
		System.out.println("=====Testing fixed division stacks====");
		Array3Stacks stack = new Array3Stacks();
		stack.push(5, 0);
		stack.push(-3, 1);
		stack.push(10000, 2);
		stack.push(50, 2);
		stack.push(-6, 0);
		System.out.println("Top element of stack 2 now is: " + stack.top(2));
		System.out.println("Top element of stack 1 now is: " + stack.top(1));
		System.out.println("Top element of stack 0 now is: " + stack.top(0));
		
		stack.popAndPrintStack(0);
		stack.popAndPrintStack(1);
		stack.popAndPrintStack(2);	
		
		System.out.println("=====Testing flexible division stacks=====");
		
		push(0, 50);
		push(2, 60);
		push(1, -3);
		
		System.out.println("Number is: " + pop(2));
		
	}
	
	public static int numberOfElements () {
		return stacks[0].size + stacks[1].size + stacks[2].size;
	}
	
	public static int nextElement (int index) {
		if (index + 1 == totalSize) return 0;
		else return index + 1;
	}
	
	public static int previousElement (int index) {
		if (index == 0) return totalSize - 1;
		else return index - 1;
	}
	
	public static void shift (int stackNum) {
		StackData stack = stacks[stackNum];
		if (stack.size >= stack.capacity) {
			int nextStack = (stackNum + 1) % numOfStacks;
			shift(nextStack); // make some room
			++stack.capacity;
		}
		
		// shift elements in reverse order
		for (int i = (stack.start + stack.capacity - 1) % totalSize;
				stack.isWithinStack(i, totalSize);
				i = previousElement(i)) {
			buffer[i] = buffer[previousElement(i)];
		}
		
		buffer[stack.start] = 0;
		stack.start = nextElement(stack.start); // move stack start
		stack.pointer = nextElement(stack.pointer); // move pointer
		--stack.capacity; // return capacity to original
	}
	
	// Expand stack by shifting over other stacks
	public static void expand (int stackNum) {
		shift((stackNum + 1) % numOfStacks);
		++stacks[stackNum].capacity;
	}
	
	public static void push (int stackNum, int value) throws Exception {
		StackData stack = stacks[stackNum];
		// check that we have space
		if (stack.size >= stack.capacity) {
			if (numberOfElements() >= totalSize) {
				throw new Exception("Stack is full");
			} else {
				// shift things around
				expand(stackNum);
			}
		}
		// find index of top element in array + 1 and increment sp
		++stack.size;
		stack.pointer = nextElement(stack.pointer);
		buffer[stack.pointer] = value;
	}

	public static int pop (int stackNum) throws Exception {
		StackData stack = stacks[stackNum];
		if (stack.size == 0) {
			throw new Exception("Trying to pop an empty stack");
		}
		int value = buffer[stack.pointer];
		buffer[stack.pointer] = 0;
		stack.pointer = previousElement(stack.pointer);
		--stack.size;
		return value;
	}
	
	public static int peek (int stackNum) {
		StackData stack = stacks[stackNum];
		return buffer[stack.pointer];
	}
	
	public static boolean isEmpty (int stackNum) {
		StackData stack = stacks[stackNum];
		return stack.size == 0;
	}

}
