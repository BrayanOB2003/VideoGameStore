package structures;

public class Queue<T> {
	private QueueNode<T> first;
	
	public Queue() {
		
	}
	
	public void add(T e) {
		QueueNode<T> newNode = new QueueNode<T>(e);
		
		if(first != null) {
			first = newNode;
		} else {
			addElement(first, newNode);
		}
	}
	
	private void addElement(QueueNode<T> current, QueueNode<T> newElement) {
		if(current.getNext() == null) {
			current.setNext(newElement);
		}
	}
	
	public void dequeue() {
		if (first != null) {
			if (first.getNext() != null) {
				first.setNext(first.getNext());
			} else {
				first = null;
			} 
		}
	}
	
	public T peek() {
		return first.getElement();
	}
}
