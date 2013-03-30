import com.sun.org.apache.xml.internal.resolver.helpers.Debug;

public class BinarySearchTree implements BinaryTreeADT {
	protected  BTNode  root;
	protected  int  size;
				    
	public BinarySearchTree(){
		root = null;
		size = 0;
	}
	
	public BTNode root(){
		if(!isEmpty())
			return  root;
		else return null;
	}
			
	public boolean isEmpty() {
		return (root == null);        
	}
				
	public int size() {return  size;}
			
	public boolean isRoot(BTNode v) {
		if(root == null)
			return false;
		else
			return  (v == root);
	} 

	public boolean hasParent(BTNode v) {
		if(v.getParent() == null)
			return false;
		else return true;
	}
				    
	public BTNode parent(BTNode v){
		if(hasParent(v))
			return v.getParent();
		else return null;
	}

	public boolean isLeaf(BTNode v) {
		return (!hasLeft(v) && !hasRight(v));
	}
				
	public boolean hasLeft(BTNode v) {
		return  (v.getLeft() != null);
	}
			    
	public BTNode left(BTNode v){
		if(hasLeft(v))
			return v.getLeft();
		else return null;
	}

	public boolean hasRight(BTNode v) {
		return  (v.getRight() != null);
	}
			    
	public BTNode right(BTNode v){
		if(hasRight(v))
			return v.getRight();
		else return null;
	}
	
    	
	private boolean findNode(int e, TreeNodeWrapper p,
    		TreeNodeWrapper c) {
    p.set(root);
    c.set(root);
    if(isEmpty()) {
    	return false;
    }
    
    while(c.get() != null){
    	if(c.get().element()== e) {
    		return true;
    	}
    	else {
    		p.set(c.get());
        	if(e < c.get().element())
        		c.set(c.get().getLeft());
        	else
        		c.set(c.get().getRight());
        }
    }
    return false;
	}

	public class TreeNodeWrapper {
	    BTNode treeRef = null;
	    public TreeNodeWrapper(){}
	    public BTNode get(){
	    	return treeRef;
	    }
	    public void set(BTNode t){
	    	treeRef = t;
	    }
	}

	public boolean find(int e) {
		TreeNodeWrapper p = new TreeNodeWrapper();
		TreeNodeWrapper c = new TreeNodeWrapper();	
		if(findNode(e, p, c)){
			return true;
		}
		return false;
	}

	public void addNode(int e) { 
		BTNode n = new BTNode(e);
			TreeNodeWrapper p = new TreeNodeWrapper();
			TreeNodeWrapper c = new TreeNodeWrapper();	
		if(isEmpty()) { 
			root = n; 
		}
		else{
			if(findNode(e, p, c))
			{
				System.out.println("Adding existing value not supported"); //not required
			 return;
			}
			if(e > p.get().element()) { 
				p.get().setRight(n); 
			}
			else{
				p.get().setLeft(n); 
			}
			n.setParent(p.get()); 
		}
		size++;   
	}

	public boolean delete(int e) {
		TreeNodeWrapper p = new TreeNodeWrapper();
		TreeNodeWrapper c = new TreeNodeWrapper();
		boolean found = findNode(e, p, c);
		if (found == false)
			return false;
		if (c.get().getLeft() == null && c.get().getRight() == null) {
			if (c.get() == root)
				root = null;
			else if (p.get().getLeft() == c.get())
				p.get().setLeft(null);
			else
				p.get().setRight(null);
		} else if ((c.get().getLeft() != null && c.get().getRight() == null)
					|| (c.get().getRight() != null && c.get().getLeft() == null)) {
			if (c.get() == root) {
				if (root.getLeft() != null)
					root = root.getLeft();
				else
					root = root.getRight();
				root.setParent(null);
			} else if (p.get().getLeft() == c.get()) {
				if (c.get().getLeft() != null) {
					p.get().setLeft(c.get().getLeft());
					c.get().getLeft().setParent(p.get());
				} else {
					p.get().setLeft(c.get().getRight());
					c.get().getRight().setParent(p.get());
				}
			} else {  
				if (c.get().getLeft() != null) { 
					p.get().setRight(c.get().getLeft());
					c.get().getLeft().setParent(p.get());
				} else {
					p.get().setRight(c.get().getRight());
					c.get().getRight().setParent(p.get());
				}
			}
		} else {
			BTNode nextLargest = c.get().getLeft();
			BTNode largest = nextLargest.getRight();
			if (largest != null) { 
				while (largest.getRight() != null) {
					nextLargest = largest;
					largest = largest.getRight();
				} 
				c.get().setElement(largest.element());
				nextLargest.setRight(largest.getLeft()); 
				if (largest.getLeft() != null)
					largest.getLeft().setParent(nextLargest); 
			} else {  
				nextLargest.setRight(c.get().getRight()); 
				c.get().getRight().setParent(nextLargest);
				if (c.get() == root) {
					root = nextLargest;
					root.setParent(null);
				} else if (p.get().getLeft() == c.get()) { 
					p.get().setLeft(nextLargest); 
					nextLargest.setParent(p.get());
				} else {
					p.get().setRight(nextLargest);
					nextLargest.setParent(p.get());
				}
			}
		}
		size--;
		return true;
	}

}
