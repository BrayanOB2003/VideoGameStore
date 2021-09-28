package structures;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StackTest {
	
	private Stack<Integer> stackTest;
	
	public void setupScenary1() {
		
		stackTest = new Stack<>();
	}
		
	public void setupScenary2() {
		
		stackTest = new Stack<>();
		
		stackTest.add(1);
		stackTest.add(2);
		stackTest.add(3);
		stackTest.add(4);
	}

	@Test
	public void pushTest() {
		
		setupScenary2();
		stackTest.add(4);
		
		assertTrue(stackTest.getSize()==5);
		assertTrue(stackTest.toString().equals("4 4 3 2 1"));
	}
	
	@Test
	public void popTest() {
		setupScenary2();
		
		stackTest.pop();
		
		assertTrue(stackTest.toString().equals("3 2 1"));
		
		
	}
	
	@Test 
	public void sizeTest() {
		
		setupScenary2();
		
		assertTrue(stackTest.getSize()==4);
	}
	
	@Test
	public void pushTest2() {
		
		setupScenary1();
		
		stackTest.add(4);
		
		assertTrue(stackTest.getSize()==1);
		assertTrue(stackTest.peek()==4);
	}

}
