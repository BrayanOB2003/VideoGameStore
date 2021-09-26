package structures;

public class Queue<T> implements basicOperations<T>{
	private QueueNode<T> first;
	
	public Queue() {
		
	}
	
	@Override
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
	
	@Override
	public T peek() {
		if (first != null) {
			return first.getElement();
		} else {
			return null;
		}
	}

	@Override
	public void pop() {
		if (first != null) {
			if (first.getNext() != null) {
				first.setNext(first.getNext());
			} else {
				first = null;
			} 
		}
	}
}
