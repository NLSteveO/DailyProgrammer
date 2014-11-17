// Import classes
import java.lang.StringBuilder;
import java.util.ArrayList;

public class LinkedList{

    // Variables
	private Node head;
	private ArrayList<Integer> order;
	private int size = 0;

    // Constructor and sorted list initialization
	public LinkedList(){
	    order = new ArrayList<Integer>();
	}

    // Adds Node to the head of the LinkedList
	public void addNode(Node n){
		if (head == null){
			head = n;
		}
		else {
			head.setPrev(n);
			n.setNext(head);
			head = n;
		}
		order.add(n.getElement());
		size++;
		sort();
	}
	
	public void sort(){
	    for(int i=size-1; i>0; i--){
	        if (order.get(i) < order.get(i-1)){
	            int temp = order.get(i);
	            order.set(i, order.get(i-1));
	            order.set(i-1, temp);
	        }
	    }
	}

    // Removes Node from the head of LinkedList
	public Node removeNode(){
		Node temp = head;
		if (size() > 1){
			head = head.getNext();
			head.setPrev(null);
			size--;
		}
		else if (size() == 1){
			head = null;
			size--;
		}
		order.remove((Integer)temp.getElement());
		return temp;
	}

    // Checks if the LinkedList is empty
	public boolean isEmpty(){
		return (size == 0);
	}

    // Returns the size of the LinkedList
	public int size(){
		return size;
	}
	
	// Returns the sorted LinkedList in the form of a String
	public String sortedToString(){
	    StringBuilder s = new StringBuilder();
	    if (!isEmpty()){
	        for(int i=0; i<size; i++){
	            s.append(order.get(i));
	            if (i<size-1){
    	            s.append(", ");
    	        }
	        }
	    }
	    return s.toString();
	}

    // Returns the LinkedList in the form of a String
	public String toString(){
		StringBuilder s = new StringBuilder();
		if (size != 0){
			s.append(head.getElement());
			Node temp = head.getNext();
			for (int i=0; i<size-1; i++){
	            if (i<size-1){
    	            s.append(", ");
    	        }
				s.append(temp.getElement());
				temp = temp.getNext();
			}
		}
		return s.toString();
	}
}
