package structures;

public class StackNode<T> {
	private T element;
	private StackNode<T> next;
	
	public StackNode(T e) {
		element = e;
	}
	
	public T getElement() {
		return element;
	}
	
	public void setElement(T e) {
		element = e;
	}

	public StackNode<T> getNext() {
		return next;
	}

	public void setNext(StackNode<T> next) {
		this.next = next;
	}
}
