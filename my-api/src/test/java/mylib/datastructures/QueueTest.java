package mylib.datastructures;
import mylib.datastructures.linear.*;
import mylib.datastructures.nodes.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class QueueTest {
    @Test
    public void testEnqueueAndDequeue() {
        QueueLL<Integer> queue = new QueueLL<>();
        queue.enqueue(new SNode<Integer>(1));
        queue.enqueue(new SNode<Integer>(2));
        queue.enqueue(new SNode<Integer>(3));
        assertEquals(1, queue.dequeue().getData().intValue());
        assertEquals(2, queue.dequeue().getData().intValue());
        assertEquals(3, queue.dequeue().getData().intValue());
        assertTrue(queue.empty());
    }

    @Test
    public void testempty() {
        QueueLL<String> queue = new QueueLL<>();
        assertTrue(queue.empty());
        queue.enqueue(new SNode<String>("foo"));
        assertFalse(queue.empty());
        queue.dequeue();
        assertTrue(queue.empty());
    }

    @Test
    public void testPeek() {
        QueueLL<Double> queue = new QueueLL<>();
        queue.enqueue(new SNode<Double>(1.0));
        queue.enqueue(new SNode<Double>(2.0));
        assertEquals(1.0, queue.peek().getData(), 0.001);
        assertEquals(1.0, queue.peek().getData(), 0.001);
        queue.dequeue();
        assertEquals(2.0, queue.peek().getData(), 0.001);
        assertFalse(queue.empty());
    }

    @Test
    public void irrelevantMethodsAreEmptyTest(){
        QueueLL<Integer> queue = new QueueLL<>();
        SNode<Integer> node1 = new SNode<>(2);
        SNode<Integer> node2 = new SNode<>(1);
        queue.enqueue(node1);
        
        queue.deleteTail();
        assertFalse(queue.empty());
        
        queue.insertHead(node2);
        assertEquals(node1, queue.peek());
        
        queue.insert(node2, 0);
        assertNull(queue.search(node2));

        queue.sortedInsert(node2);
        assertEquals(node1, queue.peek());

        queue.delete(node1);
        assertEquals(node1, queue.search(node1));

        queue.enqueue(node2);
        queue.sort();
        assertEquals(node1, queue.peek());

    }
}
