package structures;

public class Stack<T> implements basicOperations<T>{
	private StackNode<T> first;
	private int size;
	
	public Stack() {
		
	}
	
	public T peek() {
		return first.getElement();
	}
	
	@Override
	public T pop() {
		T e = null;
		if(first != null) {
			
			if(first.getNext()!=null) {
				e = first.getElement();
				first = first.getNext();
			}	
			
		} else {
			first = null;
		}
		
		return e;
	}

	@Override
	public void add(T e) {
		StackNode<T> NewNode = new StackNode<>(e);
				if(first == null) {
					first = NewNode;
					size++;
				} else {
					NewNode.setNext(first);
					first = NewNode;
					size++;
				}
	}
	
	@Override
	public String toString() {
		
		String output="";
		
		StackNode<T> tmp = this.first;
		if(first != null) {
			output = toString(tmp, output);
		}
		
		return output;
	}
	
	private String toString(StackNode<T> current ,String cd) {
		if(current != null) {
			cd += " " + current;
			return toString(current.getNext(), cd);
		} else {
			return cd;
		}
	}
	
	public int getSize() {
		return size;
	}

	
}
