package mylib.datastructures;
import org.junit.Test;
import static org.junit.Assert.*;
import mylib.datastructures.linear.*;
import mylib.datastructures.nodes.*;

/*
 * Most boundary cases were already tested in DLLTest, so this will just cover basic functionality, as CDLL
 * uses the same methods as DLL.
 */
public class CDLLTest {
    @Test
    public void testConstructorIsSelfReferential(){
        DNode<Integer> node1 = new DNode<>(1);
        CDLL<Integer> cdll = new CDLL<>(node1);
        assertEquals(node1, cdll.getHead());
        assertEquals(node1, cdll.getHead().getNext());
        assertEquals(node1, cdll.getHead().getPrevious());
    }
    
    @Test
    public void testInsertHead() {
        CDLL<String> cdll = new CDLL<String>();
        DNode<String> node1 =  new DNode<>("apple");
        DNode<String> node2 = new DNode<>("banana");
        cdll.insertHead(node1);
        cdll.insertHead(node2);
        assertEquals(node2, cdll.getHead());
        assertEquals(node2, cdll.getTail().getPrevious());
        assertEquals(node1, cdll.getHead().getPrevious());
        assertEquals(node2, cdll.getTail().getNext());
    }

    @Test
    public void testInsertHeadIsSelfReferential() {
        CDLL<String> cdll = new CDLL<String>();
        DNode<String> node1 =  new DNode<>("apple");
        cdll.insertHead(node1);
        assertEquals(node1, cdll.getHead());
        assertEquals(node1, cdll.getHead().getNext());
        assertEquals(node1, cdll.getTail().getNext());
    }

    @Test
    public void testInsertTail() {
        CDLL<String> cdll = new CDLL<String>();
        DNode<String> node1 =  new DNode<>("apple");
        DNode<String> node2 = new DNode<>("banana");
        cdll.insertTail(node1);
        cdll.insertTail(node2);
        assertEquals(node2, cdll.getTail());
        assertEquals(node2, cdll.getHead().getPrevious());
        assertEquals(node1, cdll.getTail().getPrevious());
        assertEquals(node2, cdll.getHead().getNext());
    }

    @Test
    public void testInsertTailIsSelfReferential() {
        CDLL<String> cdll = new CDLL<String>();
        DNode<String> node1 =  new DNode<>("apple");
        cdll.insertTail(node1);
        assertEquals(node1, cdll.getTail().getPrevious());
        assertEquals(node1, cdll.getTail().getNext());
        assertEquals(node1, cdll.getTail());
    }

    @Test
    public void testInsert() {
        CDLL<Integer> cdll = new CDLL<>();
        DNode<Integer> node1 = new DNode<>(1);
        DNode<Integer> node2 = new DNode<>(2);
        DNode<Integer> node3 = new DNode<>(3);
        cdll.insertHead(node1);
        cdll.insert(node2, 1);
        cdll.insert(node3, 2);
        assertEquals(node1, cdll.getHead());
        assertEquals(node2, cdll.getHead().getNext());
        assertEquals(node2, cdll.getTail().getPrevious());
        assertEquals(node3, cdll.getTail());
        assertEquals(node1, cdll.getTail().getNext());
        assertEquals(node3, cdll.getHead().getPrevious());
    }

    @Test
    public void testSortedInsert() {
        CDLL<Integer> cdll = new CDLL<Integer>();
        DNode<Integer> node1 = new DNode<>(3);
        DNode<Integer> node2 = new DNode<>(1);
        DNode<Integer> node3 = new DNode<>(2);
        cdll.sortedInsert(node1);
        cdll.sortedInsert(node2);
        cdll.sortedInsert(node3);
        assertEquals(node2, cdll.getHead());
        assertEquals(node3, cdll.getHead().getNext());
        assertEquals(node3, cdll.getTail().getPrevious());
        assertEquals(node1, cdll.getTail());
        assertEquals(node2, cdll.getTail().getNext());
        assertEquals(node1, cdll.getHead().getPrevious());
        assertTrue(cdll.isSorted());
    }

    @Test
    public void testSearch() {
        CDLL<String> cdll = new CDLL<>();
        DNode<String> node1 = new DNode<>("apple");
        cdll.insertHead(node1);
        cdll.insertTail(new DNode<String>("banana"));
        assertEquals("apple", cdll.search(node1).getData());
    }

    @Test
    public void testDeleteHead() {
        CDLL<String> cdll = new CDLL<String>();
        cdll.insertHead(new DNode<String>("apple"));
        cdll.insertTail(new DNode<String>("banana"));
        cdll.deleteHead();
        assertEquals("banana", cdll.getHead().getData());
        assertEquals(cdll.getTail(), cdll.getHead().getPrevious());
        assertEquals(cdll.getHead(), cdll.getTail().getNext());
    }

    @Test
    public void testDeleteTail() {
        CDLL<String> cdll = new CDLL<String>();
        cdll.insertHead(new DNode<String>("apple"));
        cdll.insertTail(new DNode<String>("banana"));
        cdll.deleteTail();
        assertEquals("apple", cdll.getTail().getData());
        assertEquals(cdll.getTail(), cdll.getHead().getPrevious());
        assertEquals(cdll.getHead(), cdll.getTail().getNext());
    }

    @Test
    public void testDelete() {
        CDLL<String> cdll = new CDLL<String>();
        DNode<String> node1 = new DNode<>("banana");
        cdll.insertHead(new DNode<String>("apple"));
        cdll.insertTail(node1);
        cdll.delete(node1);
        assertNull(cdll.search(node1));
        assertEquals("apple", cdll.getHead().getData());
        assertEquals(cdll.getTail(), cdll.getHead().getPrevious());
        assertEquals(cdll.getHead(), cdll.getTail().getNext());
    }

    @Test
    public void testSort() {
        CDLL<Integer> cdll = new CDLL<>();
        DNode<Integer> node1 = new DNode<>(3);
        DNode<Integer> node2 = new DNode<>(1);
        DNode<Integer> node3 = new DNode<>(2);
        cdll.insertHead(node1);
        cdll.insertHead(node2);
        cdll.insertHead(node3);
        cdll.sort();
        assertEquals(node2, cdll.getHead());
        assertEquals(node3, cdll.getHead().getNext());
        assertEquals(node3, cdll.getTail().getPrevious());
        assertEquals(node1, cdll.getTail());
        assertEquals(node1, cdll.getHead().getPrevious());
        assertEquals(node2, cdll.getTail().getNext());
        assertTrue(cdll.isSorted());
    }

    @Test
    public void testClear() {
        CDLL<String> cdll = new CDLL<>();
        cdll.insertHead(new DNode<>("apple"));
        cdll.insertTail(new DNode<>("banana"));
        cdll.clear();
        assertEquals(null, cdll.getHead());
    }

    @Test
    public void isSortedFalseTest(){
        CDLL<Integer> cdll = new CDLL<>();
        DNode<Integer> node1 = new DNode<>(10);
        DNode<Integer> node2 = new DNode<>(20);
        cdll.insertHead(node1);
        cdll.insertHead(node2);
        assertFalse(cdll.isSorted());
    }
}
