package structures;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


class HashtableTest {
	
	private HashTableLinkedList<Integer, Integer> hashTest;
	
	public void setupScenary1() {
		hashTest = new HashTableLinkedList<Integer, Integer>();
	}
	
	public void setupScenary2() {
		hashTest = new HashTableLinkedList<Integer, Integer>();
		hashTest.add(1, 5);
		
	}

	@Test
	public void insertTest() {
		
		setupScenary1();
		hashTest.add(1, 5);
		
		assertTrue(hashTest.search(1)==5);
		
	}
	
	@Test
	public void removeTest() {
		setupScenary1();
		
		hashTest.remove(1);
		
		assertTrue(hashTest.size()==0);
	}
	
	@Test
	
	public void containsTest() {
		setupScenary2();
		
		assertTrue(hashTest.contains(1));
	}
	
	@Test
	public void modifyTest() {
		
		setupScenary2();
		
		
		hashTest.modify(1, 3);
		
		assertTrue(hashTest.search(1)==3);
		
	}
	
	@Test
	public void searchTest() {
		setupScenary2();
		
		assertTrue(hashTest.search(1)==5);
	}
	
	
	

}
