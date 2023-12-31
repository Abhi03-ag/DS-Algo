public class DynamicArray<T> implements Iterable<T> {
	private int len = 0;
	private T[] arr;
	private int capacity;
// Public constructor for the dynamic array
	public DynamicArray() {
		this(16);
	}

	public DynamicArray(int capacity) {
		if (capacity < 0) throw new IllegalArgumentException("Illegal,Capacity:" + capacity);
		this.capacity = capacity;
		arr = (T[]) new Object[capacity];
	}

	public int size() {
		return len;
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	public T get(int index) {
		if (index < 0 || index >= len) throw new IndexOutOfBoundsException();
		return arr[index];

	}

	public void set(int index, T element) {
		if (index < 0 || index >= len) throw new IndexOutOfBoundsException();
		arr[index] = element;
	}

	public void clear() {
		for (int i = 0; i < len; i++)
			arr[i] = null;
		len = 0;
	}

	public void add(T element) {
		if (len + 1 >= capacity) {
			if (capacity == 0)
				capacity = 1;
			else
				capacity *= 2;

			T[] new_arr = (T[]) new Object[capacity];
			for (int i = 0; i < len; i++) {
				new_arr[i] = arr[i];
			}
		}
		arr[len++] = element;

	}

	public T removeAt(int index) {
		if (index < 0 || index >= len)
			throw new IndexOutOfBoundsException();
		T data = arr[index];
		T[] new_arr = (T[]) new Object[len - 1];

		for (int i = 0, j = 0; i < len && j < len; i++, j++) {
			if (i == index)
				j--;
			new_arr[j] = arr[i];
		}
		capacity = len - 1;
		return data;
	}

	public int indexOf(Object obj) {
		for (int i = 0; i < len; i++) {
			if (obj == null) {
				if (arr[i] == null)
					return i;
			} else {
				if (obj.equals(arr[i]))
					return i;
			}
		}
		return -1;
	}

	public boolean remove(Object obj) {
		int index = indexOf(obj);
		if (index == -1) {
			return false;
		}
		removeAt(index);
		return true;
	}

	public boolean contains(Object obj) {
		return indexOf(obj) != -1;
	}


	@Override
	public java.util.Iterator<T> iterator() {
		return new java.util.Iterator<T>() {
			int index = 0;

			@Override
			public boolean hasNext() {
				return index < len;
			}

			@Override
			public T next() {
				return arr[index++];
			}

			@Override
			public void remove() {
				throw new UnsupportedOperationException();
			}

		};

	}

	@Override
	public String toString() {
		if (size() == 0)
			return "[]";

		StringBuilder sb = new StringBuilder(len);
		sb.append("[");
		for (int i = 0; i < len - 1; i++) {
			sb.append(arr[i] + ",");
		}

		return sb.append(arr[len] + "]").toString();
	}

}