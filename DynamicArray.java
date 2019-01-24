public class DynamicArray {
	int size;
	int[] data;
	private int max_size = 1; // size of data array
	
	public DynamicArray(){
		size = 0;
		data = new int[2];
		max_size = 2;
	}
	
	public int size() {
		return size;
	}

	// return element at the given index
	public int get(int index) {
		return data[index];
	}

	// add a remove method that removes last element
	public int remove() {
		size--; // :)
		return data[size];
	}

	// set method
	// replace element at index with new element
	public void set(int el, int index) {
		data[index] = el;
	}

	public void add(int el, int index) {

		// need to know when to resize!!!
		if (size >= max_size) {
			// if we are out of room
			// double the size of data

			int[] temp = new int[max_size * 2];

			// copy over the old stuff
			for (int i = 0; i < data.length; i++) {
				temp[i] = data[i];
			}
			data = temp; // data should not point to the bigger array ;D
			max_size *= 2;
		}

		// shift all elements starting at index to the right by 1
		for (int i = size - 1; i >= index; i--) {
			data[i + 1] = data[i]; // shift el at i to i+1
		}

		data[index] = el;
		size++;

	}

	// we have to allow users to add data...
	public void add(int element) {

		// need to know when to resize!!!
		if (size >= max_size) {
			// if we are out of room
			// double the size of data

			int[] temp = new int[max_size * 2];

			// copy over the old stuff
			for (int i = 0; i < data.length; i++) {
				temp[i] = data[i];
			}
			data = temp; // data should not point to the bigger array ;D
			max_size *= 2;
		}

		data[size] = element;
		// update ArrayList num elements
		size++;

	}

	/**
	 * return the last element. do not remove
	 * 
	 * @return
	 */
	public int getLast() {
		if(size<=0)return Integer.MAX_VALUE;
		
		return data[size-1];
	}

	/**
	 * Remove the element at the specified index. Elements to the right of the
	 * removed element should be shifted to the left. Element removed should be
	 * returned.
	 * 
	 * @param index
	 * @return element to be removed
	 */
	public int remove(int index) {
		size--;
		return data[size];

	}

}
