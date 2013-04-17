
public class LkBinaryTree implements BinaryTreeADT {
	protected  BinaryTreeNode  root;
	protected  int  size, space = 50;
	protected Queue queue;
		    
	public LkBinaryTree(){
		root = null;
		size = 0;
		queue = new Queue();
	}

	public BinaryTreeNode root(){
		if(!isEmpty())
			return  root;
		else return null;
	}
	
	public boolean isEmpty() {
		return (root == null);        
	}
		
	public int size() {return  size;}
	
	public boolean isRoot(BinaryTreeNode v) {
		if(root == null)
			return false;
		else
			return  (v == root());
	} 

	public boolean hasParent(BinaryTreeNode v) {
		if(v.getParent() == null)
	    	return false;
	    else return true;
	}
		    
	public BinaryTreeNode parent(BinaryTreeNode v){
		if(hasParent(v))
			return v.getParent();
		else return null;
	}

	public boolean isLeaf(BinaryTreeNode v) {
		return (!hasLeft(v) && !hasRight(v));
	}
		
	public boolean hasLeft(BinaryTreeNode v) {
	    return  (v.getLeft() != null);
	}
	    
	public BinaryTreeNode left(BinaryTreeNode v){
		if(hasLeft(v))
			return v.getLeft();
		else return null;
	}

	public boolean hasRight(BinaryTreeNode v) {
	    return  (v.getRight() != null);
	}
	    
	public BinaryTreeNode right(BinaryTreeNode v){
		if(hasRight(v))
			return v.getRight();
		else return null;
	}
	
	//help method that is used by addNode method.
	private int maxNodesInLevel(int level){
		return (int)Math.pow(2.0, level);
	}
	
   	 public void addNode(int e) {
		int nNodes, xInc, xCenter;
    		BinaryTreeNode n = new BinaryTreeNode(e);
		queue.enque(n);
    		if(isEmpty()) {
    			root = n; 
    			n.setLevel(0);
    			n.setXPosition(space/2);
    		}
    		else{
    			BinaryTreeNode tmp = (BinaryTreeNode)queue.peek();
    			n.setLevel(tmp.getLevel()+1);
    			xCenter = tmp.getXPosition();
			nNodes = maxNodesInLevel(n.getLevel());
			xInc = space/(nNodes+2);
        			if(hasLeft(tmp)) {
        				queue.deque();
        				tmp.setRight(n); // insert new node as a right child
        				n.setXPosition(xCenter+xInc);
        			}
        			else{
        				tmp.setLeft(n); // insert new node as a left child 
        				n.setXPosition(xCenter-xInc);
        			}
        			n.setParent(tmp); // set new node's parent pointer
    		}
		size = size + 1;
    	}         
    
   	 //the following method search the entire tree and compare the integer
   	 //value e  with each node's value.  Referenced Lewis' book pp. 270.
   	 private BinaryTreeNode treeSearch(int e, BinaryTreeNode aRoot){
		if(aRoot == null){
			return null;
		}		
		if(aRoot.element() == e) return aRoot;
		BinaryTreeNode n = treeSearch(e, aRoot.getLeft());
		if(n == null) {
			n = treeSearch(e, aRoot.getRight());
		}
		return n;
    	}
	
   	 public boolean find(int e) {
    		BinaryTreeNode n = treeSearch(e, root);
    		if(n == null)
    			return false;
    		else
    			return true;
    	}
    
	public void treeShape(){
		BinaryTreeNode n;
		int xold, xnew, xdelta;
		String blank = " ", s = "";
		Queue q1 = new Queue();
		Queue q2 = new Queue();
		if(isEmpty()){
			System.out.println("The tree is empty.");
		}
		else {
			q1.enque(root);
			while(!q1.isEmpty()||!q2.isEmpty()){
				if(!q1.isEmpty()){
					xold = 0;
					while(!q1.isEmpty()){
						n = (BinaryTreeNode)q1.deque();
						if(n.getLeft()!=null){
							q2.enque(n.getLeft());
						}
						if(n.getRight()!=null){
							q2.enque(n.getRight());
						}
						xnew = n.getXPosition();
						xdelta = xnew - xold;
						for(int i=0; i<xdelta; i++)  s += blank;
						System.out.print(s + n.element());
						xold = xnew;
						s = "";
					}
					System.out.println();
					System.out.println();
					System.out.println();				
				}
				if(!q2.isEmpty()){
					xold = 0;
					while(!q2.isEmpty()){
						n = (BinaryTreeNode)q2.deque();
						if(n.getLeft()!=null){
							q1.enque(n.getLeft());
						}
						if(n.getRight()!=null){
							q1.enque(n.getRight());
						}
						xnew = n.getXPosition();
						xdelta = xnew - xold;
						for(int i=0; i<xdelta; i++)  s += blank;
						System.out.print(s + n.element());
						xold = xnew;
						s = "";
					}
					System.out.println();
					System.out.println();
					System.out.println();
				}
			}
		}
	}
    
    	//the following method implements the in-order depth first search.
    	//it is used by the inOrderTravl method.
   	private void LNRSearch(BinaryTreeNode aRoot){
		if(hasLeft(aRoot))
			LNRSearch(aRoot.getLeft());
		System.out.print(aRoot.element() + " ");
		if(hasRight(aRoot))
			LNRSearch(aRoot.getRight());
   	}
	
   	 public void inOrderTravl() {
    		if(!isEmpty())
    			LNRSearch(root);
    	}

	public boolean deleteNode(int e) {    	
	//Finish the rest of this code unit.
		
		BinaryTreeNode c = treeSearch(e, root()); //get current Node
		
		if(c == null){
			return false;
		} else if(isLeaf(c)) {		//case1
			if(isRoot(c)){
				root = null;
			} else if(c.parent.right == c){
				c.parent.right = null;
			} else {
				c.parent.left = null;
			}
		} else if(c.right == null){	//case2
			if(isRoot(c)){
				root.element = c.left.element;
				if(root.right == c){
					root.right = null;
				} else {
					root.left = null;
				}
			} else {
				c.parent.left.element = c.left.element;
				c.left = null;
			}
		} else {					//case3
			BinaryTreeNode nl = c.left;		//next largest
			BinaryTreeNode l = nl.right;		//largest
			
			while (l.right != null){
				nl = l;
				l = nl.right;
			}
			System.out.println(l.element);
			c.element = l.element;
			nl.right = l.left;
		}
		queue.deque();
		size--;
		return true;
	}
}
//	} else {
//		BTNode nextLargest = c.get().getLeft();
//		BTNode largest = nextLargest.getRight();
//		if (largest != null) { 
//			while (largest.getRight() != null) {
//				nextLargest = largest;
//				largest = largest.getRight();
//			} 
//			c.get().setElement(largest.element());
//			nextLargest.setRight(largest.getLeft()); 
//			if (largest.getLeft() != null)
//				largest.getLeft().setParent(nextLargest); 
//		} else {  
//			nextLargest.setRight(c.get().getRight()); 
//			c.get().getRight().setParent(nextLargest);
//			if (c.get() == root) {
//				root = nextLargest;
//				root.setParent(null);
//			} else if (p.get().getLeft() == c.get()) { 
//				p.get().setLeft(nextLargest); 
//				nextLargest.setParent(p.get());
//			} else {
//				p.get().setRight(nextLargest);
//				nextLargest.setParent(p.get());
//			}
//		}
//	}
//	size--;
//	return true;
//}

//public boolean delete(int e) {
//TreeNodeWrapper p = new TreeNodeWrapper();
//TreeNodeWrapper c = new TreeNodeWrapper();
//boolean found = findNode(e, p, c);
//if (found == false)
//	return false;
//if (c.get().getLeft() == null && c.get().getRight() == null) {
//	if (c.get() == root)
//		root = null;
//	else if (p.get().getLeft() == c.get())
//		p.get().setLeft(null);
//	else
//		p.get().setRight(null);
//} else if ((c.get().getLeft() != null && c.get().getRight() == null)
//			|| (c.get().getRight() != null && c.get().getLeft() == null)) {
//	if (c.get() == root) {
//		if (root.getLeft() != null)
//			root = root.getLeft();
//		else
//			root = root.getRight();
//		root.setParent(null);
//	} else if (p.get().getLeft() == c.get()) {
//		if (c.get().getLeft() != null) {
//			p.get().setLeft(c.get().getLeft());
//			c.get().getLeft().setParent(p.get());
//		} else {
//			p.get().setLeft(c.get().getRight());
//			c.get().getRight().setParent(p.get());
//		}
//	} else {  
//		if (c.get().getLeft() != null) { 
//			p.get().setRight(c.get().getLeft());
//			c.get().getLeft().setParent(p.get());
//		} else {
//			p.get().setRight(c.get().getRight());
//			c.get().getRight().setParent(p.get());
//		}
//	}
