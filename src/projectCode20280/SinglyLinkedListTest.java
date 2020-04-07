import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Junit Test cases for Singly Linked List.
 * Each test case name is scenario being teste
 */
public class SinglyLinkedListTest {

    // For exception handling scenarios
    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void testListIsEmpty() {
        SinglyLinkedList<String> temp = new SinglyLinkedList<>();
        assertTrue(temp.isEmpty());
        temp.addFirst("Ronit");
        assertFalse(temp.isEmpty());
    }

    @Test
    public void testGetOnEmptyList() {
        exception.expect(ListEmptyException.class);
        SinglyLinkedList<String> temp = new SinglyLinkedList<>();
        temp.get(0);
    }

    @Test
    public void testGetOnList() {
        SinglyLinkedList<String> temp = new SinglyLinkedList<>();
        temp.addFirst("Dahiya");
        temp.add(0,"Ronit");
        assertEquals(temp.get(0), "Ronit");
        assertEquals(temp.get(1),"Dahiya");
    }

    @Test
    public void testAddElementAtWrongIndex() {
        exception.expect(IndexOutOfBoundsException.class);
        SinglyLinkedList<String> temp = new SinglyLinkedList<>();
        temp.addFirst("Ronit");
        temp.add(1,"Dahiya");
    }

    @Test
    public void testAddElementAtRightIndex() {
        SinglyLinkedList<String> temp = new SinglyLinkedList<>();
        temp.addFirst("Dahiya");
        temp.add(0,"Ronit");
        temp.add(1,"Working");
        System.out.println(temp);
        assertEquals(temp.removeLast(), "Dahiya");
        assertEquals(temp.removeLast(), "Working");
    }

    @Test
    public void testRemoveAtWrongIndex() {
        exception.expect(IndexOutOfBoundsException.class);
        SinglyLinkedList<String> temp = new SinglyLinkedList<>();
        temp.addFirst("Ronit");
        temp.add(0,"Dahiya");
        temp.remove(2);
    }

    @Test
    public void testSize() {
        SinglyLinkedList<String> temp = new SinglyLinkedList<>();
        temp.addFirst("Ronit");
        temp.addFirst("Working");
        assertEquals(temp.size(), 2);
    }

    @Test
    public void testRemoveFirstForList() {
        SinglyLinkedList<String> temp = new SinglyLinkedList<>();
        temp.addFirst("Ronit");
        temp.addFirst("Working");
        temp.removeFirst();
        assertEquals(temp.get(0), "Ronit");
        assertEquals(temp.size(), 1);
    }

    @Test
    public void testRemoveFirstForEmptyList() {
        exception.expect(ListEmptyException.class);
        SinglyLinkedList<String> temp = new SinglyLinkedList<>();
        temp.removeFirst();
    }

    @Test
    public void testRemoveLastForList() {
        SinglyLinkedList<String> temp = new SinglyLinkedList<>();
        temp.addFirst("Ronit");
        temp.addFirst("Working");
        temp.removeLast();
        assertEquals(temp.get(0), "Working");
        assertEquals(temp.size(), 1);
    }

    @Test
    public void testRemoveLastForEmptyList() {
        exception.expect(ListEmptyException.class);
        SinglyLinkedList<String> temp = new SinglyLinkedList<>();
        temp.removeLast();
    }

    @Test
    public void testAddFirstForList() {
        SinglyLinkedList<String> temp = new SinglyLinkedList<>();
        temp.addFirst("Ronit");
        temp.addFirst("Working");
        assertEquals(temp.get(0), "Working");
        assertEquals(temp.get(1), "Ronit");
    }

    @Test
    public void testAddLastForList() {
        SinglyLinkedList<String> temp = new SinglyLinkedList<>();
        temp.addLast("Ronit");
        temp.addLast("Working");
        assertEquals(temp.get(0), "Ronit");
        assertEquals(temp.get(1), "Working");
    }

    @Test
    public void testToString() {
        SinglyLinkedList<String> temp = new SinglyLinkedList<>();
        temp.addLast("Ronit");
        temp.addLast("is");
        temp.addLast("Working");
        assertEquals(temp.toString(), "Ronit is Working");
    }
}