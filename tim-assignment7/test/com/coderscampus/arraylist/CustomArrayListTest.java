package com.coderscampus.arraylist;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CustomArrayListTest<T> {

	@Test
	public void testAddItem() {
		CustomArrayList<String> list = new CustomArrayList<>();
		list.add("element");
		
		assertEquals(1, list.getSize());
		assertEquals("element", list.get(0));
	}
	
	@Test
	public void testAddItemAtIndex() {
		CustomArrayList<String> list = new CustomArrayList<>();
		list.add("hat");
		list.add("coat");
		
		list.add(1, "shoes");
		
		assertEquals("shoes", list.get(1));
		assertEquals(3, list.getSize());
	}
	
	@Test
	public void testGetSize() {
		CustomArrayList<String> list = new CustomArrayList<>();
		
		list.add("car");
		list.add("boat");
		list.add("plane");
		
		assertEquals(3, list.getSize());
		
		list.add("helicopter");
		
		assertEquals(4, list.getSize());
	}
	
	@Test
	public void testGet() {
		CustomArrayList<String> list = new CustomArrayList<>();
		list.add("one");
		list.add("two");
		list.add("three");
		
		assertEquals("one", list.get(0));
		assertEquals("two", list.get(1));
		assertEquals("three", list.get(2));
	}
	
	@Test
	public void testRemove() {
		CustomArrayList<String> list = new CustomArrayList<>();
		list.add("car");
		list.add("plane");
		list.add("boat");
		
		assertEquals("car", list.remove(0));
		assertEquals(2, list.getSize());
	}
}
