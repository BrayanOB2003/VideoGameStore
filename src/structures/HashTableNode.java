package structures;

public class HashTableNode <K,V>{
	private K key;
	private V value;
	private HashTableNode<K, V> next;
	
	
	public HashTableNode(K a, V b) {
		key = a;
		value = b;
	}
	
	
	public boolean isTheKey(K a)
	{
		if (((Comparable<K>) key).compareTo(a)==0)
		{
			return true;
		}
		return false;
	}
	
	
	public int compareTo(K k)
	{
		return ((Comparable<K>) key).compareTo(k);
	}

	public K getKey() {
		return key;
	}


	public void setKey(K key) {
		this.key = key;
	}


	public V getValue() {
		return value;
	}


	public void setValue(V value) {
		this.value = value;
	}


	public HashTableNode<K, V> getNext() {
		return next;
	}


	public void setNext(HashTableNode<K, V> next) {
		this.next = next;
	}
}
