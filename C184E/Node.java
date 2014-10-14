

public class Node{
	private int element;
	private Node next;
	private Node prev;

	public Node(int e){
		element = e;
	}

	public Node(int e, Node n, Node p){
		element = e;
		next = n;
		prev = p;
	}

	public int getElement(){
		return element;
	}

	public Node getNext(){
		return next;
	}

	public Node getPrev(){
		return prev;
	}

	public void setNext(Node n){
		next = n;
	}

	public void setPrev(Node p){
		prev = p;
	}
}
