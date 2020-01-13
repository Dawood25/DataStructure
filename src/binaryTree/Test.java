package binaryTree;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinarySearchTree binarytree=new BinarySearchTree();
		binarytree.insertNode(100);
		binarytree.insertNode(85);
		binarytree.insertNode(155);
		binarytree.insertNode(98);
		binarytree.insertNode(97);
		binarytree.insertNode(96);
		binarytree.insertNode(95);
		binarytree.insertNode(94);
		binarytree.insertNode(93);
		binarytree.insertNode(92);
		binarytree.insertNode(151);
		binarytree.insertNode(152);
		binarytree.insertNode(165);
		binarytree.insertNode(175);
		binarytree.insertNode(181);
		binarytree.insertNode(190);
		
//		binarytree.printInorderTraversal(binarytree.root);
//		binarytree.deleteKey(90);
		System.out.println("height==>>"+binarytree.calculateHeightofTree(binarytree.root));
//		binarytree.printInorderTraversal(binarytree.root);
	}

}
