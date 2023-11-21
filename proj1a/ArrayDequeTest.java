import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ArrayDequeTest {
    private ArrayDeque<Integer> deque;

    @Before
    public void setUp() {
        deque = new ArrayDeque<>();
    }

    @Test
    public void testIsEmpty_NewDeque() {
        assertTrue(deque.isEmpty());
    }

    @Test
    public void testAddFirstAndRemoveFirst() {
        deque.addFirst(1);
        assertFalse(deque.isEmpty());
        assertEquals(1, deque.size());
        assertEquals(Integer.valueOf(1), deque.removeFirst());
        assertTrue(deque.isEmpty());
    }

    @Test
    public void testAddLastAndRemoveLast() {
        deque.addLast(2);
        assertFalse(deque.isEmpty());
        assertEquals(1, deque.size());
        assertEquals(Integer.valueOf(2), deque.removeLast());
        assertTrue(deque.isEmpty());
    }

    @Test
    public void testSize() {
        assertEquals(0, deque.size());
        deque.addFirst(1);
        assertEquals(1, deque.size());
        deque.addLast(2);
        assertEquals(2, deque.size());
    }

    @Test
    public void testGet() {
        deque.addFirst(1);
        deque.addLast(2);
        assertEquals(Integer.valueOf(1), deque.get(0));
        assertEquals(Integer.valueOf(2), deque.get(1));
    }

    @Test
    public void testResizeUp() {
        for (int i = 0; i < 10; i++) {
            deque.addLast(i);
        }
        assertEquals(10, deque.size());
        for (int i = 0; i < 10; i++) {
            assertEquals(Integer.valueOf(i), deque.get(i));
        }
    }

    @Test
    public void testResizeDown() {
        for (int i = 0; i < 10; i++) {
            deque.addLast(i);
        }
        for (int i = 0; i < 8; i++) {
            deque.removeFirst();
        }
        assertEquals(2, deque.size());
    }

    @Test
    public void testRemoveFromEmpty() {
        assertNull(deque.removeFirst());
        assertNull(deque.removeLast());
    }

    @Test
    public void testAddRemoveCombinations() {
        deque.addFirst(1);
        deque.addLast(2);
        assertEquals(Integer.valueOf(1), deque.removeFirst());
        assertEquals(Integer.valueOf(2), deque.removeLast());
        assertTrue(deque.isEmpty());
    }
}
