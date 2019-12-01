package binaryTree;

import com.Queue.LinkedList.Queue;

public class BinaryTree {
	BinaryNode root;

	static class BinaryNode {
		Object data;
		BinaryNode left;
		BinaryNode right;

		public BinaryNode(Object data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}

	public BinaryNode findEmptyNode() {
		Queue qu = new Queue();
		qu.enQueue(root);
		while (!qu.isEmpty()) {
			BinaryNode node = (BinaryNode) qu.deQueue();
			if (node.left != null && node.right != null) {
				qu.enQueue(node.left);
				qu.enQueue(node.right);
			} else {
				if (node.left == null || node.right == null) {
					return node;
				}
			}
		}
		return null;
	}

	public boolean insertLeafNode(Object data) {
		BinaryNode node = new BinaryNode(data);
		if (root == null) {
			root = node;
			System.out.println("Insert Node at Root Position");
			return true;
		} else {
			BinaryNode emptynode = findEmptyNode();
			if (emptynode.left == null) {
				emptynode.left = node;
			} else {
				emptynode.right = node;
			}
		}
		return false;
	}

	public void preOrderTraversal(BinaryNode node) {
		if (node == null) {
			return;
		} else {
			System.out.println(node.data);
			preOrderTraversal(node.left);
			preOrderTraversal(node.right);

		}

	}

	public void inOrderTraversal(BinaryNode node) {
		if (node == null) {
			return;
		} else {
			inOrderTraversal(node.left);
			System.out.println(node.data);
			inOrderTraversal(node.right);

		}
	}

	public void postOrderTraversal(BinaryNode node) {
		if (node == null) {
			return;
		} else {
			postOrderTraversal(node.left);
			postOrderTraversal(node.right);
			System.out.println(node.data);

		}
	}

	public BinaryNode findNodeToDelete(Object val) {
		Queue qu = new Queue();
		qu.enQueue(root);
		while (!qu.isEmpty()) {
			BinaryNode node = (BinaryNode) qu.deQueue();
			if ((int)node.data == (int)val) {
				System.out.println("Find the node");
				return node;
			} else {
				if (node.left != null && node.right != null) {
					qu.enQueue(node.left);
					qu.enQueue(node.right);
				} else {
					if (node.left != null) {
						qu.enQueue(node.left);
					}
				}
			}
		}
		return null;

	}

	public BinaryNode deleteLastNode() {
		Queue qu2 = new Queue();
		BinaryNode parent = null;
		BinaryNode temp = null;
		qu2.enQueue(root);
		while (!qu2.isEmpty()) {
			temp = (BinaryNode) qu2.deQueue();
			if (temp.left != null && temp.right != null) {
				parent = temp;
				qu2.enQueue(temp.left);
				qu2.enQueue(temp.right);
			} else {
				if (temp.left != null) {
					parent = temp;
					qu2.enQueue(temp.left);
				}
			}
		}
		System.out.println("Last Node is ==>>"+temp.data);
		System.out.println("parent Node is==>>"+parent.data);
		if(parent.right!=null) {
			parent.right=null;
		}else {
			parent.left=null;
		}
		return temp;
	}

	public void deleteBinaryTreeNode(Object data) {
		BinaryNode nodeToDelete = findNodeToDelete(data);
		if (nodeToDelete == null) {
			System.out.println("value is not present in binary tree");
		}
		BinaryNode lastNode = deleteLastNode();
		nodeToDelete.data = lastNode.data;
		
	}

}
