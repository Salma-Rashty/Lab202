package Lab202;

public class Lab9Sort {
	public static void main(String[] args) {
		
		int[] arr = {3,5,1,8,5,9,3,4};
        int[] arr1 = insertionSort(arr);
        int[] arr2 = selectionSort(arr);

        System.out.print("Insertion Sort: ");
        for (int num : arr1) {
            System.out.print(num + ", ");
        }
        System.out.println();

        System.out.print("Selection Sort: ");
        for (int num : arr2) {
            System.out.print(num + ", ");
        }
        
	}
	
	public static int[] insertionSort(int[] arr) {  // O(log n)
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(20);
		int[] arrSorted = new int[arr.length];
		int index = 0;
		for (int num : arr) {
			pq.enqueue(num);
		}
		while (!pq.isEmpty()) {
			arrSorted[index++] = pq.dequeue();
		}
    	return arrSorted;
	}
	public static int[] selectionSort(int[] arr) {  // O(log n)
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(20);
		int[] arrSorted = new int[arr.length];
		int index = arr.length - 1;
        for (int num : arr) {
            pq.enqueue(num);
        }
        while (!pq.isEmpty()) {
        	arrSorted[index--] = pq.dequeue();
        }
        return arrSorted;
	}
	
	
	static class PriorityQueue<t extends Comparable<t>>{
		t[] arr;
		int max;
		int count;
		
		@SuppressWarnings("unchecked")
		public PriorityQueue(int max) {
			this.max = max;
			this.arr = (t[])new Comparable[max];
			this.count = 0;
		}
		
		
		@SuppressWarnings("unchecked")
		public void clear(){
			this.arr = (t[])new Comparable[max];
			count = 0;
		}
		
		
		public t dequeue(){
			if(isEmpty()) {
				System.out.println("Queue is empty");
				return null ;
			}
			count--;
			return arr[count];
		}
		
		
		public void enqueue(t element) {
			int i = 0;
			if(!isFull()) {
				if(count==0) {
					arr[count] = element;
					count++;
				}
				else {
					for(i=count-1; i>=0; i--) { 
						if(element.compareTo(arr[i]) > 0) {
							arr[i+1]=arr[i];
						}
						else {
							break;
						}
					}
					arr[i+1] = element;
					count++;
				}
			}
			else {
				System.out.println("the queue is full");
			}
		}
		public boolean isEmpty(){
			if(count==0) {
				return true;
			}
			return false;
		}
		
		public t peek(){
			return arr[count-1];
		}
		
		public int size(){
			return count;
		}
		
		public boolean isFull() {
			if(count==max) {
				return true;
			}
			return false;
		}
		
	}
	
	
	
}
