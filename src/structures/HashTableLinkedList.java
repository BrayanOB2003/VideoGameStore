package structures;

public class HashTableLinkedList<K, V> {
	private HashTableNode<K, V> root; 
	private int size;
	
	public HashTableLinkedList() {
		root = null;
		size = 0;
	}

	public boolean add(K k, V v) {
		boolean status = false;
		if (search(k) == null)
		{
			if (root == null)
			{
				root = new HashTableNode<K,V>(k, v);
				status = true;
				size++;
			}else
			{
				HashTableNode<K, V> current = root;
				
				if (current.compareTo(k) ==0)
				{
					root = new HashTableNode<K,V>(k,v);
					root.setNext(current);
					size++;
					status = true;
				}else
				{
					while (current.getNext()!= null && !status )
					{
						if (current.getNext().compareTo(k) > 0)
						{
							HashTableNode<K,V> n = new HashTableNode<K,V>(k,v);
							n.setNext(current.getNext());
							current.setNext(n);
							size++;
							status = true;
						}else
						{
							current = current.getNext();
						}
					}
					
					if (!status)
					{
						current.setNext(new HashTableNode<K,V>(k, v));
						size++;
						status = true;
					}
				}
				
			}
		}
		return status;
	}
	
	public boolean remove(K k) {
		boolean status = false;
		
		if (root == null)
		{
			return false;
		}else
		{
			if (root.isTheKey(k))
			{
				if (root.getNext() == null)
				{
					root = null;
					
				}else
				{
					root = root.getNext();
				}
				size--;
				status = true;
			}else
			{
				HashTableNode<K, V> current = root;
				
				while (current.getNext() != null)
				{
					if (current.getNext().isTheKey(k))
					{
						current.setNext(current.getNext().getNext());
						size--;
						status = true;
					}else
					{
						current = current.getNext();
					}
				}
			}
		}
		
		return status;
	}

	public boolean isEmpty() {
		boolean status = false;
		if (size == 0)
		{
			status = true;
		}
		return status;
	}

	public int size() {
		
		return size;
	}

	public V search(K k) {
		V element = null;
		if (root == null)
		{
			return null;
		}else
		{
			HashTableNode<K, V> current = root;
			
			while (current != null && element == null)
			{
				if (current.isTheKey(k))
				{
					element = current.getValue();
				}else
				{
					if (current.getNext() == null) current = null;
					else current = current.getNext();
				}
			}
		}
		return element;
	}

	public HashTableNode<K, V> getRoot() {
		return root;
	}

	public void setRoot(HashTableNode<K, V> root) {
		this.root = root;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
	public boolean contains(K v){
		if(search(v)!=null) {
			return true;
		}else {
			return false;
		}
		
	}

	public boolean modify(K k,V v) {
		boolean status = false;
		if (root == null)
		{
			return false;
		}else
		{
			HashTableNode<K, V> current = root;
			
			while (current != null && !status)
			{
				if (current.isTheKey(k))
				{
					current.setValue(v);
					status = true;
				}else
				{
					if (current.getNext() == null)
					{
						return false;
					}else
					{
						current = current.getNext();
						
					}
				}
			}
		}
		return status;
	}
}
