package structures;

public class Stack<T> {
	private StackNode<T> first;
	
	public Stack() {
		
	}
	
	public void push(T e) {
		StackNode<T> NewNode = new StackNode<>(e)
		if(first == null) {
			first = NewNode;
		} else {
			NewNode.setNext(first);
			first = NewNode;
		}
	}
	
	public T peek() {
		return first.getElement();
	}
	
	public void pop() {
		if(first != null) {
			first = first.getNext();
		} else {
			first = null;
		}
	}
}
