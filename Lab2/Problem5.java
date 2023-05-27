package Lab202;

public class Problem5 {
	public static void main(String[]args) {
		
		System.out.println(vowelsCheck("iobtufa",0,0));
	}
	
public static boolean vowelsCheck(String s,int vcount,int count) {
		
		if (count==s.length()) {
			System.out.println(vcount);
			if(vcount*2>s.length()-1) {
				return true;
			}
			else if(vcount*2<=s.length()-1) {
				return false;
			}	
		}
		else if(s.charAt(0+count)=='a' || s.charAt(0+count)=='e' || s.charAt(0+count)=='u' || s.charAt(0+count)=='o' || s.charAt(0+count)=='i') {
			vcount++;
			count++;
			return vowelsCheck(s,vcount,count);
		}
		else {
			count++;
			return vowelsCheck(s,vcount,count);
		}
		return false;
	}
}
