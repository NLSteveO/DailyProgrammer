import java.lang.StringBuilder;

public class LinkedList{

	private Node head;
	private int size = 0;

	public LinkedList(){}

	public void addNode(Node n){
		if (head == null){
			head = n;
		}
		else {
			head.setPrev(n);
			n.setNext(head);
			head = n;
		}
		size++;
	}

	public void addSortedNode(Node n){
		if (head == null){
			head = n;
		}
		else {
			Node temp = head;
			boolean looped = false;
			while(temp != null){
				if (n.getElement() <= temp.getElement()){
					n.setPrev(temp.getPrev());
					temp.setPrev(n);
					n.setNext(temp);
					if (looped){
						head = n;
					}
					break;
				}
				else {
					temp = temp.getNext();
					looped = true;
				}
			}
		}
		size++;
	}

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
		return temp;
	}

	public Node removeNode(int e){
		Node temp = head;
		if (!isEmpty()){
			while(temp.getNext() != null){
				if (temp.getElement() == e){
					Node temp2 = temp.getPrev();
					temp2.setNext(temp.getNext());
					temp.getNext().setPrev(temp2);
					break;
				}
				else {
					temp = temp.getNext();
				}
			}
			size--;
		}
		return temp;
	}

	public boolean isEmpty(){
		return size == 0;
	}

	public int size(){
		return size;
	}

	public String toString(){
		StringBuilder s = new StringBuilder();
		if (!isEmpty()){
			s.append(head.getElement());
			s.append("\n ");
			Node temp = head.getNext();
			while(temp !=  null){
				s.append(temp.getElement());
				s.append("\n ");
				temp = temp.getNext();
			}
		}
		return s.toString();
	}
}
