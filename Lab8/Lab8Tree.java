package Lab202;

import java.util.LinkedList;
import java.util.Queue;



public class Lab8Tree {
	public static void main(String[] args) {
		TreeNode tn = new TreeNode();
		Node n = new Node(1);
		tn.Insert(n, 1);
		tn.Insert(n, 9);
		tn.Insert(n, 6);
		tn.Insert(n, 5);
		tn.Insert(n, 3);
		tn.Insert(n, 8);
		
		Queue<Node> q = new LinkedList<>();
		q.add(n);
		
		
		tn.postorder(n);
		System.out.println();
		tn.preorder(n);
		System.out.println();
		tn.breadth(q);
		
	}
	
	
	static class TreeNode {
		Node root;
		
		public TreeNode() {
			this.root = null;
		}
		public void setRoot(Node root) {
			this.root = root;
		}
		public Node getRoot() {
			return this.root;
		}
		public boolean isEmpty() {
			if(root==null) {
				return true;
			}
			return false;
		}
		
		public void printNode(Node n) {
			if(n==null) {
				System.out.println("the node is empty");
			}
			else {
				System.out.println(n.data);
			}
		}
		public void postorder(Node n) {
			if(n != null) {
				postorder(n.left);
				postorder(n.right);
				System.out.print(n.data+" ");
			}
		}
		public void preorder(Node n) {
			if(n != null) {
				System.out.print(n.data+" ");
				postorder(n.left);
				postorder(n.right);
			}
		}
		
		public void breadth(Queue<Node> queue) {
			if (queue.isEmpty()) {
		        return;
		    }
		    Node temp = queue.poll();
		    System.out.print(temp.data + " ");
		    if (temp.left != null) {
		    	queue.add(temp.left);
		    }
		    if (temp.right != null) {
		    	queue.add(temp.right);
		    }
		    breadth(queue);
		    
		}
		
		public Node Insert(Node node, int data) {
		    if(root == null) {
		        this.root = new Node(data);
		    }
		    else {
		        if(node == null) {
		            return new Node(data);
		        }
		        else if(node.data < data) {
		            node.right = Insert(node.right, data);
		        } 
		        else if(node.data > data) {
		            node.left = Insert(node.left, data);
		        } 
		    }
		return node;
		}
		
	
	}
	
	static class Node {
		
		int data;
		Node left;
		Node right;
		
		public Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
		public void setData(int data) {
			this.data = data;
		}
		public void setLeft(Node left) {
			this.left = left;
		}
		public void setRight(Node right) {
			this.right = right;
		}
		public Node getLeft() {
			return left;
		}
		public Node getRight() {
			return right;
		}
		public int getData() {
			return data;
		}
	}
}
