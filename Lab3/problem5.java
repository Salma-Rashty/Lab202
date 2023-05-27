package Lab202;
import java.util.Scanner;
public class problem5 {
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6};
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter sum: ");
		int sum = sc.nextInt();
		System.out.println(findPaires(sum,arr,0,1));
	}

	private static boolean findPaires(int sum, int[] arr, int x, int y) {
		int num1 = arr[x];
		int num2 = arr[y];
		
		if(y==arr.length-1 && x!=arr.length-2) {
			return findPaires(sum,arr,x+1,x+2);
		}
		if(x==arr.length-2 && num1+num2!=sum) {
			return false;
		}
		
		if(num1+num2==sum) {
			System.out.println(num1+"+"+num2+"="+sum);
			return true;
		}
		else {
			return findPaires(sum,arr,x,y+1);
		}
		
	}

}
