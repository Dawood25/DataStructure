package binaryTree;

public class AvlTreeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AvlTree avl=new AvlTree();
		avl.insertNode(30);
		avl.insertNode(20);
		avl.insertNode(60);
		avl.insertNode(10);
		avl.insertNode(50);
		avl.insertNode(55);
		avl.insertNode(52);
		avl.printInorderTraversal(avl.root);
		avl.deleteNode(10);
		System.out.println("\n\n\n\n\n");
		avl.printInorderTraversal(avl.root);
	}

}
