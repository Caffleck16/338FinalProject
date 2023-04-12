package mylib.datastructures;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import mylib.datastructures.trees.*;
import mylib.datastructures.nodes.*;
/**
 * Uses many BST functions, so tests are not a focused on the already tested functions
 */
public class AVLTest{
    @Test
    public void testInsert() {
        AVL<Integer> avl = new AVL<Integer>(); 
        avl.insert(5);
        avl.insert(3);
        avl.insert(7);
        avl.insert(2);
        avl.insert(4);
        avl.insert(6);
        avl.insert(8);
        assertEquals(Integer.valueOf(5), avl.getRoot().getData());
        assertEquals(Integer.valueOf(3), avl.getRoot().getLeft().getData());
        assertEquals(Integer.valueOf(7), avl.getRoot().getRight().getData());
        assertEquals(Integer.valueOf(2), avl.getRoot().getLeft().getLeft().getData());
        assertEquals(Integer.valueOf(4), avl.getRoot().getLeft().getRight().getData());
        assertEquals(Integer.valueOf(6), avl.getRoot().getRight().getLeft().getData());
        assertEquals(Integer.valueOf(8), avl.getRoot().getRight().getRight().getData());
    }
    @Test
    public void testDelete() {
        AVL<Integer> avl = new AVL<Integer>(); 
        avl.insert(5);
        avl.insert(3);
        avl.insert(7);
        avl.insert(2);
        avl.insert(4);
        avl.insert(6);
        avl.insert(8);
        avl.delete(3);
        // AVL should be balanced
        assertNotNull(avl.search(5));
        assertNotNull(avl.search(7));
        assertNotNull(avl.search(2));
        assertNotNull(avl.search(4));
        assertNotNull(avl.search(6));
        assertNotNull(avl.search(8));
        assertNull(avl.search(3));
    }
    @Test
    public void testSearch() {
        AVL<Integer> avl = new AVL<Integer>(); 
        avl.insert(5);
        avl.insert(3);
        avl.insert(7);
        avl.insert(2);
        avl.insert(4);
        avl.insert(6);
        avl.insert(8);
        TNode<Integer> res = avl.search(4);
        assertEquals(Integer.valueOf(4), res.getData());
    }

    @Test
    public void testBalance() {
        AVL<Integer> avl = new AVL<>();
        avl.insert(5);
        avl.insert(3);
        avl.insert(7);
        avl.insert(2);
        avl.insert(4);
        avl.insert(6);
        avl.insert(8);    
        TNode<Integer> root = avl.getRoot();
        assertEquals(0, avl.balanceFactor(root));
        assertEquals(0, avl.balanceFactor(root.getLeft()));
        assertEquals(0, avl.balanceFactor(root.getRight()));
    }

    @Test
    public void testInsertWithDuplicates() {
        AVL<Integer> avl = new AVL<Integer>();
        avl.insert(7);
        avl.insert(5);
        avl.insert(3);
        avl.insert(5); // Inserting a duplicate value
        assertNotEquals(Integer.valueOf(5), avl.search(5).getLeft());
        assertNotEquals(Integer.valueOf(5), avl.search(5).getRight());
    }

    @Test
    public void testDeleteLeafNode() {
        AVL<Integer> avl = new AVL<Integer>();
        avl.insert(5);
        avl.insert(3);
        avl.insert(7);
        avl.delete(3); // Deleting a leaf node
        assertNotNull(avl.search(5));
        assertNotNull(avl.search(7));
        assertNull(avl.search(3));

    }

    @Test
    public void testDeleteNodeWithOneChild() {
        AVL<Integer> avl = new AVL<Integer>();
        avl.insert(5);
        avl.insert(3);
        avl.insert(7);
        avl.insert(6);
        avl.delete(7); // Deleting a node with one child
        assertNotNull(avl.search(5));
        assertNotNull(avl.search(3));
        assertNotNull(avl.search(6));
        assertNull(avl.search(7));
       // assertEquals("Deletion of node with one child test failed", "3 5 6 ", avl.printInOrder());
    }

    @Test
    public void testDeleteNodeWithTwoChildren() {
        AVL<Integer> avl = new AVL<Integer>();
        avl.insert(5);
        avl.insert(3);
        avl.insert(7);
        avl.insert(2);
        avl.insert(4);
        avl.insert(6);
        avl.insert(8);
        avl.delete(7); // Deleting a node with two children
       // assertEquals("Deletion of node with two children test failed", "2 3 4 5 6 8 ", avl.printInOrder());
    }

    @Test
    public void testSearchNonExistentNode() {
        AVL<Integer> avl = new AVL<Integer>();
        avl.insert(5);
        avl.insert(3);
        avl.insert(7);
        TNode<Integer> node = avl.search(2); // Searching for a non-existent node
        assertNull(node);
    }
    
    @Test
    public void testPrintInOrder() {
        AVL<Integer> avl = new AVL<Integer>();
        avl.insert(5);
        avl.insert(3);
        avl.insert(7);
        avl.insert(2);
        avl.insert(4);
        avl.insert(6);
        avl.insert(8);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        avl.printInOrder();

        String expectedOutput = "2 3 4 5 6 7 8 " + "\n";
        assertEquals(expectedOutput, outContent.toString());

        // Test if deleting updates tree

        avl.delete(2);
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        avl.printInOrder();

        expectedOutput = "3 4 5 6 7 8 " + "\n";
        assertEquals(expectedOutput, outContent.toString());

        
    }

    @Test
    public void testPrintBF() {
        AVL<Integer> avl = new AVL<Integer>();
        avl.insert(1);
        avl.insert(2);
        avl.insert(3);
        avl.insert(4);
        avl.insert(5);
        avl.insert(6);
        avl.insert(7);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        avl.printBF();

        String expectedOutput = "4 2 6 1 3 5 7 " + "\n";
        assertEquals(expectedOutput, outContent.toString());

        avl.delete(3);
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        avl.printBF();

        expectedOutput = "4 2 6 1 5 7 " + "\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void testConstructor() {
        BST<Integer> bst = new BST<>();
        bst.insert(1);
        bst.insert(2);
        bst.insert(3);
        bst.insert(4);
        bst.insert(5);
        bst.insert(6);
        bst.insert(7);

        AVL<Integer> avl = new AVL<>(bst.getRoot());
        assertNotEquals(bst.getRoot(), avl.getRoot());

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        avl.printBF();

        String expectedOutput = "4 2 6 1 3 5 7 " + "\n";
        assertEquals(expectedOutput, outContent.toString());
        

    }

}
