package Lab202;
import java.util.Calendar;
import java.util.Arrays;

public class Lab1 {
	public static void main(String[] args) {
		
		//part5
		String a = "Angel";
		String b = "Angle";
		Boolean bb = true;
		
		a.toLowerCase();
		b.toLowerCase();
		
		if (a.length()!=b.length()) {
			System.out.println("the two Strings are not anagram!");
		}
		else {
			char[] ar1 = a.toCharArray();
			char[] ar2 = b.toCharArray();
			Arrays.sort(ar1);
			Arrays.sort(ar2);
			if(Arrays.equals(ar1, ar2)) {
				System.out.print("the two Strings are anagram!");	
			}
			else {
				System.out.println("the two Strings are not anagram!");
			}
		
		}
		System.out.println();
		
		//part6 
		Student s1 = new Student("salma Rashty","computer engineering",210201101 );
		System.out.println(s1.toString());
		
		
		//part 8
		int num = 1;
		int num2 = 1;
		double average = 0;
		for(int i=0; i<20; i++ ) {
			if (i%2==0) {
				System.out.print(num+",");
				average+=num;
				num = num+num2;
			}
			else {
				System.out.print(num2+",");
				average+=num2;
				num2 = num+num2;
			}
		}
		System.out.println("\n"+average/20);
		
		
		//part9
		System.out.println();
		Calendar c = Calendar.getInstance();
		System.out.println("Current Date and Time :");
		System.out.format("%tB %te, %tY%n", c, c, c);
		System.out.format("%tl:%tM %tp%n", c, c, c);
		
	}

}
