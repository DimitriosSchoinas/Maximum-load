
public class InvIterator {

	private String[] itemNames;
	private int size;
	private int nextIndex;

	public InvIterator(String[] itemNames, int size) {
		this.size = size;
		this.itemNames = itemNames;
		nextIndex = 0;
	}
	
	public boolean hasNext() {
		return size > nextIndex;
	}

	public String next() {
		return itemNames[nextIndex++];
	}
}
