package Lab202;

public class Lab10 {
	public static void main(String[] args) {
		
		AVLTree avl = new AVLTree();
		
        avl.root = avl.add(avl.root, 10);
        avl.root = avl.add(avl.root, 20);
        avl.root = avl.add(avl.root, 30);
        avl.root = avl.add(avl.root, 40);
        avl.root = avl.add(avl.root, 50);
        avl.root = avl.add(avl.root, 25);
        
        avl.printTree(avl.root);
        
        System.out.println();
        System.out.println(avl.treeHeight(avl.root));
        System.out.println(avl.balanceFactor(avl.root));
        System.out.println(avl.isAVL(avl.root));
	}
	
	static class AVLTree {
	    Node root;
	   
	    public Node add(Node node, int data) {
	    	
	        if (node == null) {
	        	Node n = new Node(data);
	            return n;
	        }
	        if (data < node.data) {
	            node.left = add(node.left, data);
	        }
	        else if (data > node.data) {
	            node.right = add(node.right, data);
	        }
	        else {
	            return node;
	        }
	        node.height = 1 + max(height(node.left),height(node.right));
	 
	        int balance = balanceFactor(node);
	        if (balance > 1 && data < node.left.data) {
	            return rightRotate(node);
	        }
	        if (balance < -1 && data > node.right.data) {
	            return leftRotate(node);
	        }
	        if (balance > 1 && data > node.left.data) {
	            node.left = leftRotate(node.left);
	            return rightRotate(node);
	        }
	        if (balance < -1 && data < node.right.data) {
	            node.right = rightRotate(node.right);
	            return leftRotate(node);
	        }
	        return node;
	    }
	    
	    
	    public Node rightRotate(Node y) {
	        Node x = y.left;
	        Node T2 = x.right;
	        
	        x.right = y;
	        y.left = T2;
	        y.height = max(height(y.left), height(y.right)) + 1;
	        x.height = max(height(x.left), height(x.right)) + 1;
	        return x;
	    }
	    
	    public Node leftRotate(Node x) {
	        Node y = x.right;
	        Node T2 = y.left;
	        
	        y.left = x;
	        x.right = T2;
	        x.height = max(height(x.left), height(x.right)) + 1;
	        y.height = max(height(y.left), height(y.right)) + 1;
	        return y;
	    }
	    
	    public int balanceFactor(Node node) {
	        if (node == null) {
	            return 0;
	        }
	        return height(node.left) - height(node.right);
	    }
	    
	    
	    public int height(Node node) {
	        if (node != null) {
	            return node.height;
	        }
	        return 0;
	    }
	    
	    public int max(int a, int b) {
	        return (a > b) ? a : b;
	    }
	    
	    public void printTree(Node node) {
	        if (node != null) {
	            System.out.print(node.data + " ");
	            printTree(node.left);
	            printTree(node.right);
	        }
	    }
	    public int treeHeight(Node root) {
	        if(root == null) {
	            return 0;
	        }
	        int height = 1 + Math.max(treeHeight(root.left), treeHeight(root.right));
	        return height;
	    }
	    
	    private boolean isAVL(Node node) {
	        if (node == null)
	            return true;

	        int balance = Math.abs(treeHeight(node.left) - treeHeight(node.right));

	        if (balance > 1)
	            return false;

	        return isAVL(node.left) && isAVL(node.right);
	    }
	    
	    
	}
	
	
	static class Node {
		
		int data;
		int height;
		Node left;
		Node right;
		
		public Node(int data) {
			this.height = 1;
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
		public int getHeight() {
			return height;
		}
	}

}
