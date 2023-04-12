package test;

import org.junit.Test;
import static org.junit.Assert.*;
import main.java.myLib.datastructures.linear.*;
import main.java.myLib.datastructures.nodes.*;
/*
 * Most boundary cases were already tested in DLLTest, so this will just cover basic functionality, as CDLL
 * uses the same methods as DLL.
 */
public class CSLLTest {
    @Test
    public void testConstructorIsSelfReferential(){
        SNode<Integer> node1 = new SNode<>(1);
        CSLL<Integer> csll = new CSLL<>(node1);
        assertEquals(node1, csll.getHead());
        assertEquals(node1, csll.getHead().getNext());
    }
    
    @Test
    public void testInsertHead() {
        CSLL<Integer> csll = new CSLL<>();
        SNode<Integer> node1 = new SNode<>(1);
        SNode<Integer> node2 = new SNode<>(2);
        csll.insertHead(node1);
        csll.insertHead(node2);
        assertEquals(node2, csll.getHead());
        assertEquals(node1, csll.getTail());
        assertEquals(node2, csll.getTail().getNext());
    }
    
    @Test
    public void testInsertHeadIsSelfReferential() {
        CSLL<Integer> csll = new CSLL<>();
        SNode<Integer> node1 = new SNode<>(1);
        csll.insertHead(node1);
        assertEquals(node1, csll.getHead());
        assertEquals(node1, csll.getHead().getNext());
    }

    @Test
    public void testInsertTail() {
        CSLL<Integer> csll = new CSLL<>();
        SNode<Integer> node1 = new SNode<>(1);
        SNode<Integer> node2 = new SNode<>(2);
        csll.insertTail(node1);
        csll.insertTail(node2);
        assertEquals(node1, csll.getHead());
        assertEquals(node2, csll.getTail());
        assertEquals(node1, csll.getTail().getNext());
    }

    @Test
    public void testInsertTailIsSelfReferential() {
        CSLL<Integer> csll = new CSLL<>();
        SNode<Integer> node1 = new SNode<>(1);
        csll.insertTail(node1);
        assertEquals(node1, csll.getTail());
        assertEquals(node1, csll.getTail().getNext());
    }

    @Test
    public void testInsert() {
        CSLL<Integer> csll = new CSLL<>();
        SNode<Integer> node1 = new SNode<>(1);
        SNode<Integer> node2 = new SNode<>(2);
        SNode<Integer> node3 = new SNode<>(3);
        csll.insertHead(node1);
        csll.insert(node2, 1);
        csll.insert(node3, 2);
        assertEquals(node1, csll.getHead());
        assertEquals(node2, csll.getHead().getNext());
        assertEquals(node3, csll.getTail());
        assertEquals(node1, csll.getTail().getNext());
    }

    @Test
    public void testSortedInsert() {
        CSLL<Integer> csll = new CSLL<>();
        SNode<Integer> node1 = new SNode<>(1);
        SNode<Integer> node2 = new SNode<>(2);
        SNode<Integer> node3 = new SNode<>(3);
        csll.sortedInsert(node2);
        csll.sortedInsert(node1);
        csll.sortedInsert(node3);
        assertEquals(node1, csll.getHead());
        assertEquals(node2, csll.getHead().getNext());
        assertEquals(node3, csll.getTail());
        assertEquals(node1, csll.getTail().getNext());
        assertTrue(csll.isSorted());
    }

    @Test
    public void testSearch() {
        CSLL<Integer> csll = new CSLL<>();
        SNode<Integer> node1 = new SNode<>(1);
        SNode<Integer> node2 = new SNode<>(2);
        csll.insertHead(node1);
        csll.insertTail(node2);
        assertEquals(node1, csll.search(node1));
        assertEquals(node2, csll.search(node2));
        assertEquals(node1, csll.search(csll.getTail().getNext()));
        assertNull(csll.search(new SNode<>(3)));
    }

    @Test
    public void testDeleteHead() {
        CSLL<Integer> csll = new CSLL<>();
        SNode<Integer> node1 = new SNode<>(1);
        SNode<Integer> node2 = new SNode<>(2);
        csll.insertHead(node1);
        csll.insertTail(node2);
        csll.deleteHead();
        assertEquals(node2, csll.getHead());
        assertEquals(node2, csll.getTail().getNext());
        csll.deleteHead();
        assertNull(csll.getHead());
    }

    @Test
    public void testDeleteTail() {
        CSLL<Integer> csll = new CSLL<>();
        SNode<Integer> node1 = new SNode<>(1);
        SNode<Integer> node2 = new SNode<>(2);
        csll.insertHead(node1);
        csll.insertTail(node2);
        csll.deleteTail();
        assertEquals(node1, csll.getHead());
        assertEquals(node1, csll.getTail().getNext());
        csll.deleteTail();
        assertNull(csll.getHead());
    }

    @Test
    public void testDelete() {
        CSLL<Integer> csll = new CSLL<>();
        SNode<Integer> node1 = new SNode<>(1);
        SNode<Integer> node2 = new SNode<>(2);
        csll.insertHead(node1);
        csll.insertTail(node2);
        csll.delete(node1);
        assertEquals(node2, csll.getHead());
        assertEquals(csll.getTail().getNext(), node2);
        csll.delete(node2);
        assertNull(csll.getHead());
    }
    
    @Test
    public void testSort() {
        CSLL<Integer> csll = new CSLL<>();
        SNode<Integer> node1 = new SNode<>(1);
        SNode<Integer> node2 = new SNode<>(2);
        SNode<Integer> node3 = new SNode<>(3);
        csll.insertHead(node3);
        csll.insertHead(node1);
        csll.insertHead(node2);
        csll.sort();
        assertEquals(node1, csll.getHead());
        assertEquals(node2, csll.getHead().getNext());
        assertEquals(node3, csll.getTail());
        assertEquals(node1, csll.getTail().getNext());
        assertTrue(csll.isSorted());
    }
    
    @Test
    public void testClear() {
        CSLL<Integer> csll = new CSLL<>();
        SNode<Integer> node1 = new SNode<>(1);
        SNode<Integer> node2 = new SNode<>(2);
        csll.insertHead(node1);
        csll.insertTail(node2);
        csll.clear();
        assertNull(csll.getHead());
    }

    @Test
    public void isSortedFalseTest(){
        CSLL<Integer> csll = new CSLL<>();
        SNode<Integer> node1 = new SNode<>(10);
        SNode<Integer> node2 = new SNode<>(20);
        csll.insertHead(node1);
        csll.insertHead(node2);
        assertFalse(csll.isSorted());
    }
}
