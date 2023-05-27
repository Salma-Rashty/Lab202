package Lab202;

public class Lab7Tree {
	public static void main(String[] args) {
		TreeNode n = new TreeNode();
		
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
		
		
		public Node RecursiveInsertBinarySearchTree(Node node, int data) {
		    if(root == null) {
		        this.root = new Node(data);
		    }
		    else {
		        if(node == null) {
		            return new Node(data);
		        }
		        else if(node.data < data) {
		            node.right = RecursiveInsertBinarySearchTree(node.right, data);
		        } 
		        else if(node.data > data) {
		            node.left = RecursiveInsertBinarySearchTree(node.left, data);
		        } 
		    }
		return node;
		}
		
		public Node IterativeFindMinimum() {
			return null;
		}
		
		public Node IterativeFindMaximum() {
			return null;
		}
		
		public Node RecursiveFindMinimum() {
			return null;
		}
		
		public Node RecursiveFindMaximum() {
			return null;
		}
		
		public Node findElement(int data) {
			Node n = root;
			if(isEmpty()) {
				System.out.println("The tree is empty");
				return null;
			}
			else {
				while(n!=null) {
					if(n.data == data) {
						return n;
					}
					else if(n.data>data) {
						n = n.left;
					}
					else {
						n = n.right;
					}
				}
				
			}
			
			return n;
		}
		
		
		public int CountNodes(Node n) {
			if(n==null) {
				return 0;
			}
			else {
				return 1 + CountNodes(n.left) + CountNodes(n.right);
			}
		}
		
		public int CountLeaves(Node n) {
			if(n==null) {
				return 0;
			}
			else if(n.left==null && n.right==null){
				return 1;
			}
			else {
				return CountNodes(n.left) + CountNodes(n.right);
			}
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
