package Lab202;

import Lab202.part1.Node;

public class part2 {
	public static void main(String[] args) {
		
		addNode(2);
		addNode(4);
		addNode(6);
		addNode(3);
		addNode(8);
		printList();
		
		
		//VII
		printReverse();
		printList();
		
		//VIII
		System.out.println(checkPalindrome());
		
	}
	
	public static void printReverse() {
        Node temp = head;
        Node pre = null;
        
        while (temp != null) {
            pre = temp.prev;
            temp.prev = temp.next;
            temp.next = pre;
            temp = temp.prev;
        }
        if (pre != null) {
            head = pre.prev;
        }
	}
	
	public static boolean checkPalindrome() {
		Node start = head;
		Node end = start;
		if (start == null) {
		    return true;
		}
		
		while (end.next != null) {
		        end = end.next;
		 
		    while (start != end) {
		    
		        if (start.data != end.data)
		            return false;
		 
		        start = start.next;
		        end = end.prev;
		    }
		 
		    return true;
		}
		return false;
	}
	
	
	public static void addNode(int data) {
		Node newNode = new Node(data);
		if(isEmpty()) {
			head = newNode;
			tail = newNode;
		}
		else {
			tail.next = newNode;
			newNode.prev = tail;
			tail = newNode;
		}
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
	
	
	
	static Node head = null;
	static Node tail = null;
	
	 static class Node {
		int data;
		Node prev;
		Node next;
		

		public Node(int data) {
			this.data = data;
			this.next = null;
			this.prev = null;
		}
		public void setData(int data) {
			this.data = data;
		}
		public void setNext(Node next) {	
			this.next = next;
		}
		public void setPrev(Node prev) {	
			this.prev = prev;
		}
		public int getData() {
			return data;
		}
		public Node getNext() {
			return next;
		}
		public Node getPrev() {
			return prev;
		}
	}
	
	
}
