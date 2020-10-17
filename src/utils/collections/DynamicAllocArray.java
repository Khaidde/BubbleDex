package utils.collections;

import java.util.Arrays;

public class DynamicAllocArray<T> {
	
	private int maxSize;
	private int activeSize;
	private T[] data;
	
	private int totalRemovedIDs = 0;
	private int[] removedIDs;
	
	public DynamicAllocArray() {
		this(64);
	}
	
	@SuppressWarnings("unchecked")
	public DynamicAllocArray(int initialSize) {
		this.data = (T[]) new Object[initialSize];
		this.removedIDs = new int[initialSize];
	}
	
	public boolean isEmpty() {
		return this.activeSize == 0;
	}
	
	public int size() {
		return activeSize;
	}
	
	private int getAllocationID() {
		if (totalRemovedIDs > 0) {
			totalRemovedIDs--;
			return removedIDs[totalRemovedIDs];
		} else {
			return this.activeSize;
		}
	}
	
	private void set(int id, T object) {
		if (id >= this.data.length) this.data = Arrays.copyOf(this.data, id + (id >>> 1) + 1);
		this.data[id] = object;
		this.activeSize++;
		if (this.activeSize > this.maxSize) this.maxSize = this.activeSize;
	}
	
	public int allocate(T object) {
		int id = this.getAllocationID();
		this.set(id, object);
		return id;
	}
	
	public void remove(int id) {
		if (this.data[id] == null) return;
		this.data[id] = null;
		this.activeSize--;
		
		if (totalRemovedIDs >= this.removedIDs.length) {
			this.removedIDs = Arrays.copyOf(this.removedIDs, totalRemovedIDs + (totalRemovedIDs >>> 1) + 1);
		}
		this.removedIDs[totalRemovedIDs] = id;
		totalRemovedIDs++;
	}
	
	public T get(int id) {
		return data[id];
	}
	
	public void clear() {
		Arrays.fill(data, 0, data.length, null);
		this.activeSize = 0;
		this.maxSize = 0;
		
		Arrays.fill(removedIDs, 0, removedIDs.length, 0);
		this.totalRemovedIDs = 0;
	}
	
}
