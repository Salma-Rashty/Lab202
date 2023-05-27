package Lab202;

public class Palindromes {
	public static void main(String[]args) {
		
		System.out.println(isPalindrome("level"));
		
	}
	public static boolean isPalindrome(String s) {
		boolean a = true;
		int l = s.length();
		for(int i=0 ; i<l ; i++) {
			if (s.charAt(i)==s.charAt(l-i-1)) {
				a=true;
			}
			else {
				a=false;
				break;
			}
		}
		return a;
	}
}
