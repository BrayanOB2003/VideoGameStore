package structures;

public class QueueNode<T> {
	private T element;
	private QueueNode<T> next;
	
	public QueueNode(T e) {
		element = e;
	}

	public T getElement() {
		return element;
	}

	public void setElement(T element) {
		this.element = element;
	}

	public QueueNode<T> getNext() {
		return next;
	}

	public void setNext(QueueNode<T> next) {
		this.next = next;
	}
}
