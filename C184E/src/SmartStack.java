// Import classes
import java.lang.StringBuilder;
import java.util.ArrayList;
import java.util.Collections;

public class SmartStack{
	
	// Variables
	private LinkedList stack;

    // Constructor which creates the new stack
	public SmartStack(){
		stack = new LinkedList();
	}

    // Pushes new Node onto the Stack
	public void push(int e){
		Node n = new Node(e);
		stack.addNode(n);
	}

    // Pops top Node off of the Stack and returns it
	public Node pop(){
		Node n = stack.removeNode();
		return n;
	}

    // Returns the size of the Stack
	public int size(){
		return stack.size();
	}
	
	// Returns whether the stack is empty or not
	public boolean isEmpty(){
	    return stack.isEmpty();
	}

    // Removes all numbers greater than given num from the stack 
	public void removeGreater(int num){
		LinkedList temp = new LinkedList();
		while(!stack.isEmpty()){
			Node n = stack.removeNode();
			if (n.getElement() < num){
				temp.addNode(n);
			}
		}
		while(!temp.isEmpty()){
			stack.addNode(temp.removeNode());
		}
	}

    // Returns the Stack as a String
	public String displayStack(){
		return stack.toString();
	}

    // Returns the ordered stack as a String 
	public String displayOrdered(){
		return stack.sortedToString();
	}
}
