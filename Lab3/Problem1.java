package Lab202;

public class Problem1 {
	public static void main(String[] args) {
		int[] arr = new int[101];
		for(int i=0 ; i<=100 ; i++) {
			arr[i]=i;
		}
		System.out.println(linearSearch(arr ,54, 0));
		
	}
	
	public static int linearSearch(int[] arr, int target, int size) {
		if(size>arr.length-1) { 
			return -1;  
		}
		else if(target==arr[size]) { 
			return size;  
		}
		else {
			return linearSearch(arr,target,size+1); 
		}

	}
	
}
