package Lab202;

public class BalancingParentheses {
	public static void main(String[]args) {
		
		System.out.println(isBalanced("tg{ 0[]uf}v"));
		
	}
	
	public static boolean isBalanced(String s) {
		boolean b = false;
		StringBuilder str = new StringBuilder();
		String newS = "";
		for(int i=0 ; i<s.length() ; i++) {
			char n = s.charAt(i);
            if (n == '{' || n == '}' || n == '[' || n == ']' || n == '(' || n == ')') {
				str.append(n);
			}
		}
		System.out.println(str.toString());
		newS = str.toString();
		int len = newS.length();
		for(int j=0 ; j<len/2 ; j++) {
			String n1 = Character. toString(newS.charAt(j));
			String n2 = Character. toString(newS.charAt(len-j-1));
			if (n1.equals("{") && n2.equals("}")) {
				b=true;
			}
			else if (n1.equals("[") && n2.equals("]")) {
				b=true;
			}
			else if (n1.equals("(") && n2.equals(")")) {
				b=true;
			}
			else {
				b=false;
				break;
			}
		}
		return b;
	}
}
