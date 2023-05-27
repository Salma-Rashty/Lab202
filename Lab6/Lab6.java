package Lab202;

import java.util.HashMap;
import java.util.Map;

public class Lab6 {
	public static void main(String[] args) {
		//1
		Stack R = new Stack(20);
		R.push(1);
		R.push(2);
		R.push(3);
		Stack S = new Stack(20);
		S.push(4);
		S.push(5);
		Stack T = new Stack(20);
		T.push(6);
		T.push(7);
		T.push(8);
		T.push(9);
		
		organize(R,S,T);
		System.out.print("Stack R = ");
		R.printStack();
		System.out.print("Stack S = ");
		S.printStack();
		System.out.print("Stack T = ");
		T.printStack();
		System.out.println();
		
		
		//2
		permutation(3);
		System.out.println();
		
		
		//4
		String s = "leet**cod*e";
		StringBuilder sb = new StringBuilder(s);
		int starCount = 0;
		for(int i=s.length()-1; i>=0; i--) {
			if(s.charAt(i)=='*') {
				starCount++;
				sb.deleteCharAt(i);
			}
			if(s.charAt(i)!='*' && starCount>0) {
				sb.deleteCharAt(i);
				starCount--;
			}
			else {
				continue;
			}
		}
		s=sb.toString();
		System.out.println(s);
		
		
		
		
	}
	//1
	public static void organize(Stack R, Stack S, Stack T) {
		int Rlen = R.top;
		while(!S.isEmpty()) {
			R.push(S.pop());
		}
		while(!T.isEmpty()) {
			R.push(T.pop());
		}
		while(R.top!=Rlen) {
			S.push(R.pop());
		}
	}
	
	//2
	public static void permutation(int num) {
		Stack s = new Stack(num);
		Stack sx = new Stack(num);
		Stack a = new Stack(num);
		int f = 1;
		
		for (int i=1; i<=num; i++) {
			s.push(i);
			sx.push(i);
		}
		for(int j=1 ; j<=num; j++) {
			f=f*j;
		}
		while(f!=0) {
			while(!sx.isEmpty()) {
				int x=sx.peek();
				sx.pop();
				System.out.print("{"+x);
				
				while(!s.isEmpty()) {
					int y = s.peek();
					a.push(s.pop());
					if(y==x) {
						continue;
					}
					else {
						System.out.print(","+y);
					}
				}
				System.out.print("} ");
				while(!a.isEmpty()) {
					s.push(a.pop());
					}
			}
		}
	}
	
	
	
	static class Stack{
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
		
		
		public int pop() {
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
		
		
		public void push(int n) {
			if(isFull()) {
				System.out.println("the stack is full");
			}
			else {
				top++;
				arr[top]=n;
			}
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
