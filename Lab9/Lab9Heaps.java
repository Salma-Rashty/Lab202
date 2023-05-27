package Lab202;

public class Lab9Heaps {
	public static void main(String[] args) {
		
		int arr[] = {4, 6, 2, 9, 1, 7, 2, 5};
		int n = arr.length;
	        
		sort(arr);
		printArray(arr);
		
		
	}
	// big oh is  O(n log n)
	 public static void sort(int arr[]){
		 int size = arr.length;
		 for (int i=size/2-1; i>=0; i--) {
			 heapify(arr, size, i);
		 }
		 for (int i=size-1; i>= 0; i--) {
			 int temp = arr[0];
			 arr[0] = arr[i];
			 arr[i] = temp;
			 heapify(arr, i, 0);
		 }
	 }
	 
	 public static void heapify(int arr[], int n, int i){
		 int l = i;
		 int left = 2*i+1;
		 int right = 2*i+2;
	 
		 if (left<n && arr[left]>arr[l]) {
			 l = left;
		 }
		 if (right<n && arr[right]>arr[l]) {
			 l = right;
		 }
		 if (l != i) {
			 int temp = arr[i];
			 arr[i] = arr[l];
			 arr[l] = temp;
			 heapify(arr, n, l);
		 }
	 }
	 
	   
	 public static void printArray(int arr[]){
		 for (int i = 0; i<arr.length; ++i) {
			 System.out.print(arr[i] + ", ");
		 	}
		 System.out.println();
	 }
	

}
