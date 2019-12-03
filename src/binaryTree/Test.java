package binaryTree;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinarySearchTree binarytree=new BinarySearchTree();
		binarytree.insertNode(30);
		binarytree.insertNode(10);
		binarytree.insertNode(90);
		binarytree.insertNode(75);
		binarytree.insertNode(55);
		binarytree.insertNode(65);
		binarytree.insertNode(100);
		binarytree.insertNode(20);
		binarytree.printInorderTraversal(binarytree.root);
	}

}
