package structures;

public class Queue<T> implements basicOperations<T>{
	private QueueNode<T> first;
	private int size;
	
	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public Queue() {
		
	}
	
	@Override
	public void add(T e) {
		QueueNode<T> newNode = new QueueNode<T>(e);
		
		if(first == null) {
			first = newNode;
			size++;
		} else {
			addElement(first, newNode);
			size++;
		}
	}
	
	private void addElement(QueueNode<T> current, QueueNode<T> newElement) {
		if(current.getNext() == null) {
			current.setNext(newElement);
		}else {
			addElement(current.getNext(), newElement);
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
				first = first.getNext();
				size--;
			} else {
				first = null;
			} 
		}
	}
	
	@Override
	public String toString() {
		
		String output="";
		
		QueueNode<T> tmp = this.first;
		
		while (tmp!=null) {
			output+=tmp.getElement() + " ";
			tmp=tmp.getNext();
		}
		
		output = output.trim();
		
		return output;
		
	}

	
}
