public class BinaryTreeNode {
	protected int element, level, xposition;
	protected BinaryTreeNode left, right, parent;
	
	public BinaryTreeNode(){
		element = 0;
		level = 0;
		xposition = 0;
		parent = null;
		left = null;
		right = null;
	}
	
	public BinaryTreeNode(int el){
		element = el;
		level = 0;
		xposition = 0;
		parent = null;
		left = null;
		right = null;
	}
	
	public int element(){
		return element;
	}
	
	public void setElement(int e){
		element = e;
	}
	
	public int getLevel(){
		return level;
	}
	
	public void setLevel(int l){
		level = l;
	}
	
	public int getXPosition(){
		return xposition;
	}
	
	public void setXPosition(int x){
		xposition = x;
	}
	
	public BinaryTreeNode getLeft(){
		return left;
	}
	
	public void setLeft(BinaryTreeNode node){
		left = node;
	}
	
	public BinaryTreeNode getRight(){
		return right;
	}
	
	public void setRight(BinaryTreeNode node){
		right = node;
	}
	
	public BinaryTreeNode getParent(){
		return parent;
	}
	
	public void setParent(BinaryTreeNode node){
		parent = node;
	}
}