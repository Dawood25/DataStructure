package binaryTree;

import com.Queue.LinkedList.Queue;

public class BinaryTree {
	BinaryNode root;
	static class BinaryNode{
		Object data;
		BinaryNode left;
		BinaryNode right;
		public BinaryNode(Object data) {
			this.data=data;
			this.left=null;
			this.right=null;
		}
	}
	public BinaryNode findEmptyNode() 
	{
		Queue qu=new Queue();
		qu.enQueue(root);
		while(!qu.isEmpty()) {
			BinaryNode node=(BinaryNode)qu.deQueue();
			if(node.left!=null && node.right!=null) {
				qu.enQueue(node.left);
				qu.enQueue(node.right);
			}else {
				if(node.left==null || node.right==null) {
					return node;
				}
			}
		}
		return null;
	}
	public boolean insertLeafNode(Object data) {
		BinaryNode node=new BinaryNode(data);
		if(root==null) {
			root=node;
			System.out.println("Insert Node at Root Position");
			return true;
		}else {
			BinaryNode emptynode=findEmptyNode();
			if(emptynode.left==null)
			{
				emptynode.left=node;
			}else {
				emptynode.right=node;
			}
		}
		return false;
	}
	public void preOrderTraversal(BinaryNode node) {
		if(node==null) {
			return ;
		}else {
			System.out.println(node.data);
			preOrderTraversal(node.left);			
			preOrderTraversal(node.right);
			
		}
		
	}
	
	public void inOrderTraversal(BinaryNode node) {
		if(node==null) {
			return ;
		}else {
			inOrderTraversal(node.left);
			System.out.println(node.data);
			inOrderTraversal(node.right);
			
		}
	}
	public void postOrderTraversal(BinaryNode node) {
		if(node==null) {
			return ;
		}else {
			postOrderTraversal(node.left);			
			postOrderTraversal(node.right);
			System.out.println(node.data);
			
		}
	}
	
}
