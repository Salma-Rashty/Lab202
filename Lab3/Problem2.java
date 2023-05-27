package Lab202;

public class Problem2 {
	public static void main(String[] args) {
		int[] arr = {1, 4, 3, 7, 9, 11};
		System.out.println(rec(arr,0));
	}
	
	public static boolean rec(int[] arr,int size) {
		if(callback(arr[size])==true) {
			return true;  
		}
		else if (callback(arr[size])==false && size<arr.length-1) {  
			return rec(arr,size+1);  
		}
		
		return false;  
	}
	
	public static boolean callback(int num) {
		if(num%2==0) { 
			return true;
		}
		return false;
	}
	
}
