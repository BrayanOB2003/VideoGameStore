package structures;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class QueueTest{
	
	private Queue<Integer> queueTest;
	
	public void setupScenary1() {
		
		queueTest = new Queue<>();
		
		queueTest.add(1);
		queueTest.add(2);
		queueTest.add(3);
		queueTest.add(4);
		
	}
	
	public void setupScenary2() {
		queueTest = new Queue<>();
	}

	@Test
	public void pushTest() {
		setupScenary1();
		queueTest.add(2);
		
		assertTrue(queueTest.getSize()==5);
		
		assertTrue(queueTest.toString().equals("1 2 3 4 2"));
		
	}
	
	@Test
	public void popTest() {
		setupScenary1();
		
		queueTest.pop();
		
		assertTrue(queueTest.getSize()==3);
		System.out.println(queueTest.toString());
		assertTrue(queueTest.toString().equals("2 3 4"));
		
	}
	
	@Test
	public void sizeTest() {
		setupScenary1();
		
		assertTrue(queueTest.getSize()==4);
	}

	@Test
	public void pushTest2() {
		setupScenary2();
		
		queueTest.add(4);
		
		assertTrue(queueTest.getSize()==1);
		
	}
}
