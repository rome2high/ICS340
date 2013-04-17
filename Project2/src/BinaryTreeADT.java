public interface BinaryTreeADT {
	public BinaryTreeNode root();
	public boolean isEmpty();
	public int size();
	public boolean isRoot(BinaryTreeNode n);
	public boolean hasParent(BinaryTreeNode n);
	public BinaryTreeNode parent(BinaryTreeNode n);
	public boolean isLeaf(BinaryTreeNode n);
	public boolean hasLeft(BinaryTreeNode n);
	public BinaryTreeNode left(BinaryTreeNode n);
	public boolean hasRight(BinaryTreeNode n);
	public BinaryTreeNode right(BinaryTreeNode n);
	public void addNode(int e);
	public boolean find(int e);
	public void treeShape();
	public void inOrderTravl();
}