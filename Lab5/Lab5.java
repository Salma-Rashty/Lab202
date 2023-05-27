package Lab202;

import java.util.Scanner;
public class Lab5 {
	public static void main(String[] args) {
		
		//3
		Stack s = new Stack(10);
		System.out.println("is full: "+s.isFull());
		System.out.println("is empty: "+s.isEmpty());
		Scanner sc = new Scanner(System.in) ;
		System.out.print("enter a number: ");
		int num = sc.nextInt();
		while(num!=-1) {
			s.pushStack(num);
			System.out.print("enter a number: ");
			num = sc.nextInt();
		}
		s.printStack();
		System.out.println(s.popStack());
		s.printStack();
		System.out.println("is full: "+s.isFull());
		System.out.println("is empty: "+s.isEmpty());
		System.out.println("the peek is: "+s.peek());
		s.printStack();
		s.pushStack(6);
		s.printStack();
		
		
		
		//4
		Stack sv = new Stack(10);
		System.out.print("enter a number: ");
		int num2 = sc.nextInt();
		while(num2!=-1) {
			reverseStack(num2,sv);
			System.out.print("enter a number: ");
			num2 = sc.nextInt();
		}
		if (num2==-1) {
			reverseStack(num2,sv);
		}
		
		
		
		//5
		System.out.println();
		if (balanced("{()}()")){   
	       System.out.println("the parentheses are balanced.");   
		}
	    else {  
	       System.out.println("the parentheses not balanced.");   
	    }
		
		
		
		//6
		System.out.print("the postfix result: ");
		System.out.println(postfix("52+83-*4/"));
		
	}

	
	
	
	public static void reverseStack(int num, Stack sv) {
		if(num!=-1) {
			sv.pushStack(num);
		}
		else {
			
			System.out.print("the reversed stack is: ");
			for(int i=sv.top; i>=0 ; i--) {
				System.out.print(sv.arr[i] +", ");
				}
		}
	}
	
	
	
	public static boolean balanced(String str) {
        Stack sb = new Stack(str.length());
        char[] ar = str.toCharArray();
        char cpop;
        
        for (int i = 0; i < ar.length; i++) {
            char c = ar[i];
            if (c == '{' || c == '[' || c == '(') {
                sb.pushStack(c);   
                continue;
            }
            if (sb.isEmpty()) {    
                return false;   
            }
            if(c==')') {
            	cpop=(char) sb.popStack();
           		if(cpop == '{' || cpop == '[') {
           			return false;
           		}
	        }
	        else if(c=='}') {
	           	cpop=(char) sb.popStack();
	           	if(cpop == '(' || cpop == '[') {
            		return false;
	           	}
	        }
	        else if(c==']') {
	           	cpop=(char) sb.popStack();
	           	if(cpop == '(' || cpop == '{') {
	           		return false;
	           	}
	        }
        }
        return (sb.isEmpty());   
    }   
	
	
	
	
	public static int postfix(String str) {
		Stack sp = new Stack(str.length());
		
		for(int i=0; i<str.length() ; i++) {
			char c = str.charAt(i);
			if(c>='0' && c<='9') {
				sp.pushStack(c-'0'); //for converting to int
			}
			else {
				int n1 = sp.popStack();
				int n2 = sp.popStack();
				if(c=='+') {
					sp.pushStack(n2+n1);
				}
				else if(c=='-') {
					sp.pushStack(n2-n1);
					
				}
				else if(c=='*') {
					sp.pushStack(n2*n1);
					
				}
				else if(c=='/') {
					sp.pushStack(n2/n1);
					
				}
				else {
					System.out.println("Invalid character");
				}
			}
		}
		return sp.popStack();
	}
	
	
	
	
	
	//1
	static class Stack {
		int [] arr;
		int top;
		int size;
		
		public Stack(int size) {
			this.size=size;
			this.arr = new int[size];
			top = -1;
		}
		public void setSize(int size) {
			this.size = size;
		}
		public void setTop(int top) {
			this.top = top;
		}
		public int getSize() {
			return size;
		}
		public int getTop() {
			return top;
		}
		
		
		//2
		public boolean isFull() {
			if(top == size-1) {
				return true;
			}
			return false;
		}
		public boolean isEmpty() {
			if(top==-1) {
				return true;
			}
			return false;
		}
		public int peek() {
			
			if(isEmpty()) {
				return -1;
			}
			return arr[top];
		}
		public int popStack() {
			int n=0;
			if(isEmpty()) {
				System.out.println("the stack is empty!");
				return -1;
			}
			else {
				n = arr[top];
				top--;
			}
			return n;
		}
		public void pushStack(int n) {
			if(isFull()) {
				System.out.println("the stack is full");
			}
			else {
				top++;
				arr[top]=n;
			}
		}
		public void createStack(int size) {
			this.arr = new int[size];
			top = -1;
		}
		public void printStack() {
			if(isEmpty()) {
				System.out.println("The stack is empty!");
			}
			else {
				for(int i=top; i>=0 ; i--) {
				System.out.print(arr[i] +", ");
				}
				System.out.println();
			}
		}
		
	}

}
