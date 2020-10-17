package utils.collections;

import java.util.Arrays;
import java.util.function.Consumer;

public class Bag<T> {
	
	private int size;
	private T[] data;
	
	public Bag() {
		this(64);
	}
	
	@SuppressWarnings("unchecked")
	public Bag(int initialSize) {
		this.size = 0;
		this.data = (T[]) new Object[initialSize];
	}
	
	private void assertSize(int newSize) {
		this.data = Arrays.copyOf(this.data, newSize);
	}
	
	public int size() {
		return size;
	}
	
	public int getCapacity() {
		return this.data.length;
	}
	
	public T fastGet(int index) {
		return data[index];
	}
	
	public T get(int index) {
		if (index >= this.data.length) return null;
		return fastGet(index);
	}

	public boolean contains(T value) {
		for (int i = 0; i < size; i++) {
			if (this.data[i].equals(value)) return true;
		}
		return false;
	}
	
	public int indexOf(T value) {
		for (int i = 0; i < size; i++) {
			if (this.data[i].equals(value)) return i;
		}
		return -1;
	}
	
	public void add(T item) {
		if (this.size >= this.data.length) assertSize(this.size + (this.size >>> 1) + 1);
		this.data[size++] = item;
	}
	
	public T remove(int index) {
		T item = data[index];
		data[index] = data[--size];
		data[size] = null;
		return item;
	}
	
	public boolean remove(T item) {
		for (int i = 0; i < size; i++) {
			if (item.equals(data[i])) {
				this.remove(i);
				return true;
			}
		}
		return false;
	}
	
	public T removeLast() {
		if (size > 0) {
			return this.remove(size - 1);
		}
		return null;
	}
	
	public void clear() {
		Arrays.fill(data, 0, size, null);
		this.size = 0;
	}
	
	public void iterate(Consumer<T> execute) {
		for (int i = 0; i < this.size; i++) {
			execute.accept(data[i]);
		}
	}
	
}
