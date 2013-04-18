
//application driver for code unit 4, for testing getNode method.
public class GraphFlip {

	public static void main(String[] args) {
		GraphMatrix<CoinNode> graphMatrix = new GraphMatrix<CoinNode>();
		//create 3 nodes
		CoinNode coinNode = new CoinNode("head-head-head");
		graphMatrix.newNode(0, coinNode);
		coinNode = new CoinNode("head-tail-head");
		graphMatrix.newNode(1, coinNode);
		coinNode = new CoinNode("tail-head-head");
		graphMatrix.newNode(2, coinNode);
		
		System.out.println("The result of calling getNode method:");
		System.out.println("Vertex " + graphMatrix.getNode(1).getVertexNumber()
				+ " " + graphMatrix.getNode(1));
	}
}

//application driver for code unit 5, for testing removeEdge method.
/*======================================================
public class GraphFlip {

	public static void main(String[] args) {
		GraphMatrix<CoinNode> graphMatrix = 
			new GraphMatrix<CoinNode>();
		//create 4 nodes
		CoinNode coinNode = new CoinNode("head-head-head");
		graphMatrix.newNode(0, coinNode);
		coinNode = new CoinNode("head-tail-head");
		graphMatrix.newNode(1, coinNode);
		coinNode = new CoinNode("tail-head-head");
		graphMatrix.newNode(2, coinNode);
		coinNode = new CoinNode("tail-tail-head");
		graphMatrix.newNode(3, coinNode);
		
		//create 6 edges according to the given diagram
		graphMatrix.addEdge(0, 1);
		graphMatrix.addEdge(1, 0);
		graphMatrix.addEdge(0, 2);
		graphMatrix.addEdge(2, 0);
		graphMatrix.addEdge(2, 3);
		graphMatrix.addEdge(3, 2);
		
		System.out.println("The edge value of node 0 to 2 is: ");
		System.out.println(graphMatrix.edgeValue(0, 2));
		graphMatrix.removeEdge(0, 2);
		System.out.println("The edge value of node 0 to 2 after calling removeEdge is: ");
		System.out.println(graphMatrix.edgeValue(0, 2));
	}
}*/

//application driver for code unit 6, for testing size method.
/*======================================================
public class GraphFlip {

	public static void main(String[] args) {
		GraphMatrix<CoinNode> graphMatrix = 
			new GraphMatrix<CoinNode>();
		//create 4 nodes
		CoinNode coinNode = new CoinNode("head-head-head");
		graphMatrix.newNode(0, coinNode);
		coinNode = new CoinNode("head-tail-head");
		graphMatrix.newNode(1, coinNode);
		coinNode = new CoinNode("tail-head-head");
		graphMatrix.newNode(2, coinNode);
		coinNode = new CoinNode("tail-tail-head");
		graphMatrix.newNode(3, coinNode);
		
		System.out.println("The number of nodes in the graph is: ");
		System.out.println(graphMatrix.size());
	}
}
*/

//application driver for code unit 7, test for the BFT method.
/*======================================================
public class GraphFlip {

	public static void main(String[] args) {
		GraphMatrix<CoinNode> graphMatrix = 
			new GraphMatrix<CoinNode>();
		//create 8 nodes
		CoinNode coinNode = new CoinNode("head-head-head");
		graphMatrix.newNode(0, coinNode);
		coinNode = new CoinNode("head-tail-head");
		graphMatrix.newNode(1, coinNode);
		coinNode = new CoinNode("tail-head-head");
		graphMatrix.newNode(2, coinNode);
		coinNode = new CoinNode("tail-tail-head");
		graphMatrix.newNode(3, coinNode);
		coinNode = new CoinNode("tail-tail-tail");
		graphMatrix.newNode(4, coinNode);
		coinNode = new CoinNode("tail-head-tail");
		graphMatrix.newNode(5, coinNode);
		coinNode = new CoinNode("head-tail-tail");
		graphMatrix.newNode(6, coinNode);
		coinNode = new CoinNode("head-head-tail");
		graphMatrix.newNode(7, coinNode);
		//create 16 edges according to the given diagram
		graphMatrix.addEdge(0, 1);
		graphMatrix.addEdge(1, 0);
		graphMatrix.addEdge(0, 2);
		graphMatrix.addEdge(2, 0);
		graphMatrix.addEdge(0, 7);
		graphMatrix.addEdge(7, 0);
		graphMatrix.addEdge(2, 3);
		graphMatrix.addEdge(3, 2);
		graphMatrix.addEdge(3, 4);
		graphMatrix.addEdge(4, 3);
		graphMatrix.addEdge(4, 5);
		graphMatrix.addEdge(5, 4);
		graphMatrix.addEdge(4, 6);
		graphMatrix.addEdge(6, 4);
		graphMatrix.addEdge(6, 7);
		graphMatrix.addEdge(7, 6);
		System.out.println("The result of BFT traversal:");
		graphMatrix.BFT(0);
	}
}
*/

//application driver for code unit 8, test for the BFTSearch method.
/*======================================================
public class GraphFlip {

	public static void main(String[] args) {
		GraphMatrix<CoinNode> graphMatrix = 
			new GraphMatrix<CoinNode>();
		//create 8 nodes
		CoinNode coinNode = new CoinNode("head-head-head");
		graphMatrix.newNode(0, coinNode);
		coinNode = new CoinNode("head-tail-head");
		graphMatrix.newNode(1, coinNode);
		coinNode = new CoinNode("tail-head-head");
		graphMatrix.newNode(2, coinNode);
		coinNode = new CoinNode("tail-tail-head");
		graphMatrix.newNode(3, coinNode);
		coinNode = new CoinNode("tail-tail-tail");
		graphMatrix.newNode(4, coinNode);
		coinNode = new CoinNode("tail-head-tail");
		graphMatrix.newNode(5, coinNode);
		coinNode = new CoinNode("head-tail-tail");
		graphMatrix.newNode(6, coinNode);
		coinNode = new CoinNode("head-head-tail");
		graphMatrix.newNode(7, coinNode);
		//create 16 edges according to the given diagram
		graphMatrix.addEdge(0, 1);
		graphMatrix.addEdge(1, 0);
		graphMatrix.addEdge(0, 2);
		graphMatrix.addEdge(2, 0);
		graphMatrix.addEdge(0, 7);
		graphMatrix.addEdge(7, 0);
		graphMatrix.addEdge(2, 3);
		graphMatrix.addEdge(3, 2);
		graphMatrix.addEdge(3, 4);
		graphMatrix.addEdge(4, 3);
		graphMatrix.addEdge(4, 5);
		graphMatrix.addEdge(5, 4);
		graphMatrix.addEdge(4, 6);
		graphMatrix.addEdge(6, 4);
		graphMatrix.addEdge(6, 7);
		graphMatrix.addEdge(7, 6);
		System.out.println("The result of BFT traversal:");
		graphMatrix.BFT(0);
		System.out.println("The result of BFT search:");
		graphMatrix.BFTSearch(0, 5);
	}
}
*/

//application driver for code unit 9, test for the toString method.
/*======================================================
public class GraphFlip {

	public static void main(String[] args) {
		GraphMatrix<CoinNode> graphMatrix = 
			new GraphMatrix<CoinNode>();
		//create 8 nodes
		CoinNode coinNode = new CoinNode("head-head-head");
		graphMatrix.newNode(0, coinNode);
		coinNode = new CoinNode("head-tail-head");
		graphMatrix.newNode(1, coinNode);
		coinNode = new CoinNode("tail-head-head");
		graphMatrix.newNode(2, coinNode);
		coinNode = new CoinNode("tail-tail-head");
		graphMatrix.newNode(3, coinNode);
		System.out.println("The nodes in the graph are: ");
		System.out.println(graphMatrix);
	}
}
*/




