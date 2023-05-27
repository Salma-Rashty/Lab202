package Lab202;

public class part3 {
	public static void main(String[] args) {
		part3 l = new part3();
		l.add(6);
		l.add(7);
		l.add(2);
		l.add(3);
		l.add(9);
		
		part3 m = new part3();
		m.add(7);
		m.add(2);
		m.add(3);
		m.add(9);
		m.add(6);
		
		//IX
		System.out.println(checkSequence(l,m));
		
		//X
	}
	
	public static boolean checkSequence(part3 l, part3 m) {
		if(l.isEmpty() && m.isEmpty()) {
			return true;
		}
		if(l.isEmpty() || m.isEmpty()) {
			return false;
		}
		Node templ = l.head;
		Node tempm = m.head;
		
		do {
			
			if (templ.data != tempm.data) {
	            return false;
	        }

	        templ = templ.next;
	        tempm = tempm.next;

	        if (templ == l.head) {
	        	templ = templ.next; 
	        }

	        if (tempm == m.head) {
	        	tempm = tempm.next; 
	        }
		 
		        } 
		while (templ != l.head || tempm != m.head);

		return true;
	}
	
	
	
	public void add(int data) {
		Node newNode = new Node(data);
		if(isEmpty()) {
			head = newNode;
			tail = newNode;
			newNode.next = head;
		}
		else {
			tail.next = newNode;
			tail = newNode;
			tail.next = head;
		}
		
	}
	
	public static boolean isEmpty() {
		return head==null;
	}
	
	
	public static int nodeSize() {
		int count = 0;
		Node temp = head;
		count++;
		temp=temp.next;
		
		while(temp!=head) {
			count++;
			temp=temp.next;
		}
		return count;
	}
	
	public static void printList() {
		Node temp = head;
		if(isEmpty()) {
			System.out.println("the List is empty!");
		}
		else {
			System.out.println("the values of the list are: ");
			System.out.print(temp.getData()+", ");
			temp=temp.next;
			while(temp!=head) {
				System.out.print(temp.getData()+", ");
				temp=temp.next;
			}
		}
		System.out.println();
	}
	
	
	
	
	static Node head = null;
	static Node tail = null;
	
	   class Node{
		  int data;
		  Node next;
		  
		  public Node(int data) {
			  this.data = data;
			  next = null;
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
