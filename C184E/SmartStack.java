import java.lang.StringBuilder;
import java.util.ArrayList;
import java.util.Collections;

public class SmartStack{
	
	private LinkedList stack;
	private LinkedList order;

	public SmartStack(){
		stack = new LinkedList();
		order = new LinkedList();
	}

	public void push(int e){
		Node n = new Node(e);
		stack.addNode(n);
		order.addSortedNode(n);
	}

	public Node pop(){
		Node n = stack.removeNode();
		order.removeNode(n.getElement());
		return n;
	}

	public int size(){
		return stack.size();
	}

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

	public String displayStack(){
		return stack.toString();
	}

	public String displayOrdered(){
		/**ArrayList<Integer> list = new ArrayList<Integer>();
		while (!stack.isEmpty()){
			list.add(stack.removeNode().getElement());
		}
		Collections.sort(list);
		StringBuilder s = new StringBuilder();
		while (list.size() != 0){
			s.append(list.remove(0));
		}
		return s.toString();*/
		return order.toString();
	}
}
