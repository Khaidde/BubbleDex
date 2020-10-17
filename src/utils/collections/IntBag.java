package utils.collections;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.IntConsumer;

public class IntBag {
	
	private int size;
	private int[] data;
	
	public IntBag() {
		this(64);
	}
	
	public IntBag(int initialSize) {
		this.size = 0;
		this.data = new int[initialSize];
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
	
	public int get(int index) {
		return data[index];
	}
	
	public boolean contains(int item) {
		for (int i = 0; i < size; i++) {
			if (this.data[i] == item) return true;
		}
		return false;
	}
	
	public int indexOf(int item) {
		for (int i = 0; i < size; i++) {
			if (this.data[i] == item) return i;
		}
		return -1;
	}
	
	public void add(int item) {
		if (this.size >= this.data.length) assertSize(this.size + (this.size >>> 1) + 1);
		this.data[size++] = item;
	}
	
	public int removeIndex(int index) {
		int item = data[index];
		data[index] = data[size - 1];
		size--;
		data[size] = 0;
		return item;
	}
	
	public boolean remove(int item) {
		for (int i = 0; i < size; i++) {
			if (item == data[i]) {
				this.remove(i);
				return true;
			}
		}
		return false;
	}
	
	public int removeLast() {
		if (size > 0) {
			return this.removeIndex(size - 1);
		}
		return 0;
	}
	
	public void iterate(IntConsumer execute) {
		for (int i = 0; i < this.size; i++) {
			execute.accept(data[i]);
		}
	}
}
