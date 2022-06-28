package day2.list;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LinkedListTest {
    @Test
    public void newListIsEmpty() {
        LinkedList list = new LinkedList();
        assertTrue(list.isEmpty());
        assertEquals(0, list.size());
    }

    @Test
    public void listWithContentIsNotEmpty() {
        LinkedList list = new LinkedList();
        list.add("abc");
        list.add("def");
        list.add("ghi");
        list.add("jkl");
        list.add("mno");
        assertFalse(list.isEmpty());
        assertEquals(5, list.size());
    }

    @Test
    public void canRetrieveFirstItem() {
        LinkedList list = new LinkedList();
        list.add("abc");
        assertEquals("abc", list.get(0));
    }

    @Test
    public void canRetrieveAllItems() {
        LinkedList list = new LinkedList();
        list.add("abc");
        list.add("def");
        list.add("ghi");
        list.add("jkl");
        list.add("mno");
        assertEquals("abc", list.get(0));
        assertEquals("def", list.get(1));
        assertEquals("ghi", list.get(2));
        assertEquals("jkl", list.get(3));
        assertEquals("mno", list.get(4));
    }
}
