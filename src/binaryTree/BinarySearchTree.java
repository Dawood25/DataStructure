package binaryTree;

public class BinarySearchTree {
	Node root;

	static class Node {
		Node left;
		Node right;
		Object data;

		public Node(Object data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}

	public Node searchEmptyNode(Node temp, Object data) {

		if ((int) temp.data < (int) data) {
			if (temp.right == null) {
				return temp;
			} else {
				return searchEmptyNode(temp.right, data);
			}
		} else {
			if (temp.left == null)
				return temp;
			else
				return searchEmptyNode(temp.left, data);
		}
	}

	public Node findMinValueNode(Node node) {
		if (node.left == null) {
			return node;
		} else {
			return findMinValueNode(node);
		}
	}

	public void deleteKey(Object val) {
		if (root == null) {
			System.out.println("Tree is empty ");
		}
		 deleteNode(root, val);
	}

	public Node deleteNode(Node node, Object val) {
		if (node == null) {
			return null;
		} else {
			if ((int) node.data > (int) val) {
				node.left = deleteNode(node.left, val);
				return node;
			} else {
				if ((int) node.data < (int) val) {
					node.right = deleteNode(node.right, val);
					return node;
				} else {
					if(node.left==null) {
						System.out.println("Leaf Node or with one right child");
						return node.right;
					}if(node.right==null) {
						System.out.println("Node with one left child");
						return node.left;
					}
					Node minNode=findMinValueNode(node.right);
					node.data=minNode.data;
					node.right=deleteNode(node.right, minNode.data);
					return node;
				}
			}
		}
		
	}
	public boolean insertNode(Object data) {
		Node newNode = new Node(data);
		if (root == null) {
			System.out.println("Inserted value in the root");
			root = newNode;
			return true;
		} else {
			Node emptyNode = searchEmptyNode(root, data);
			if ((int) emptyNode.data > (int) data) {
				System.out.println("Inserted value in the left Node");
				emptyNode.left = newNode;
				return true;
			} else {
				emptyNode.right = newNode;
				System.out.println("Inserted value in the right node");
				return true;
			}
		}
	}

	public void printInorderTraversal(Node root) {
		if (root == null) {
			return;
		}
		printInorderTraversal(root.left);
		System.out.println(root.data);
		printInorderTraversal(root.right);
	}
	public int calculateHeightofNode(Node node) {
		if(node.left==null && node.right==null){
			return 0;
		}else {
			if(node.left!=null && node.right!=null) {
				int left= calculateHeightofNode(node.left)+1;
				int right= calculateHeightofNode(node.right)+1;
				return left>right?left:right;
			}else {
				if(node.right!=null){
					return calculateHeightofNode(node.right)+1;
				}else {
					return calculateHeightofNode(node.left)+1;
				}
			}
		}
	}
	
	public int calculateHeightofTree(Node node) {
		if(node==null) {
			return 0;
		}else {
			int left=calculateHeightofNode(node.left)+1;
			int right=calculateHeightofNode(node.right)+1;
			return left>right?left:right;
		}
	}
}
