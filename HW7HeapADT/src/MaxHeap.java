import java.util.Arrays;
public class MaxHeap implements Heap {
    int size;

    Integer[] data;

    public MaxHeap(int capacity) {
        data = new Integer[capacity];
        size = 0;
    }
    
    public boolean equals(Integer[] other) {
    	System.out.println(Arrays.toString(this.data) + "\n" + Arrays.toString(other));
    	return Arrays.equals(this.data, other); //placeholder
    }
    
    
    public static void main(String[] args) {
    	
    	System.out.println((0 - 1)/ 2);
    	
    }
    
    public void swap(int parentIndex, int childIndex) {
    	int temp = data[parentIndex];
    	data[parentIndex] = data[childIndex];
    	data[childIndex] = temp;
    	//System.out.println(Arrays.toString(data));
    }
    
    
    public void heapifyUp(int n) {
    	int parentIndex = (n - 1) / 2;
    	int parent = data[parentIndex];
    	int child = data[n];
    	
    	if (n > 0 && parent < child) {
    		//swap
    		swap(parentIndex, n);
    		
    		//heapifyDown(n);
    		//recurse
    		heapifyUp(parentIndex);
    		

    	}
    	
    }
    
    public void heapifyDown(int n) {
    	
    	int leftChildIndex = n * 2 + 1;
    	int rightChildIndex = n * 2 + 2;
    	int parent = data[n];
    	
    	System.out.println(leftChildIndex + " " + rightChildIndex + " " + size);
    	
    	if (leftChildIndex > size && (rightChildIndex < size && data[rightChildIndex] > parent)) {
    		swap(n, rightChildIndex);
    		heapifyDown(rightChildIndex);
    	} else if (rightChildIndex > size && (leftChildIndex < size && data[leftChildIndex] > parent)) {
    		swap(n, leftChildIndex);
    		heapifyDown(leftChildIndex);
    	} else if ((rightChildIndex < size && leftChildIndex < size) && data[leftChildIndex] > data[rightChildIndex]) {
    		swap(n, leftChildIndex);
    		heapifyDown(leftChildIndex);	
    	} else if ((rightChildIndex < size && leftChildIndex < size) && data[rightChildIndex] > data[leftChildIndex]) {
    		swap(n, rightChildIndex);
    		heapifyDown(rightChildIndex);
    	}	
    	
    }
    

    // build a heap based on data
    // to be implemented in O(nlogn)
    public void MaxHeapLogN(Integer[] data) {
    	
        // homework
    	for (int i = 0; i < data.length; i++) { 		
    		//System.out.println(Arrays.toString(data));
    		add(data[i]);	
    	}
 	
    }
    
    // add an item to the heap
    public boolean add(Integer item) {
        // homework
    	if (size == data.length) {
    		return false;
    	}
    	
    	data[size] = item;
    	heapifyUp(size);
    	size++;
    	
        return true;
    }

    // build a heap based on data
    // to be implemented in O(n)
    public void MaxHeapN(Integer[] data) {
        // homework
    	
    	
    	
    	
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
