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

	public Node makeLLRotate(Node node) {
		System.out.println("LL Rotation");
		Node temp = node;
		node = node.left;
		temp.left = node.right;
		node.right = temp;
		return node;
	}

	public Node makeLRRotate(Node node) {
		System.out.println("LR Rotation");
		Node temp = node;
		node = node.left.right;
//		node.left=temp.left;
		temp.left.right = node.left;
		node.left = temp.left;
		temp.left = node.right;
		node.right = temp;
		return node;
	}

	public Node makeRRRotate(Node node) {
		System.out.println("RR Rotation");
		Node temp = node;
		node = node.right;
		temp.right = node.left;
		node.left = temp;
		return node;
	}

	public Node makeRLRotate(Node node) {
		System.out.println("RL Rotation");
		Node temp = node;
		node = node.right.left;
		temp.right.left = node.right;
		node.right = temp.right;
		temp.right = node.left;
		node.left = temp;
		return node;
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
						node=makeLLRotate(node);
					} else {
						if (node.left.right != null && node.left.data < data) {
							node=makeLRRotate(node);
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
							node=makeRRRotate(node);
						} else if (node.right.left != null && node.right.data > data) {
							node=makeRLRotate(node);
						}
					}
					return node;
				}
				return node;
			}
		}
	}

	public void deleteNode(int data) {
		root = deleteNodeInAvlTree(root, data);
		Node temp = root;
		int rightHeight = calculateHeightOfNode(root.right);
		int lefttHeight = calculateHeightOfNode(root.left);
		if (rightHeight - lefttHeight > 1) {
			if (root.right.right.left != null || root.right.right.right != null) {
				root=makeRRRotate(root);
			} else if (root.right.left.right != null || root.right.left.left != null) {
				root=makeRLRotate(root);
			}
		} else if (lefttHeight - rightHeight > 1) {
			if (root.left.left.left != null || root.left.left.right != null) {
				root=makeLLRotate(root);
			} else if (root.left.right.left != null || root.left.right.right!=null) {
				root=makeLRRotate(root);
			}
		}
	}

	public Node deleteNodeInAvlTree(Node node, int data) {
		if (node == null) {
			return null;
		} else {
			if (data < node.data) {
				node.left = deleteNodeInAvlTree(node.left, data);
				int leftHeight = calculateHeightOfNode(node.left);
				int rightHeight = calculateHeightOfNode(node.right);
				if (rightHeight - leftHeight > 1) {
					if (node.right.right.left != null || node.right.right.right != null ) {
						node=makeRRRotate(node);
					} else if (node.right.left.right != null || node.right.left.left != null) {
						node=makeRLRotate(node);
					}
				} else if (leftHeight - rightHeight > 1) {
					if (node.left.left.right != null || node.left.left.left != null) {
						node=makeLLRotate(node);
					} else if (node.left.right.left != null || node.left.right.right != null) {
						node=makeLRRotate(node);
					}
				}
				return node;
			} else if (data > node.data) {
				node.right = deleteNodeInAvlTree(node.right, data);
				int leftHeight = calculateHeightOfNode(node.left);
				int rightHeight = calculateHeightOfNode(node.right);
				if (rightHeight - leftHeight > 1) {
					if (node.right.right != null) {
						node=makeRRRotate(node);
					} else if (node.right.left != null) {
						node=makeRLRotate(node);
					}
				} else if (leftHeight - rightHeight > 1) {
					if (node.left.left != null) {
						node=makeLLRotate(node);
					} else if (node.left.right != null) {
						node=makeLRRotate(node);
					}
				}
				return node;
			} else {
				if (node.left == null)
					return node.right;
				if (node.right == null)
					return node.left;

				Node successorNode = findSuccessorNode(node.right);
				node.data = successorNode.data;
				node.right = deleteNodeInAvlTree(node.right, successorNode.data);
				return node;
			}
		}
	}

	public Node findSuccessorNode(Node node) {
		if (node.left == null) {
			return node;
		} else
			return findSuccessorNode(node.left);
	}

	public void printInorderTraversal(Node node) {
		if (node == null) {
//			System.out.println("Your tree is completed");
			return;
		}
		System.out.println(node.data);
		printInorderTraversal(node.left);
		printInorderTraversal(node.right);
	}

}
