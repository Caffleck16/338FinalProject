package test;
import main.java.myLib.datastructures.linear.*;
import main.java.myLib.datastructures.nodes.*;
import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;
import java.io.*;

public class SLLTest{
    @Test
    public void testInsertHead() {
        SLL<Integer> sll = new SLL<>();
        Node<Integer> node1 = new Node<>(1);
        Node<Integer> node2 = new Node<>(2);
        sll.insertHead(node1);
        sll.insertHead(node2);
        assertEquals(node2, sll.getHead());
        assertEquals(node1, sll.getHead().getNext());
    }

    @Test
    public void testInsertTail() {
        SLL<Integer> sll = new SLL<>();
        Node<Integer> node1 = new Node<>(1);
        Node<Integer> node2 = new Node<>(2);
        sll.insertTail(node1);
        sll.insertTail(node2);
        assertEquals(node1, sll.getHead());
        assertEquals(node2, sll.getTail());
    }

    @Test
    public void testInsert() {
        SLL<Integer> sll = new SLL<>();
        Node<Integer> node1 = new Node<>(1);
        Node<Integer> node2 = new Node<>(2);
        Node<Integer> node3 = new Node<>(3);
        sll.insertHead(node1);
        sll.insert(node2, 1);
        sll.insert(node3, 2);
        assertEquals(node1, sll.getHead());
        assertEquals(node2, sll.getHead().getNext());
        assertEquals(node3, sll.getTail());
    }

    @Test
    public void testSortedInsert() {
        SLL<Integer> sll = new SLL<>();
        Node<Integer> node1 = new Node<>(1);
        Node<Integer> node2 = new Node<>(2);
        Node<Integer> node3 = new Node<>(3);
        sll.sortedInsert(node2);
        sll.sortedInsert(node1);
        sll.sortedInsert(node3);
        assertEquals(node1, sll.getHead());
        assertEquals(node2, sll.getHead().getNext());
        assertEquals(node3, sll.getTail());
    }

    @Test
    public void testSearch() {
        SLL<Integer> sll = new SLL<>();
        Node<Integer> node1 = new Node<>(1);
        Node<Integer> node2 = new Node<>(2);
        sll.insertHead(node1);
        sll.insertTail(node2);
        assertEquals(node1, sll.search(node1));
        assertEquals(node2, sll.search(node2));
        assertNull(sll.search(new Node<>(3)));
    }

    @Test
    public void testDeleteHead() {
        SLL<Integer> sll = new SLL<>();
        Node<Integer> node1 = new Node<>(1);
        Node<Integer> node2 = new Node<>(2);
        sll.insertHead(node1);
        sll.insertTail(node2);
        sll.deleteHead();
        assertEquals(node2, sll.getHead());
    }

    @Test
    public void testDeleteTail() {
        SLL<Integer> sll = new SLL<>();
        Node<Integer> node1 = new Node<>(1);
        Node<Integer> node2 = new Node<>(2);
        sll.insertHead(node1);
        sll.insertTail(node2);
        sll.deleteTail();
        assertEquals(node1, sll.getHead());
        assertNull(sll.getHead().getNext());
    }

    @Test
    public void testDelete() {
        SLL<Integer> sll = new SLL<>();
        Node<Integer> node1 = new Node<>(1);
        Node<Integer> node2 = new Node<>(2);
        sll.insertHead(node1);
        sll.insertTail(node2);
        sll.delete(node1);
        assertEquals(node2, sll.getHead());
        sll.delete(node2);
        assertNull(sll.getHead());
    }
    
    @Test
    public void testSort() {
        SLL<Integer> sll = new SLL<>();
        Node<Integer> node1 = new Node<>(1);
        Node<Integer> node2 = new Node<>(2);
        Node<Integer> node3 = new Node<>(3);
        sll.insertHead(node3);
        sll.insertHead(node1);
        sll.insertHead(node2);
        sll.sort();
        assertEquals(node1, sll.getHead());
        assertEquals(node2, sll.getHead().getNext());
        assertEquals(node3, sll.getTail());
    }
    
    @Test
    public void testClear() {
        SLL<Integer> sll = new SLL<>();
        Node<Integer> node1 = new Node<>(1);
        Node<Integer> node2 = new Node<>(2);
        sll.insertHead(node1);
        sll.insertTail(node2);
        sll.clear();
        assertNull(sll.getHead());
    }

    @Test (expected = IndexOutOfBoundsException.class)
public void testInsertAtEmptyList() {
    SLL<Integer> sll = new SLL<>();
    Node<Integer> node1 = new Node<>(1);
    sll.insert(node1, 1);
}

@Test (expected = IndexOutOfBoundsException.class)
public void testInsertAtInvalidPosition() {
    SLL<Integer> sll = new SLL<>();
    Node<Integer> node1 = new Node<>(1);
    sll.insertHead(node1);
    Node<Integer> node2 = new Node<>(2);
    sll.insert(node2, 3);
}

@Test
public void testSortedInsertAtEmptyList() {
    SLL<Integer> sll = new SLL<>();
    Node<Integer> node1 = new Node<>(1);
    sll.sortedInsert(node1);
    assertEquals(node1, sll.getHead());
    assertEquals(node1, sll.getTail());
}

@Test
public void testSortedInsertAtHead() {
    SLL<Integer> sll = new SLL<>();
    Node<Integer> node1 = new Node<>(4);
    Node<Integer> node2 = new Node<>(2);
    sll.insertHead(node1);
    sll.sortedInsert(node2);
    assertEquals(node2, sll.getHead());
    assertEquals(node1, sll.getTail());
}

@Test
public void testSortedInsertAtTail() {
    SLL<Integer> sll = new SLL<>();
    Node<Integer> node1 = new Node<>(1);
    Node<Integer> node2 = new Node<>(2);
    sll.insertHead(node1);
    sll.sortedInsert(node2);
    assertEquals(node1, sll.getHead());
    assertEquals(node2, sll.getTail());
}

@Test
public void testDeleteAtEmptyList() {
    SLL<Integer> sll = new SLL<>();
    Node<Integer> node1 = new Node<>(1);
    sll.delete(node1);
    assertNull(sll.getHead());
    assertNull(sll.getTail());
}

@Test
public void testDeleteHeadAtSingleItemList() {
    SLL<Integer> sll = new SLL<>();
    Node<Integer> node1 = new Node<>(1);
    sll.insertHead(node1);
    sll.deleteHead();
    assertNull(sll.getHead());
    assertNull(sll.getTail());
}

@Test
public void testDeleteTailAtSingleItemList() {
    SLL<Integer> sll = new SLL<>();
    Node<Integer> node1 = new Node<>(1);
    sll.insertHead(node1);
    sll.deleteTail();
    assertNull(sll.getHead());
    assertNull(sll.getTail());
}

@Test
public void testSortAtEmptyList() {
    SLL<Integer> sll = new SLL<>();
    sll.sort();
    assertNull(sll.getHead());
    assertNull(sll.getTail());
}

@Test
public void testClearAtEmptyList() {
    SLL<Integer> sll = new SLL<>();
    sll.clear();
    assertNull(sll.getHead());
    assertNull(sll.getTail());
}

@Test
public void testStringList() {
    SLL<String> list = new SLL<>();
    Node<String> node1 = new Node<>("hello");
    Node<String> node2 = new Node<>("world");
    Node<String> node3 = new Node<>("abc");
    Node<String> node4 = new Node<>("xyz");
    // test insert head
    list.insertHead(node1);
    assertEquals("hello", list.getHead().getData());

    // test insert tail
    list.insertTail(node2);
    assertEquals("world", list.getHead().getNext().getData());

    // test sorted insert
    list.sortedInsert(node3);
    assertEquals("abc", list.getHead().getData());

    list.sortedInsert(node4);
    assertEquals("xyz", list.getHead().getNext().getNext().getNext().getData());

    // test search
    Node<String> found = list.search(node1);
    assertNotNull(found);
    assertEquals("hello", found.getData());

    found = list.search(new Node<>("foo"));
    assertNull(found);

    // test delete
    list.delete(node2);
    assertEquals("abc", list.getHead().getData());
    assertEquals("hello", list.getHead().getNext().getData());

    // test sort
    list.insertHead(new Node<>("def"));
    list.insertHead(new Node<>("bcd"));
    list.sort();
    assertEquals("abc", list.getHead().getData());
    assertEquals("bcd", list.getHead().getNext().getData());
    assertEquals("def", list.getHead().getNext().getNext().getData());
    assertEquals("hello", list.getHead().getNext().getNext().getNext().getData());

    // test clear
    list.clear();
    assertNull(list.getHead());
}

    
}
