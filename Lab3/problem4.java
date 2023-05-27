package Lab202;

public class problem4 {
	public static void main(String[] args) {
		int[] arr = {4, 2, 3, 7, 1, 9};
		System.out.println(findSum(arr,0,0,1));
		
	}
	
	public static boolean findSum(int[] arr,int size,int x,int y) {
		int sum = arr[size];
		int num1 = arr[x];
		int num2 = arr[y];
		
		if(y==arr.length-1) {
			return findSum(arr,0,x+1,x+2);
		}
		if(x==arr.length-1) {
			return false;
		}
		if(size==arr.length-1 && num1+num2!=sum) {
			return findSum(arr,0,x+1,y+1);
		}
		if(sum==0 || sum==1 || size<=x ||size<=y) {
			return findSum(arr,size+1,x,y);
		}
		if(num1+num2==sum) {
			System.out.println(num1+"+"+num2+"="+sum);
			return true;
		}
		
		else {
			return findSum(arr,size+1,x,y+1);
		}
		
		
	}
}
