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
		
		//***PERFORMANCE TEST CODE
		/*
		int testNum = 1000000;
		Integer[] big = new Integer[testNum];

		for (int i = 0; i < big.length - 1; i++) {
			big[i] = i;
		}
	
		
		big[big.length - 1] = 2;
		MaxHeap testHeap = new MaxHeap(big.length);
		long startTime = System.nanoTime();
		testHeap.MaxHeapLogN(big);
		long endTime = System.nanoTime();
	    long durationInMillis = TimeUnit.NANOSECONDS.toMillis(endTime - startTime);
	    System.out.println("O(nlogn) : " + durationInMillis);
		*/
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
		
		//***PERFORMANCE TEST CODE
		/*
		int testNum = 1000000;
		Integer[] big = new Integer[testNum];

		for (int i = 0; i < big.length - 1; i++) {
			big[i] = i;
		}
	
		big[big.length - 1] = 2;
		MaxHeap testHeap = new MaxHeap(big.length);
		long startTime = System.nanoTime();
		testHeap.MaxHeapN(big);
		long endTime = System.nanoTime();
	    long durationInMillis = TimeUnit.NANOSECONDS.toMillis(endTime - startTime);
	    System.out.println("O(n) : " + durationInMillis);	
	*/
	}
	
}