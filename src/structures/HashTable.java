package structures;

public class HashTable<K,V> implements HashTableOperations<K, V>{
	private HashTableLinkedList<K, V>[] shelf;
	private int size = 0;
	
	public HashTable(int s ) {
		shelf = (HashTableLinkedList<K, V>[]) new HashTableLinkedList[s];
		size = 0;
	}

	@Override
	public boolean insert(K k, V v) {
		int pos = hashFunction(k);
		if (shelf[pos] == null)
		{
			shelf[pos] = new HashTableLinkedList<K,V>();
		}
		boolean status = shelf[pos].add(k, v);
		if (status) size++;
		return status;
	}

	@Override
	public boolean remove(K k) {
		int pos = hashFunction(k);
		
		boolean status = false;
		
		if (shelf[pos] != null)
		{
			status = shelf[pos].remove(k);
		}
		
		if (status) size--;
		return status;
	}

	@Override
	public int size() {
		return size;
		
	}

	@Override
	public boolean modify(K k, V v) {
		boolean status = false;
		
		int pos = hashFunction(k);
		
		if (shelf[pos] != null)
		{
			status = shelf[pos].modify(k, v);
		}
		return status;
	}

	@Override
	public V search(K k) {
		
		V v = null;
		int pos = hashFunction(k);
		
		if (shelf[pos] != null)
		{
			v = shelf[pos].search(k);
		}
		return v;
	}

	@Override
	public boolean contains(K k) {
		if (search(k) != null)
		{
			return true;
		}
		return false;
	}
	
	
	private int hashFunction(K k)
	{
		String in = k.toString();
		
		int total = 0;
		
		for (int i = 0; i < in.length(); i++)
		{
			total += in.charAt(i);
		}
		
		int finalValue = total%shelf.length;
		
		return finalValue;
		
		
	}
}
