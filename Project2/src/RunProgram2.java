public class RunProgram2 {
	public static void main(String[] args) {
		LkBinaryTree lBTree = new LkBinaryTree();
		System.out.println("Insert following nodes to an empty tree:");
		System.out.println("8 6 9 1 2 3 4 5 10 11");
		lBTree.addNode(8);
		lBTree.addNode(6);
		lBTree.addNode(9);
		lBTree.addNode(1);
		lBTree.addNode(2);
		lBTree.addNode(3);
		lBTree.addNode(4);
		lBTree.addNode(5);
		lBTree.addNode(10);
		lBTree.addNode(11);
		System.out.println("Display of the binary tree shape:");
		lBTree.treeShape();
		System.out.println("Call the method find with value 2: " +
		lBTree.find(2));
		System.out.println("Call the method inOrderTravl: ");
		lBTree.inOrderTravl();
	}
}