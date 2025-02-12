package com.coderscampus.arraylist;

import java.util.Arrays;

public class CustomArrayList<T> implements CustomList<T> {
	Object[] items = new Object[10];
	
	private Integer size=0;
	

	@Override
	public boolean add(T item) {
	if(size == items.length) {
		resize();
	}
		items[size] = item;
		size++;
		return true;
		
	}

	@Override
	public boolean add(int index, T item) throws IndexOutOfBoundsException {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
		}
		if (size == items.length) {
			resize();
		}

		for (int i = size; i > index; i--) {
			items[i] = items[i - 1];
		}
		items[index] = item;
		size++;
		return true;
	}

	@Override
	public int getSize() {
		
		return size;
	}

	
	
	@Override
	public T get(int index) {
		if (index <0 || index >= size) {
			throw new IndexOutOfBoundsException("Index: "+ index+ ", Size: "+size);
		} return(T) items[index];
		}
	
	
	@Override
	public T remove(int index) {
		if (index < 0 || index >=size) {
			throw new IndexOutOfBoundsException("Index: "+ index);
		}
		T item = (T) items[index];
		
		for(int i = index; i < size -1; i++) {
			items[i] = items[i+1];
		}
		size--;
		return item;
		
	}
	private void resize() {
		Object[] newArray=new Object[items.length*2];
		System.arraycopy(items, 0, newArray, 0, items.length);
		items=newArray;
	}
}

