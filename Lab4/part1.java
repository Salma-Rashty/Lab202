package Lab202;

import java.util.List;
import java.util.Scanner;
public class part1 {
	public static void main(String[] args) {
		
		//I
		Scanner sc = new Scanner(System.in);
		System.out.print("enter a number or -1 to stop: ");
		int item = sc.nextInt();
		
		
		while(item!=-1) {
			
			DynamicBuild(item);
			System.out.print("enter a number or -1 to stop: ");
			item = sc.nextInt();
			
		}
		System.out.println();
		printList();
		

		//II
		System.out.println();
		InsertList(head , 4 , 25);
		printList();
		
		//III
		System.out.println();
		DeleteList(6);
		printList();
		
		//IV
		System.out.println();
		System.out.println("the element at the given position is: "+GetElementAtPosition(3));
		
		
		//V
		System.out.println();
		//sortList();
		SortedInsert(5);
		printList();
		
		//VI
		FrontBackSplit();	
		
		
		
	}
	
	public static void DynamicBuild(int data) {
		Node newNode = new Node(data);
		if(head == null) {
			head = newNode;
			tail = newNode;
		}
		else {
			tail.next = newNode;
			tail = newNode;
		}	
	}
	
	public static void InsertList(Node head, int position, int data) {
		Node newNode = new Node(data);
		Node temp = head;
		if(position<=0 || position>nodeSize()+1) {
			System.out.println("the Position is invalid!");
		}
		else if(isEmpty()) {
			head = newNode;
		}
		else if(position==1) {
            newNode.next = head;
            head = newNode;
		}
		else {
			for(int i=1; i<=position-1; i++) {
				temp=temp.next;
			}
			newNode.next = temp.next;
			temp.next = newNode;	
		}
	}
	
	public static void DeleteList(int value) {
		Node temp = head;
		Node prev = head;
		if(isEmpty()) {
			System.out.println("the List is empty!");
		}
		else {
			while(temp!=null) {
				if(temp.getData()==value) {
					while(prev.next!=temp) {
						prev=prev.next;
					}
					prev.next=temp.next;
					temp = temp.next;
					
					break;
				}
				else {
					temp = temp.next;
				}
			}
		}	
	}
	
	public static int GetElementAtPosition(int position) {
		Node temp = head;
		if(position<=0 || position>nodeSize()+1) {
			System.out.println("the Position is invalid!");
		}
		else if(isEmpty()) {
			System.out.println("the list is Empty!");
		}
		else if(position==1) {
            return head.getData();
		}
		else {
			for(int i=1; i<=position-1; i++) {
				temp=temp.next;
			}
			return temp.getData();
			
		}
		
		return 0;
	}
	
	public static void SortedInsert(int data) {
		Node newNode = new Node(data);
		Node temp = head;
		Node prev = head;
		if(isEmpty()) {
			System.out.println("the List is empty!");
		}
		else {
			while(temp!=null) {
				if(temp.getData()>data) {
					while(prev.next!=temp) {
						prev=prev.next;
					}
					prev.next=newNode;
					newNode.next = temp.next;
					
					break;
				}
				else {
					temp = temp.next;
				}
			}
		}	
	}
	
	public static void FrontBackSplit() {
		
		
	}
	
	
	public static boolean isEmpty() {
		return head==null;
	}
	
	public static void printList() {
		Node temp = head;
		if(isEmpty()) {
			System.out.println("the List is empty!");
		}
		else {
			System.out.println("the values of the list are: ");
			while(temp!=null) {
				System.out.print(temp.getData()+", ");
				temp=temp.next;
			}
		}
		System.out.println();
	}
	
	public static int nodeSize() {
		int count = 0;
		Node temp = head;
		
		while(temp!=null) {
			count++;
			temp=temp.next;
		}
		return count;
	}
	
	
	public static void sortList() {
		Node temp = head.next;
		Node prev = head;
		int c = 0;
		
		if (isEmpty()) {
			System.out.println("the list is empty!");
		}
		else {
			while(temp!=null) {
				while(prev!=null) {
					if(prev.next!=temp) {
						prev=prev.next;
						
						if(temp.getData()<prev.getData()) {
							c=prev.getData();
							prev=temp;
							temp.data=c;
						}
						
					}
					else {
						prev=head;
						if(temp.getData()<prev.getData()) {
							c=prev.getData();
							prev=temp;
							temp.data=c;
						}
					}
					
				}
				temp=temp.next;
			}
		}	
	}
	
	
	
	
	
	static Node head = null;
	static Node tail = null;
	
	 static class Node {
		int data;
		Node next;
		

		public Node(int data) {
			this.data = data;
			this.next = null;
		}
		public void setData(int data) {
			this.data = data;
		}
		public void setNext(Node next) {
			
			this.next = next;
		}
		
		public int getData() {
			return data;
		}
		public Node getNext() {
			return next;
		}
	}
	
}
