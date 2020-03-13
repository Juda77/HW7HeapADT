import java.util.Arrays;
public class MaxHeap implements Heap {
    int size;

    Integer[] data;

    public MaxHeap(int capacity) {
        data = new Integer[capacity];
        size = 0;
    }
    
    public boolean equals(Integer[] other) {
    	return Arrays.equals(this.data, other); //placeholder
    }
    
    
    public static void main(String[] args) {
    	
    	System.out.println((0 - 1)/ 2);
    	
    }
    
    
    
    public void heapifyUp() {
    	
    	int parent = 0;
    	
    	do {
    		
    		
    		
    		
    	} while (parent  > 2);
    	
    }
    

    // build a heap based on data
    // to be implemented in O(nlogn)
    public void MaxHeapLogN(Integer[] data) {
    	
        // homework
    	for (int i = 0; i < data.length; i++) {
    		
    		
    		
    		
    	}
    	
    	
    	
    	
    	
    	
    }

    // build a heap based on data
    // to be implemented in O(n)
    public void MaxHeapN(Integer[] data) {
        // homework
    	
    	
    	
    	
    }

    // add an item to the heap
    public boolean add(Integer item) {
        // homework
    	
    	
    	
    	
        return false;
    }

    // return the max item in the heap
    public Integer get() {
        // homework
    	if (size == 0) {
    		return null;
    	} else {
    		return data[0];
    	}
    }

    // remove the root item
    public Integer pop() {
        // homework
        return null;
    }
}
