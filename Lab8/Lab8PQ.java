package Lab202;


public class Lab8PQ {
	public static void main(String[] args) {
		ArrayPriorityQueue<Integer> pq = new ArrayPriorityQueue<Integer>(100);
		pq.enqueue(4);
		pq.enqueue(2);
		pq.enqueue(8);
		pq.enqueue(1);
		pq.enqueue(5);
		System.out.print(pq.dequeue()+" ");
		System.out.print(pq.dequeue()+" ");
		System.out.print(pq.dequeue()+" ");
		System.out.print(pq.dequeue()+" ");
		System.out.print(pq.dequeue()+" ");
		System.out.println(pq.dequeue()+" ");
		pq.enqueue(8);
		pq.enqueue(1);
		pq.enqueue(5);
		pq.clear();
		System.out.print(pq.dequeue()+" ");
		
		
	}
	
	static class ArrayPriorityQueue<t extends Comparable<t>>{
		t[] arr;
		int max;
		int count;
		
		@SuppressWarnings("unchecked")
		public ArrayPriorityQueue(int max) {
			this.max = max;
			this.arr = (t[])new Comparable[max];
			this.count = 0;
		}
		
		//big oh of the clear method is O(1)
		@SuppressWarnings("unchecked")
		public void clear(){
			this.arr = (t[])new Comparable[max];
			count = 0;
		}
		
		//big oh of the dequeue method is O(1)
		public t dequeue(){
			if(isEmpty()) {
				System.out.println("Queue is empty");
				return null ;
			}
			count--;
			return arr[count];
		}
		
		//big oh of the enqueue method is O(n)
		public void enqueue(t element) {
			int i = 0;
			if(!isFull()) {
				if(count==0) {
					arr[count] = element;
					count++;
				}
				else {
					for(i=count-1; i>=0; i--) {  //o(n)
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
		
		//big oh of the peek method is O(1)
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
