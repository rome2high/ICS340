public interface BinaryTreeADT {

 BTNode root();

 boolean isEmpty();

 int size();

 boolean isRoot(BTNode v);

 boolean hasParent(BTNode v);

 BTNode parent(BTNode v);

 boolean isLeaf(BTNode v);

 boolean hasLeft(BTNode v);

 BTNode left(BTNode v);

 boolean hasRight(BTNode v);

 BTNode right(BTNode v);

 void addNode(int value);

}