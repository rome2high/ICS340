import javax.swing.*;
import java.awt.*;

public class TreePanel extends JPanel{
	private final int WIDTH = 440;
	private final int HEIGHT = 380;
	private int yInc=70;
	protected BinarySearchTree binarySearchTree;
	
	public TreePanel() {
		binarySearchTree = new BinarySearchTree();
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setBackground(Color.ORANGE);
	}
	
	public void insertNode(int e) {
		binarySearchTree.addNode(e);
	}
	
	public void clear() {
		binarySearchTree = new BinarySearchTree();
	}
	
	public boolean delete(int e) {
		if(binarySearchTree.delete(e)){
			return true;
		}
		return false;
	}
	
	public boolean find(int e) {
		if(binarySearchTree.find(e)){
			return true;
		}
		return false;
	}
	
	private int maxNodesInLevel(int level){
		return (int)Math.pow(2.0, level);
	}
		
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		int boundingBox = 24, e, x, y, px, py, xText, yText, nNodes, xInc;
		BTNode n, pn;
		Queue outputQueue = new Queue();
		Queue q1 = new Queue(); 
		Queue q2 = new Queue();
		if(!binarySearchTree.isEmpty()){
		    n = binarySearchTree.root();
		    x = WIDTH/2;
		    y = yInc;
		    n.setLevel(0);
		    n.setX(x);
		    n.setY(y);
			q1.enque(n);
			while(!q1.isEmpty()||!q2.isEmpty()){
				if(!q1.isEmpty()){
					while(!q1.isEmpty()){
						n = (BTNode)q1.deque();
						if(binarySearchTree.hasParent(n)) {
							pn = n.getParent();
						    px = pn.getX();
						    py = pn.getY();
						    int level = pn.getLevel();
						    n.setLevel(level+1);
						    nNodes = maxNodesInLevel(n.getLevel());
						    xInc = WIDTH/(nNodes+level+2);
						    if(n == pn.getRight()) { 
						    	x = px+xInc;
						    }
						    else{ 
						    	x = px-xInc;
						    }
						    y = py + yInc;						        
						    n.setX(x);
						    n.setY(y);
						    n.setPX(px);
						    n.setPY(py);
						}
						if(n.getLeft()!=null){
						    q2.enque(n.getLeft());
						}
						if(n.getRight()!=null){
						    q2.enque(n.getRight());
						}
						outputQueue.enque(n);				
					}
				}
				if(!q2.isEmpty()){
					while(!q2.isEmpty()){
						n = (BTNode)q2.deque();
						pn = n.getParent();
					    px = pn.getX();
					    py = pn.getY();
					    int level = pn.getLevel();
					    n.setLevel(level+1);
					    nNodes = maxNodesInLevel(n.getLevel());
					    xInc = WIDTH/(nNodes+level+2);
					    if(n == pn.getRight()) {
					    	x = px+xInc;
						}
						else{ 
							x = px-xInc;
						}
						y = py + yInc;						        
						n.setX(x);
						n.setY(y);
					    n.setPX(px);
					    n.setPY(py);
					    if(n.getLeft()!=null){
					    	q1.enque(n.getLeft());
						}
						if(n.getRight()!=null){
							q1.enque(n.getRight());
						}
						outputQueue.enque(n);
					}
				}
			}
		}
			
		if(!outputQueue.isEmpty()){
			n = (BTNode)outputQueue.deque();
			e = n.element();
			x = n.getX();
			x = x - boundingBox/2;  
			y = n.getY();
			g.setColor(Color.black);
			g.fillOval(x, y, boundingBox, boundingBox);
			xText = x + boundingBox/3 - 5;
			yText = y + boundingBox/2 + 5;
			g.setColor(Color.white);
			g.drawString(e+"", xText, yText);
			while(!outputQueue.isEmpty()){
				n = (BTNode)outputQueue.deque();
				e = n.element();
				x = n.getX();
				x = x - boundingBox/2;
				y = n.getY();
				px = n.getPX();
				py = n.getPY();
				py = py + boundingBox/2;
				g.setColor(Color.black);
				g.fillOval(x, y, boundingBox, boundingBox);
				xText = x + boundingBox/3 - 5;
				yText = y + boundingBox/2 + 5;
				g.setColor(Color.white);
				g.drawString(e+"", xText, yText);
				g.setColor(Color.black);
				x = x + 10;
				g.drawLine(x, y, px, py);
			}
		} 
	}
}
