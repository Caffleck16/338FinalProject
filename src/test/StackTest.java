package test;

import org.junit.Test;
import static org.junit.Assert.*;
import main.java.myLib.datastructures.linear.*;
import main.java.myLib.datastructures.nodes.*;

public class StackTest {

    @Test
    public void testPushAndPop() {
        Stack<Integer> stack = new Stack<>();
        stack.push(new Node<Integer>(1));
        stack.push(new Node<Integer>(2));
        stack.push(new Node<Integer>(3));
        assertEquals(3, stack.pop().getData().intValue());
        assertEquals(2, stack.pop().getData().intValue());
        assertEquals(1, stack.pop().getData().intValue());
        assertTrue(stack.empty());
    }

    @Test
    public void testempty() {
        Stack<String> stack = new Stack<>();
        assertTrue(stack.empty());
        stack.push(new Node<String>("foo"));
        assertFalse(stack.empty());
        stack.pop();
        assertTrue(stack.empty());
    }

    @Test
    public void testPeek() {
        Stack<Double> stack = new Stack<>();
        stack.push(new Node<Double>(1.0));
        stack.push(new Node<Double>(2.0));
        assertEquals(2.0, stack.peek().getData(), 0.001);
        assertEquals(2.0, stack.peek().getData(), 0.001);
        stack.pop();
        assertEquals(1.0, stack.peek().getData(), 0.001);
        assertFalse(stack.empty());
    }

    
    @Test
    public void irrelevantMethodsAreEmptyTest(){
        Stack<Integer> stack = new Stack<>();
        Node<Integer> node1 = new Node<>(1);
        Node<Integer> node2 = new Node<>(2);
        stack.push(node1);
        
        stack.deleteTail();
        assertFalse(stack.empty());
        
        stack.insertTail(node2);
        assertNull(stack.search(node2));
        
        stack.insert(node2, 0);
        assertEquals(node1, stack.peek());

        stack.sortedInsert(node2);
        assertEquals(node1, stack.peek());

        stack.delete(node1);
        assertEquals(node1, stack.search(node1));

        stack.push(node2);
        stack.sort();
        assertFalse(stack.isSorted());

    }
}