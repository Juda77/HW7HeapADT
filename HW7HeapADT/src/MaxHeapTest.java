import static org.junit.Assert.*;

import org.junit.Test;

public class MaxHeapTest {
	Integer[][] testArrays = {
			
			{}, //empty
			{60, 30, 15, 2, 7}, //already heapified, shouldn't change
			
			//not in heap form
			{10, 1, 6, 7, 5, 8},
			{1, 0, 5, 9, 4},
			{2, 5, 8, 10},
			
			{1, 1, 1, 1, 2}, //top-priority in last
			{1, 1, 2, 1, 1}, //top-priority in middle
			{1, 1, 1, 1,}, //all same element
			{1} //single element
	};
	
	Integer[][] expected = {
			
			{},
			{60, 30, 15, 2, 7},
			{10, 7, 8, 5, 1, 6},
			{9, 4, 5, 1, 0},
			{10, 5, 8, 2},
			
			{2, 1, 1, 1, 1},
			{2, 1, 1, 1, 1},
			{1, 1, 1, 1},
			{1}
			
			
	};
	

	
    // homework
	@Test
	public void testNLogN() {
		
		for (int i = 0; i < testArrays.length; i++) {		
			MaxHeap testHeap = new MaxHeap(10);
			testHeap.MaxHeapLogN(testArrays[i]);
			assertTrue(testHeap.equals(expected[i]));
		}
		
	}
	
	
	
	
	
}