package binaryTree;

public class BinarySearchTree {
	Node root;
	static class Node{
		Node left;
		Node right;
		Object data;
		public Node(Object data) {
			this.data=data;
			this.left=null;
			this.right=null;
		}
	}
	public Node searchEmptyNode(Node temp,Object data) {
		
		if((int)temp.data<(int)data) {
			if(temp.right==null) {
			return temp;
			}else {
				return searchEmptyNode(temp.right, data);
			}
		}else{
			if(temp.left==null)
				return temp;
			else
				return searchEmptyNode(temp.left, data);
		}		
	}
	public boolean insertNode(Object data) {
		Node newNode=new Node(data);
		if(root==null) {
			System.out.println("Inserted value in the root");
			root=newNode;
			return true;
		}else {
		Node emptyNode=searchEmptyNode(root,data);
		if((int)emptyNode.data>(int)data) {
			System.out.println("Inserted value in the left Node");
			emptyNode.left=newNode;
			return true;
		}else {
			emptyNode.right=newNode;
			System.out.println("Inserted value in the right node");
			return true;
		}		
		}
	}
	public void printInorderTraversal(Node root) {
		if(root==null) {
			return ;
		}
		printInorderTraversal(root.left);
		System.out.println(root.data);
		printInorderTraversal(root.right);		
	}
}
