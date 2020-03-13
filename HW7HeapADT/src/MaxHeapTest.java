import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

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
	
    // homework
	@Test
	public void testNLogN() {
		
		Integer[][] expected = {
				
				{},
				{60, 30, 15, 2, 7},
				{10, 7, 8, 1, 5, 6},
				{9, 5, 1, 0, 4},
				{10, 8, 5, 2},
				
				{2, 1, 1, 1, 1},
				{2, 1, 1, 1, 1},
				{1, 1, 1, 1},
				{1}
				
				
		};
		
		for (int i = 0; i < testArrays.length; i++) {		
			MaxHeap testHeap = new MaxHeap(testArrays[i].length);
			testHeap.MaxHeapLogN(testArrays[i]);
			
			assertTrue(testHeap.equals(expected[i]));
		}
		
		
	}	
	
	 // homework
	@Test
	public void testN() {
		Integer[][] expected = {
					
				{},
				{60, 30, 15, 2, 7},
				{10, 7, 8, 1, 5, 6},
				
				{9, 4, 5, 0, 1},
				{10, 5, 8, 2},
					
				{2, 1, 1, 1, 1},
				{2, 1, 1, 1, 1},
				{1, 1, 1, 1},
				{1}

		};
		
		for (int i = 0; i < testArrays.length; i++) {		
			MaxHeap testHeap = new MaxHeap(testArrays[i].length);
			testHeap.MaxHeapN(testArrays[i]);
			assertTrue(testHeap.equals(expected[i]));
		}
		
		
	
	}
	
	@Test
	public void testPopAndGet() {
		//Obtain our test heaps by calling our O(n) method
		MaxHeap[] testHeaps = new MaxHeap[testArrays.length];
		for (int i = 0; i < testHeaps.length; i++) {		
			MaxHeap testHeap = new MaxHeap(testArrays[i].length);
			testHeap.MaxHeapN(testArrays[i]);
			testHeaps[i] = testHeap;	
		}
		
		Integer[][] expected = {
				
				{},
				{30, 7, 15, 2, null},
				{8, 7, 6, 1, 5, null},
				{5, 4, 1, 0, null},
				{8, 5, 2, null},
				{1, 1, 1, 1, null},
				{1, 1, 1, 1, null},
				{1, 1, 1, null},
				{null}
				
		};
		
		Integer[] expectedTopPriorities = {null, 60, 10, 9, 10, 2, 2, 1, 1};
		
		/*
		 * {},
			{60, 30, 15, 2, 7},/
			{10, 7, 8, 1, 5, 6},/
			{9, 4, 5, 0, 1},/
			{10, 5, 8, 2}, /
					
			{2, 1, 1, 1, 1},
			{2, 1, 1, 1, 1},
			{1, 1, 1, 1},
			{1}
		 
		*/
		for (int i = 0; i < testHeaps.length; i++) {
			
			Integer topPriorityFromGet = testHeaps[i].get();
			assertEquals(topPriorityFromGet, expectedTopPriorities[i]);
			
			Integer topPriorityFromPop = testHeaps[i].pop();

			assertEquals(topPriorityFromPop, expectedTopPriorities[i]); //test to make sure we got the right top priorities
			assertTrue(testHeaps[i].equals(expected[i])); //test to make sure the heaps after pop() are the right elements
			
		}

	}
	
	@Test
	public void testAdd() {
		
		//test add() by using heaps constructed using logn method
		//make sure to test for what happens if the capacity of heap is already full
		
		MaxHeap[] testHeaps = new MaxHeap[7]; // + 1 to make space for the case where we can't add anymore
		
		for (int i = 0; i < 6; i++) {
			
			MaxHeap testHeap = new MaxHeap(10); //make capacity 10 so we actually have space to add more elements
			testHeap.MaxHeapN(testArrays[i]);
			testHeaps[i] = testHeap;
			
		}
		
		//give the final testHeap length 0 to test the can't add case
		MaxHeap testHeap = new MaxHeap(0);
		testHeaps[6] = testHeap;
		
		Integer[] valuesToAdd = {3, 6, 9}; //add each of these values to all test heaps and make sure that test heaps afterwards are correct
		boolean[] returnVals = new boolean[7]; //also keep track of the return vals to make sure they are also correct
		
		for (int i = 0; i < testHeaps.length; i++) {	

			for (int j = 0; j < valuesToAdd.length; j++) {
				returnVals[i] = testHeaps[i].add(valuesToAdd[j]);	
			}	
			
		}
		
		Integer[][] expected = {
				{9, 3, 6, null, null, null, null, null, null, null},
				{60, 30, 15, 9, 7, 3, 6, 2, null, null},
				{10, 9, 8, 7, 5, 6, 3, 1, 6, null},
				{9, 9, 6, 4, 1, 3, 5, 0, null, null},
				{10, 5, 9, 2, 3, 6, 8, null, null, null},
				{9, 6, 3, 1, 1, 1, 2, 1, null, null},
				{}
		};
		
		for (int i = 0; i < testHeaps.length; i++) {
			//test if final heaps match expected
			assertTrue(testHeaps[i].equals(expected[i]));
			
			//also make sure that return values are correct
			if (i == testHeaps.length - 1) {
				assertEquals(returnVals[i], false);
			} else {
				assertEquals(returnVals[i], true);
			}
			
			
		}

	}
	
}