public class Node{
	// Variables
	private int element;
	private Node next;
	private Node prev;

	// Constructor taking just element
	public Node(int e){
		element = e;
		next = null;
		prev = null;
	}

	// Constructor taking element and links to next and previous nodes
	public Node(int e, Node n, Node p){
		element = e;
		next = n;
		prev = p;
	}

	// Returns the elemnet of the node
	public int getElement(){
		return element;
	}
	
	// Returns the next node
	public Node getNext(){
		return next;
	}

	// Returns the previous node
	public Node getPrev(){
		return prev;
	}

	// Sets or resets the next node
	public void setNext(Node n){
		next = n;
	}

	// Sets or resets the previous node
	public void setPrev(Node p){
		prev = p;
	}
}
