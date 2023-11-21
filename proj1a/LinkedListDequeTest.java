import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class LinkedListDequeTest {
	private LinkedListDeque<Integer> deque;

	@Before
	public void setUp() {
		deque = new LinkedListDeque<>();
	}

	@Test
	public void testIsEmpty_NewDeque() {
		assertTrue(deque.isEmpty());
	}

	@Test
	public void testAddFirst() {
		deque.addFirst(1);
		assertFalse(deque.isEmpty());
		assertEquals(1, deque.size());
		assertEquals(Integer.valueOf(1), deque.removeFirst());
	}

	@Test
	public void testAddLast() {
		deque.addLast(1);
		assertFalse(deque.isEmpty());
		assertEquals(1, deque.size());
		assertEquals(Integer.valueOf(1), deque.removeLast());
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
	public void testRemoveFirst() {
		deque.addFirst(1);
		deque.addLast(2);
		assertEquals(Integer.valueOf(1), deque.removeFirst());
		assertEquals(1, deque.size());
	}

	@Test
	public void testRemoveLast() {
		deque.addFirst(1);
		deque.addLast(2);
		assertEquals(Integer.valueOf(2), deque.removeLast());
		assertEquals(1, deque.size());
	}

	@Test
	public void testGet() {
		deque.addFirst(1);
		deque.addLast(2);
		assertEquals(Integer.valueOf(1), deque.get(0));
		assertEquals(Integer.valueOf(2), deque.get(1));
	}

	@Test
	public void testGetRecursive() {
		deque.addFirst(1);
		deque.addLast(2);
		assertEquals(Integer.valueOf(1), deque.getRecursive(0));
		assertEquals(Integer.valueOf(2), deque.getRecursive(1));
	}

	@Test
	public void testRemoveFromEmpty() {
		assertNull(deque.removeFirst());
		assertNull(deque.removeLast());
	}

	@Test
	public void testGetFromEmpty() {
		assertNull(deque.get(0));
		assertNull(deque.getRecursive(0));
	}

	@Test
	public void testAddRemoveCombinations() {
		deque.addFirst(1);
		deque.addLast(2);
		deque.addFirst(3);
		assertEquals(Integer.valueOf(3), deque.removeFirst());
		assertEquals(Integer.valueOf(2), deque.removeLast());
		assertEquals(Integer.valueOf(1), deque.removeFirst());
		assertTrue(deque.isEmpty());
	}
}
