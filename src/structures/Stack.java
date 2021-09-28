package structures;

public class Stack<T> implements basicOperations<T>{
	private StackNode<T> first;
	
	public Stack() {
		
	}
	
	public T peek() {
		return first.getElement();
	}
	
	@Override
	public void pop() {
		if(first != null) {
			first = first.getNext();
		} else {
			first = null;
		}
	}

	@Override
	public void add(T e) {
		StackNode<T> NewNode = new StackNode<>(e);
				if(first == null) {
					first = NewNode;
				} else {
					NewNode.setNext(first);
					first = NewNode;
				}
	}

	
}
