package com.coderscampus.arraylist;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CustomArrayListTest {
    private CustomArrayList<String> list;

    @BeforeEach
    public void setUp() {
        list = new CustomArrayList<>();
    }

    @Test
    public void testAddItem() {
        list.add("A");
        assertEquals(1, list.getSize());
        assertEquals("A", list.get(0));
    }

    @Test
    public void testAddAtIndexValid() {
        list.add("A");
        list.add("C");
        list.add(1, "B");
        assertEquals("B", list.get(1));
        assertEquals(3, list.getSize());
    }

    @Test
    public void testAddAtIndexNegativeThrowsException() {
        assertThrows(IndexOutOfBoundsException.class, () -> list.add(-1, "invalid"));
    }

    @Test
    public void testAddAtIndexBeyondSizeThrowsException() {
        list.add("A");
        assertThrows(IndexOutOfBoundsException.class, () -> list.add(2, "invalid"));
    }

    @Test
    public void testAddAtIndexEqualToSize() {
        list.add("A");
        list.add("B");
        list.add(2, "C");
        assertEquals("C", list.get(2));
        assertEquals(3, list.getSize());
    }


    @Test
    public void testGetValidIndex() {
        list.add("A");
        list.add("B");
        assertEquals("A", list.get(0));
        assertEquals("B", list.get(1));
    }

    @Test
    public void testGetFromEmptyListThrowsException() {
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(0));
    }

    @Test
    public void testGetNegativeIndexThrowsException() {
        list.add("A");
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(-1));
    }

    @Test
    public void testGetBeyondSizeThrowsException() {
        list.add("A");
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(1));
    }

    @Test
    public void testSize() {
        assertEquals(0, list.getSize());
        list.add("A");
        assertEquals(1, list.getSize());
    }

    @Test
    public void testAddTriggersResize() {
        for (int i = 0; i < 40; i++) {
            list.add("element" + i);
        }
        assertEquals(40, list.getSize());
        list.add("element40");
        assertEquals(41, list.getSize());
        assertEquals("element40", list.get(40));
    }

    @Test
    public void testRemoveValidIndex() {
        list.add("A");
        list.add("B");
        list.add("C");
        assertEquals("B", list.remove(1));
        assertEquals(2, list.getSize());
        assertEquals("A", list.get(0));
        assertEquals("C", list.get(1));
    }

    @Test
    public void testRemoveFromEmptyListThrowsException() {
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(0));
    }

    @Test
    public void testRemoveNegativeIndexThrowsException() {
        list.add("A");
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(-1));
    }

    @Test
    public void testRemoveBeyondSizeThrowsException() {
        list.add("A");
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(1));
    }

    @Test
    public void testRemoveLastItem() {
        list.add("A");
        list.add("B");
        assertEquals("B", list.remove(1));
        assertEquals(1, list.getSize());
        assertEquals("A", list.get(0));
    }
}
