package Lab202;

public class Lab7Queue {
	public static void main(String[] args) {
		Queue<Integer> q = new Queue<Integer>();
		q.Enqueue(5);
		q.Enqueue(3);
		q.Enqueue(8);
		q.Enqueue(2);
		q.Enqueue(9);
		q.printQueue();
		q.Dequeue();
		q.printQueue();
		EmptyQueue2(q);
		q.printQueue();
		
		Queue<Product> ProductQueue = new Queue<Product>();
		
		ProductQueue.Enqueue(new Product("shortSleeve", "blue", 'S', 3.5));
		ProductQueue.Enqueue(new Product("shortPants", "pink", 'M', 8));
		ProductQueue.Enqueue(new Product("TShirt", "blue", 'L', 5.8));
		ProductQueue.Enqueue(new Product("jacket", "pink", 'S', 3));
		ProductQueue.Enqueue(new Product("shortPants", "blue", 'M', 7));
		ProductQueue.Enqueue(new Product("shortSleeve", "pink", 'L', 15));
		ProductQueue.Enqueue(new Product("TShirt", "blue", 'S', 9));
		ProductQueue.Enqueue(new Product("jacket", "pink", 'M', 8.4));
		ProductQueue.Enqueue(new Product("jacket", "blue", 'S', 11));
		ProductQueue.Enqueue(new Product("shortSleeve", "blue", 'L', 7));
		//ProductQueue.printQueue();
		Queue<Product> q1 = new Queue<Product>();
        Queue<Product> q2 = new Queue<Product>();
        Queue<Product> q3 = new Queue<Product>();
		
        QueueNode<Product> temp = ProductQueue.head;
        Product p = temp.getData();
        while(temp!=null) {
        	if (p.getColor()=="blue" && p.getSize()=='M') {
                q1.Enqueue(temp.getData());
            }
        	else if (p.getColor()=="pink" && p.getSize()=='S') {
                q2.Enqueue(temp.getData());
            }
        	else {
        		q3.Enqueue(temp.getData());
        	}
        	temp=temp.next;
		}
       // System.out.println("Total price of ProductQueue is "+calculatePrice(ProductQueue));
        System.out.println("Total price of q1 is "+calculatePrice(q1));
        System.out.println("Total price of q2 is "+calculatePrice(q2));
        System.out.println("Total price of q3 is "+calculatePrice(q3));
        
        
        
        
        
	}
	
	public static double calculatePrice(Queue<Product> q) {
        double totalPrice = 0.0;
        QueueNode<Product> temp = q.head;
        //Product p = q.head.getData();
        while(!q.isEmpty()) {
        	totalPrice += temp.getData().getPrice();
        }
        return totalPrice;
    }
	
	
	//3
	public static <item> void EmptyQueue1(Queue<item> q) {
		while(!q.isEmpty()) {
			q.Dequeue();
		}
		
	}
	
    public static <item> void EmptyQueue2(Queue<item> q) {
    	q.Dequeue();
		if(!q.isEmpty()) {
			EmptyQueue2(q);
		}
		
	}
	
	
	
	
	static class Queue<item>{
		QueueNode<item>  head;
		QueueNode<item> tail;
		//item taill = tail.data;
		//item headd = head.data; 
		int size = size();
		int capacity;
		
		public Queue() {
			head = null;
			tail =null;
			capacity = 20;
		}
		
		public void Enqueue(item data) {
			QueueNode<item> newNode = new QueueNode<item>(data);
			if(isEmpty()) {
				head = newNode;
				tail = newNode;
			}
			else if(isFull()) {
				System.out.println("the Queue is Full");
			}
			else {
				tail.next = newNode;
				tail = newNode;
			}
			
		}
		public item Dequeue() {
			item data = null ;
			if(isEmpty()) {
				System.out.println("The Queue is Empty!");
			}
			else {
				data = head.data;
				head = head.getNext();
			}
			if(head==null) {
				tail = null;
			}
			return data;
		}
		
		public boolean isEmpty() {
			if(head==null && tail==null) {
				return true;
			}
			return false;
		}
		public boolean isFull() {
			if(size==capacity+1) {
				return true;
			}
			return false;
		}
		public void makeEmpty() {
			head = null;
			tail = null;
			
		}
		public int size() {
			int count = 0;
			QueueNode<item> temp = head;
			
			while(temp!=null) {
				count++;
				temp=temp.next;
			}
			return count;
		}
		public void printQueue() {
			QueueNode<item> temp = head;
			if(isEmpty()) {
				System.out.println("the List is empty!");
			}
			else {
				System.out.println("the values of the Queue are: ");
				while(temp!=null) {
					System.out.print(temp.getData()+", ");
					temp=temp.next;
				}
			}
			System.out.println();
		}
	}

	
	
	static class QueueNode<item>{
		QueueNode<item> next;
		item data;
		
		public QueueNode(item data) {
			this.data = data;
			next = null;
		}
		public void setData(item data) {
			this.data = data;
		}
		public void setNext(QueueNode<item> next) {
			this.next = next;
		}
		public item getData() {
			return this.data;
		}
		public QueueNode<item> getNext() {
			return this.next;
		}
	}
	
	
	static class Product{
		String type;
		String color;
		char size;
		double price;
		
		public Product(String t, String c, char s, double p) {
			this.type = t;
			this.color = c;
			this.size = s;
			this.price = p;
		}
		public void setData(String t, String c, char s, double p) {
			this.type = t;
			this.color = c;
			this.size = s;
			this.price = p;
		}
		public String getType() {
			return this.type;
		}
		public String getColor() {
			return this.color;
		}
		public char getSize() {
			return this.size;
		}
		public double getPrice() {
			return this.price;
		}
		
		
		
	}
	
	
	
	
		
}

	
