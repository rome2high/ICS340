//application driver for code section 2.
//======================================================
public class RunProgram2 {
	public static void main(String[] args) {
		LkBinaryTree lBTree = new LkBinaryTree();
		System.out.println("Test the binary tree with character data type.");
		System.out.println("Insert 'S', 'T', 'U', 'B', 'A', 'F', 'C', 'D' to an empty tree:");
 		lBTree.addNode('S');	
 		lBTree.addNode('T');
 		lBTree.addNode('U');
 		lBTree.addNode('B');
 		lBTree.addNode('A');
 		lBTree.addNode('F');
 		lBTree.addNode('C');
 		lBTree.addNode('D');
		System.out.println("Display of the binary tree shape: ");
		lBTree.treeShape();
	}
}
