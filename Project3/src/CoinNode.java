
public class CoinNode {
	private String state;
	private int v;
	private int parent;
	private boolean visited;
	
	public CoinNode(String nState){
		state = nState;
		v = 0; //initially, all the vertex number are set to 0.
	}
	
	public String getState(){
		return state;
	}
	
	public void setVisited(boolean v){
		visited = v;
	}
	
	public boolean getVisited(){
		return visited;
	}
	
	public int getVertexNumber(){
		return v;
	}
	
	public void setVertexNumber(int vertexNumber){
		v = vertexNumber;
	}
	
	public int getParent(){
		return parent;
	}
	
	public void setParent(int p){
		parent = p;
	}
	
	public String toString(){
		return state;
	}
}

