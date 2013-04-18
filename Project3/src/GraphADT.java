
/*Code Units Given to You
In this section, we will give you some finished 
code to help you get started.  You are to use these 
codes as they are.  If you find that you have to modify 
substantial portion of code, you probably in the wrong track.
One help class that you will need and is not given here is 
the Queue<T> class.  The Queue<T> class code is 
in the week 11 lecture notes.*/

public interface GraphADT<T> {
    public void  newNode(int vertex, T newNode);
    public T getNode(int vertex);
    public void addEdge(int source, int target);
    public int edgeValue(int source, int target);
    public void removeEdge(int source, int target);
    public  int  size();
    public int[] neighbors(int vertex);
    public  String toString();
}
