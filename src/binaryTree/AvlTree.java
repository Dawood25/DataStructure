package binaryTree;

public class AvlTree {
	Node root;

	static class Node {
		public Node left;
		public Node right;
		public int data;

		public Node(int data) {
			this.data = data;
			this.right = null;
			this.left = null;
		}
	}

	public Node insertNode(int data) {
		root = insertNodeInAvl(root, data);
		return null;

	}

	public int calculateHeightOfNode(Node node) {
		if (node == null) {
			return 0;
		} else {
			int right = calculateHeightOfNode(node.right) + 1;
			int left = calculateHeightOfNode(node.left) + 1;
			return right > left ? right : left;
		}
	}

	public Node insertNodeInAvl(Node node, int data) {
		Node newnode = new Node(data);
		if (node == null) {
			node = newnode;
			return node;
		} else {
			if (node.data > data) {
				node.left = insertNodeInAvl(node.left, data);
				int heightRight = calculateHeightOfNode(node.right);
				int heightLeft = calculateHeightOfNode(node.left);
				if (heightLeft - heightRight > 1) {
					if (node.left.left != null && node.left.data > data) {
						Node temp = node;
						node = node.left;
						temp.left = node.right;
						node.right = temp;
					} else {
						if (node.left.right != null && node.left.data < data) {
							Node temp = node;
							node = node.left.right;
//							node.left=temp.left;
							temp.left.right=node.left;
							node.left=temp.left;					
							temp.left=node.right;							
							node.right = temp;
						}
					}
				}
				return node;
			} else {
				if (node.data < data) {
					node.right = insertNodeInAvl(node.right, data);
					int heightRight = calculateHeightOfNode(node.right);
					int heightLeft = calculateHeightOfNode(node.left);
					if (heightRight - heightLeft > 1) {
						if (node.right.right != null && node.right.data < data) {
							Node temp = node;
							node = node.right;
							temp.right = node.left;
							node.left = temp;
						} else if (node.right.left != null && node.right.data > data) {
							Node temp = node;
							node = node.right.left;
							temp.right.left = node.right;
							node.right=temp.right;
							temp.right = node.left;
							node.left = temp;
						}
					}
					return node;
				}
				return node;
			}
		}
	}
	
	public void printInorderTraversal(Node node) {
		if(node==null) {
//			System.out.println("Your tree is completed");
			return ;
		}
		System.out.println(node.data);
		printInorderTraversal(node.left);
		printInorderTraversal(node.right);
	}

}
