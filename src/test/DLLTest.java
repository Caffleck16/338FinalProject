package test;

import org.junit.Test;
import static org.junit.Assert.*;
import main.java.myLib.datastructures.linear.*;
import main.java.myLib.datastructures.nodes.*;

public class DLLTest {

    @Test
    public void testInsertHead() {
        DLL<String> dll = new DLL<String>();
        dll.insertHead(new DNode<String>("apple"));
        dll.insertHead(new DNode<String>("banana"));
        assertEquals("banana", dll.getHead().getData());
        assertEquals("banana", dll.getTail().getPrevious().getData());
        assertNull(dll.getHead().getPrevious());
    }

    @Test
    public void testInsertTail() {
        DLL<String> dll = new DLL<String>();
        dll.insertTail(new DNode<String>("apple"));
        dll.insertTail(new DNode<String>("banana"));
        assertEquals("banana", dll.getTail().getData());
        assertNull(dll.getTail().getNext());
    }

    @Test
    public void testInsert() {
        DLL<String> dll = new DLL<String>();
        dll.insertHead(new DNode<String>("apple"));
        dll.insertTail(new DNode<String>("banana"));
        dll.insert(new DNode<String>("carrot"), 1);
        assertEquals("carrot", dll.getHead().getNext().getData());
        assertEquals("carrot", dll.getTail().getPrevious().getData());
    }

    @Test
    public void testSortedInsert() {
        DLL<Integer> dll = new DLL<Integer>();
        DNode<Integer> node1 = new DNode<>(3);
        DNode<Integer> node2 = new DNode<>(1);
        DNode<Integer> node3 = new DNode<>(2);
        dll.sortedInsert(node1);
        dll.sortedInsert(node2);
        dll.sortedInsert(node3);
        assertEquals(node2, dll.getHead());
        assertEquals(node3, dll.getHead().getNext());
        assertEquals(node1, dll.getTail());
        assertEquals(node3, dll.getTail().getPrevious());
        assertTrue(dll.isSorted());
    }

    @Test
    public void testSearch() {
        DLL<String> dll = new DLL<>();
        DNode<String> node1 = new DNode<>("apple");
        dll.insertHead(node1);
        dll.insertTail(new DNode<String>("banana"));
        assertEquals("apple", dll.search(node1).getData());
    }

    @Test
    public void testDeleteHead() {
        DLL<String> dll = new DLL<String>();
        dll.insertHead(new DNode<String>("apple"));
        dll.insertTail(new DNode<String>("banana"));
        dll.deleteHead();
        assertEquals("banana", dll.getHead().getData());
        assertNull(dll.getHead().getPrevious());
    }

    @Test
    public void testDeleteTail() {
        DLL<String> dll = new DLL<String>();
        dll.insertHead(new DNode<String>("apple"));
        dll.insertTail(new DNode<String>("banana"));
        dll.deleteTail();
        assertEquals("apple", dll.getTail().getData());
    }

    @Test
    public void testDelete() {
        DLL<String> dll = new DLL<String>();
        DNode<String> node1 = new DNode<>("banana");
        dll.insertHead(new DNode<String>("apple"));
        dll.insertTail(node1);
        dll.delete(node1);
        assertNull(dll.search(node1));
        assertEquals("apple", dll.getHead().getData());
        assertNull(dll.getHead().getNext());
    }

    @Test
    public void testSort() {
        DLL<Integer> dll = new DLL<Integer>();
        DNode<Integer> node1 = new DNode<Integer>(3);
        DNode<Integer> node2 = new DNode<Integer>(1);
        DNode<Integer> node3 = new DNode<Integer>(2);
        dll.insertHead(node1);
        dll.insertHead(node2);
        dll.insertHead(node3);
        dll.sort();
        assertEquals(node2, dll.getHead());
        assertEquals(node3, dll.getHead().getNext());
        assertEquals(node3, dll.getTail().getPrevious());
        assertEquals(node1, dll.getTail());
        assertNull(dll.getHead().getPrevious());
        assertNull(dll.getTail().getNext());
        assertTrue(dll.isSorted());
    }

    @Test
    public void testClear() {
        DLL<String> dll = new DLL<String>();
        dll.insertHead(new DNode<String>("apple"));
        dll.insertTail(new DNode<String>("banana"));
        dll.clear();
        assertEquals(null, dll.getHead());
    }

    @Test
    public void isSortedFalseTest(){
        DLL<Integer> dll = new DLL<>();
        DNode<Integer> node1 = new DNode<>(10);
        DNode<Integer> node2 = new DNode<>(20);
        dll.insertHead(node1);
        dll.insertHead(node2);
        assertFalse(dll.isSorted());
    }

    @Test
    public void testEmptyList() {
        DLL<Integer> list = new DLL<>();
        assertEquals(0, list.getSize());
        assertNull(list.getHead());
        assertNull(list.getTail());
        assertTrue(list.isSorted());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testInsertAtPositionGreaterThanSize() {
        DLL<Integer> list = new DLL<>();
        DNode<Integer> node = new DNode<>(5);
        list.insert(node, 1);
    }

    @Test
    public void testInsertAtPosition0() {
        DLL<Integer> list = new DLL<>();
        DNode<Integer> node1 = new DNode<>(5);
        DNode<Integer> node2 = new DNode<>(10);
        list.insertHead(node1);
        list.insert(node2, 0);
        assertEquals(2, list.getSize());
        assertEquals(node2, list.getHead());
        assertEquals(node1, list.getTail());
        assertFalse(list.isSorted());
    }
        

}
