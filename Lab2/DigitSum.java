package Lab202;

public class DigitSum {
	public static void main(String[]args) {
		
		System.out.println(digitSum(1234));
	}
	
	public static int digitSum(int num) {
		if (num!=0) {
			return (num%10 + digitSum(num/10));
		}
		return 0;
	}

}
