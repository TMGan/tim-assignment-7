package com.coderscampus.arraylist;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CustomArrayListTest {
    private CustomArrayList<String> list;

    @BeforeEach
    public void setUp() {
        list = new CustomArrayList<>();
    }

    // Test add(T item)
    @Test
    public void testAddItem() {
        assertTrue(list.add("A"));
        assertEquals(1, list.getSize());
        assertEquals("A", list.get(0));
    }

    @Test
    public void testAddTriggersResize() {
        for (int i = 0; i < 10; i++) {
            list.add("element" + i);
        }
        assertTrue(list.add("element10")); // Triggers resize
        assertEquals(11, list.getSize());
        assertEquals("element10", list.get(10));
    }

    // Test add(int index, T item)
    @Test
    public void testAddAtIndexBeginning() {
        list.add("B");
        assertTrue(list.add(0, "A"));
        assertEquals(2, list.getSize());
        assertEquals("A", list.get(0));
        assertEquals("B", list.get(1));
    }

    @Test
    public void testAddAtIndexMiddle() {
        list.add("A");
        list.add("C");
        assertTrue(list.add(1, "B"));
        assertEquals(3, list.getSize());
        assertEquals("B", list.get(1));
    }

    @Test
    public void testAddAtIndexEnd() {
        list.add("A");
        assertTrue(list.add(1, "B"));
        assertEquals(2, list.getSize());
        assertEquals("B", list.get(1));
    }

    @Test
    public void testAddAtIndexBeginningWithResize() {
        for (int i = 0; i < 10; i++) {
            list.add("element" + i);
        }
        assertTrue(list.add(0, "new")); // Triggers resize at beginning
        assertEquals(11, list.getSize());
        assertEquals("new", list.get(0));
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

    // Test getSize()
    @Test
    public void testSize() {
        assertEquals(0, list.getSize());
        list.add("A");
        assertEquals(1, list.getSize());
    }

    // Test get(int index)
    @Test
    public void testGetValidIndex() {
        list.add("A");
        assertEquals("A", list.get(0));
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

    // Test remove(int index)
    @Test
    public void testRemoveFromBeginning() {
        list.add("A");
        list.add("B");
        assertEquals("A", list.remove(0));
        assertEquals(1, list.getSize());
        assertEquals("B", list.get(0));
    }

    @Test
    public void testRemoveFromMiddle() {
        list.add("A");
        list.add("B");
        list.add("C");
        assertEquals("B", list.remove(1));
        assertEquals(2, list.getSize());
        assertEquals("C", list.get(1));
    }

    @Test
    public void testRemoveLastItem() {
        list.add("A");
        list.add("B");
        assertEquals("B", list.remove(1));
        assertEquals(1, list.getSize());
        assertEquals("A", list.get(0));
    }

    @Test
    public void testRemoveOnlyItem() {
        list.add("A");
        assertEquals("A", list.remove(0));
        assertEquals(0, list.getSize());
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
}





