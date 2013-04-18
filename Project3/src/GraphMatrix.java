
import java.util.Stack;

public class GraphMatrix<T> implements GraphADT<T> {
	private int[][] edges;
	private T[] nodes;
	private int countVertex;
	private int DEFAULT = 100;
	
	public GraphMatrix(){
		nodes = (T[]) new Object[DEFAULT];
		countVertex = 0;
		edges = new int[DEFAULT][DEFAULT];
	}
       	//methods to be added in the following

	public void newNode(int vertex, T newNode) {
		System.out.println("creating newNode..." + vertex);
		
	}

	public T getNode(int vertex) {
		System.out.println("getNode..." + vertex);
		return null;
	}

	public void addEdge(int source, int target) {
		System.out.println("addEdge... source: "+source+" target: %s"+ target);
		
	}

	public int edgeValue(int source, int target) {
		System.out.println("edgeValue...");
		return 0;
	}

	public void removeEdge(int source, int target) {
		System.out.println("removeEdge...");
		
	}

	public int size() {
		System.out.println("size...");
		return 0;
	}

	public int[] neighbors(int vertex) {
		System.out.println("neighbors...");
		return null;
	}

	
	
}