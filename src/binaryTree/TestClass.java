package binaryTree;

public class TestClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree tree=new BinaryTree();
		tree.insertLeafNode(10);
		tree.insertLeafNode(20);
		tree.insertLeafNode(30);
		tree.insertLeafNode(40);
		tree.insertLeafNode(50);
		tree.insertLeafNode(60);
		tree.insertLeafNode(70);
		tree.insertLeafNode(80);
		tree.insertLeafNode(90);
		System.out.println("PreOrder");
		tree.preOrderTraversal(tree.root);
		System.out.println("PreOrder Completed");
		System.out.println("inOrder");
		tree.inOrderTraversal(tree.root);
		System.out.println("in Order Completed");
		System.out.println("postOrder");
		tree.postOrderTraversal(tree.root);
		System.out.println("postOrder Completed");
	}

}
