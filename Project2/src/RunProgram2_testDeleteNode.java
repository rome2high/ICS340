//application driver for code unit 6, for testing deleteNode method.
//======================================================
public class RunProgram2_testDeleteNode {
	public static void main(String[] args) {
		LkBinaryTree lBTree = new LkBinaryTree();
		System.out.println("Test delete case 1, the deleted node has no children.");
		System.out.println("Insert 8 to an empty tree:");
 		lBTree.addNode(8);	
		System.out.println("Display of the binary tree shape: ");
		lBTree.treeShape();
		System.out.println("Call the method deletNode(8): ");
		lBTree.deleteNode(8);
		System.out.println("Display of the binary tree shape: ");
		lBTree.treeShape();
		System.out.println();
		System.out.println();
		System.out.println("Insert 8 6 to an empty tree:");
 		lBTree.addNode(8);	
 		lBTree.addNode(6);	
		System.out.println("Display of the binary tree shape: ");
		lBTree.treeShape();
		System.out.println("Call the method deletNode(6): ");
		lBTree.deleteNode(6);
		System.out.println("Display of the binary tree shape: ");
		lBTree.treeShape();
		System.out.println();
		System.out.println();
		
		System.out.println("Test delete case 2, the deleted node has no right child.");
		lBTree = new LkBinaryTree();
		System.out.println("Insert 8 6 to an empty tree:");		
 		lBTree.addNode(8);
 		lBTree.addNode(6);
		System.out.println("Display of the binary tree shape: ");
		lBTree.treeShape();
		System.out.println("Call the method deletNode(8): ");
		lBTree.deleteNode(8);
		System.out.println("Display of the binary tree shape: ");
		lBTree.treeShape();
		System.out.println();
		System.out.println();
		lBTree = new LkBinaryTree();
		System.out.println("Insert 8 6 9 1 to an empty tree:");		
 		lBTree.addNode(8);
 		lBTree.addNode(6);
 		lBTree.addNode(9);
 		lBTree.addNode(1);
		System.out.println("Display of the binary tree shape: ");
		lBTree.treeShape();
		System.out.println("Call the method deletNode(6): ");
		lBTree.deleteNode(6);
		System.out.println("Display of the binary tree shape: ");
		lBTree.treeShape();
		System.out.println();
		System.out.println();
		
		System.out.println("Test delete case 3, the deleted node has two children.");
		lBTree = new LkBinaryTree();
		System.out.println("Insert 3 4 5 9 7 6 8 1 2 to an empty tree:");		
 		lBTree.addNode(3);
 		lBTree.addNode(4);
 		lBTree.addNode(5);
 		lBTree.addNode(9);
 		lBTree.addNode(7);
 		lBTree.addNode(6);
 		lBTree.addNode(8);
 		lBTree.addNode(1);
 		lBTree.addNode(2);
		System.out.println("Display of the binary tree shape: ");
		lBTree.treeShape();
		System.out.println("Call the method deletNode(4): ");
		lBTree.deleteNode(4);
		System.out.println("Display of the binary tree shape: ");
		lBTree.treeShape();
		System.out.println();
		System.out.println();
	}
}