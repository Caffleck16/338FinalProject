package test;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import main.java.myLib.datastructures.trees.*;
import main.java.myLib.datastructures.nodes.*;

public class BSTTest {
    @Test
    public void testIfRootCreationIsSuccessfull() {       
        // Test inserting a node
        BST<Integer> bstTreeRoot = new BST<Integer>();
        TNode<Integer> root = new TNode<Integer>(10, 0, null, null, null);
        bstTreeRoot.insert(root);
        assertEquals("root was not successfully updated by inserting a node", root, bstTreeRoot.getRoot());

        // Test inserting a value
        BST<Integer> bstTreeVal = new BST<Integer>();
        bstTreeVal.insert(10);
        TNode<Integer> rootVal = bstTreeVal.getRoot();
        assertEquals("root was not successfully updated by inserting a integer", root.getData(), rootVal.getData());
    }

    @Test
    public void testConstructor() {
        // Test inital creation with value
        BST<Integer> bstTree = new BST<Integer>(10);
        TNode<Integer> root = bstTree.getRoot();
        TNode<Integer> insertionNode = new TNode<Integer>(10, 0, null, null, null);
        assertEquals("Root does not have same datavalue", insertionNode.getData(), root.getData());

        // Test inital creation with node
        BST<Integer> bstTreeNode = new BST<Integer>(insertionNode);
        root = bstTreeNode.getRoot();
        assertEquals("Root does not equal the same node", insertionNode, root);

        // Test constructor maintains existing tree
        // this is not a test on inserting correctly so nodes are placed correctly prior to construction
        root = new TNode<Integer>(10, 0, null, null, null);
        TNode<Integer> leftNode = new TNode<Integer>(5, 0, null, null, null);
        TNode<Integer> rightNode = new TNode<Integer>(15, 0, null, null, null);
        TNode<Integer> parentNode = new TNode<Integer>(20, 0, null, null, null);
        root.setLeft(leftNode);
        root.setRight(rightNode);
        root.setParent(parentNode);
        BST<Integer> test = new BST<Integer>(root);
        root = test.getRoot(); // root now equals the tree's new root
        assertEquals("Left Node is incorrect", leftNode, root.getLeft());
        assertEquals("Right Node is incorrect", rightNode, root.getRight());
        assertEquals("Parent Node is incorrect", parentNode, root.getParent());
    }

    @Test
    public void testInsertion() {
        // Test large insertion of values
        BST<Integer> bstTree = new BST<Integer>(10);
        bstTree.insert(5);
        bstTree.insert(15);
        bstTree.insert(1);
        bstTree.insert(20);
        TNode<Integer> root = bstTree.getRoot();
        int leftLeft = root.getLeft().getLeft().getData();
        int left = root.getLeft().getData();
        int right = root.getRight().getData();
        int rightRight = root.getRight().getRight().getData();
        assertEquals("Left-Left Node is incorrect", 1, leftLeft);
        assertEquals("Left Node is incorrect", 5, left);
        assertEquals("Right Node is incorrect", 15, right);
        assertEquals("Right-Right Node is incorrect", 20, rightRight);

        // Test large insertion of nodes (some with child nodes)
        root = new TNode<Integer>(10, 0, null, null, null);
        TNode<Integer> leftLeftNode = new TNode<Integer>(1, 0, null, null, null);
        TNode<Integer> leftNode = new TNode<Integer>(5, 0, null, leftLeftNode, null);
        leftLeftNode.setParent(leftNode);
        TNode<Integer> rightLeftNode = new TNode<Integer>(15, 0, null, null, null);
        TNode<Integer> rightNode = new TNode<Integer>(20, 0, null, null, null);
        // insertion order matters !!!!
        bstTree = new BST<Integer>(root);
        bstTree.insert(leftNode);
        bstTree.insert(rightNode);
        bstTree.insert(rightLeftNode);
        
        TNode<Integer> treeRoot = bstTree.getRoot();
        assertEquals("Left-Left Node is incorrect", leftLeftNode, treeRoot.getLeft().getLeft());
        assertEquals("Left Node is incorrect", leftNode, treeRoot.getLeft());
        assertEquals("Right-Left Node is incorrect", rightLeftNode, treeRoot.getRight().getLeft());
        assertEquals("Right Node is incorrect", rightNode, treeRoot.getRight());

        // we can also test if parents have been correctly set

        assertEquals("Right-Left Node parent is incorrect", rightNode, treeRoot.getRight().getLeft().getParent());
        assertEquals("Left-Left Node parent is incorrect", leftNode, treeRoot.getLeft().getLeft().getParent());
        assertEquals("Root is not set as parent properly", treeRoot, treeRoot.getLeft().getLeft().getParent().getParent());
    }

    @Test
    public void testSearch() {
        TNode<Integer> root = new TNode<Integer>(10, 0, null, null, null);
        TNode<Integer> leftLeftNode = new TNode<Integer>(1, 0, null, null, null);
        TNode<Integer> leftNode = new TNode<Integer>(5, 0, null, leftLeftNode, null);
        leftLeftNode.setParent(leftNode);
        TNode<Integer> rightLeftNode = new TNode<Integer>(15, 0, null, null, null);
        TNode<Integer> rightNode = new TNode<Integer>(20, 0, null, null, null);
        // insertion order matters 
        //          10
        //      5       20
        //  1         15
        BST<Integer> bstTree = new BST<Integer>(root);
        bstTree = new BST<Integer>(root);
        bstTree.insert(leftNode);
        bstTree.insert(rightNode);
        bstTree.insert(rightLeftNode);
        
        //test searching

        TNode<Integer> result = bstTree.search(1);
        assertEquals("Search did not return correct node", leftLeftNode, result);
        // check to make sure node retains value
        assertEquals("Node did not retain parent", leftNode, result.getParent());
        // get to root from returned node
        assertEquals("Root cannot be found", root, result.getParent().getParent());
        // Check right side searching
        result = bstTree.search(15);
        assertEquals("Search did not return correct node", rightLeftNode, result);
        //same as before
        assertEquals("Node did not retain parent", rightNode, result.getParent());
        assertEquals("Root cannot be found", root, result.getParent().getParent());
    }

    @Test
    public void testDelete() {
        BST<Integer> bst = new BST<Integer>();
        bst.insert(5);
        bst.insert(3);
        bst.insert(7);
        bst.insert(2);
        bst.insert(4);
        bst.insert(6);
        bst.insert(8);

        //            5
        //      3           7
        //  2       4   6       8

        bst.delete(3); // Delete a node with two children

        //              5
        //       4              7
        //  2               6       8


        TNode<Integer> root = bst.getRoot();
        assertEquals(Integer.valueOf(5), root.getData());
        assertEquals(Integer.valueOf(4), root.getLeft().getData());
        assertEquals(Integer.valueOf(7), root.getRight().getData());
        assertEquals(Integer.valueOf(2), root.getLeft().getLeft().getData());
        assertEquals(Integer.valueOf(6), root.getRight().getLeft().getData());
        assertEquals(Integer.valueOf(8), root.getRight().getRight().getData());

        bst.delete(5); // Delete the root node 
        //              6
        //          4       7
        //      2               8

        root = bst.getRoot();
        assertEquals(Integer.valueOf(6), root.getData());
        assertEquals(Integer.valueOf(4), root.getLeft().getData());
        assertEquals(Integer.valueOf(7), root.getRight().getData());
        assertEquals(Integer.valueOf(2), root.getLeft().getLeft().getData());
        assertEquals(Integer.valueOf(8), root.getRight().getRight().getData());

        bst.delete(7); // Delete a node with one child
        //              6
        //          4       8
        //       2

        root = bst.getRoot();
        assertEquals(Integer.valueOf(6), root.getData());
        assertEquals(Integer.valueOf(4), root.getLeft().getData());
        assertEquals(Integer.valueOf(8), root.getRight().getData());
        assertEquals(Integer.valueOf(2), root.getLeft().getLeft().getData());
    }
    // Boundary Case Tests

   @Test
    public void testEmptyBST() {
        BST<Integer> bst = new BST<Integer>();
        assertNull(bst.getRoot());
    } 
    @Test
    public void testInsertAndGetRoot() {
        BST<Integer> bst = new BST<Integer>();
        bst.insert(5);
        assertEquals(Integer.valueOf(5), bst.getRoot().getData());
    }
    @Test
    public void testInsertAndSearch() {
        BST<Integer> bst = new BST<Integer>();
        bst.insert(5);
        bst.insert(3);
        bst.insert(7);
        bst.insert(2);
        bst.insert(4);
        bst.insert(6);
        bst.insert(8);
        assertEquals(Integer.valueOf(5), bst.search(5).getData());
        assertEquals(Integer.valueOf(3), bst.search(3).getData());
        assertEquals(Integer.valueOf(7), bst.search(7).getData());
        assertEquals(Integer.valueOf(2), bst.search(2).getData());
        assertEquals(Integer.valueOf(4), bst.search(4).getData());
        assertEquals(Integer.valueOf(6), bst.search(6).getData());
        assertEquals(Integer.valueOf(8), bst.search(8).getData());
        assertNull(bst.search(1));
        assertNull(bst.search(9));
    }
    @Test
    public void testDeleteBoundaries() {
        BST<Integer> bst = new BST<Integer>();
        bst.insert(5);
        bst.insert(3);
        bst.insert(7);
        bst.insert(2);
        bst.insert(4);
        bst.insert(6);
        bst.insert(8);
        //            5
        //      3           7
        //  2       4   6       8
        // Test deleting leaf node
        bst.delete(2);
        assertNull(bst.search(2));
        assertNull(bst.search(3).getLeft());

        // Test deleting node with only left child
        bst.delete(3);
        assertNull(bst.search(3));

        // Test deleting node with only right child
        bst.delete(7);
        assertNull(bst.search(7));

        // Test deleting node with both left and right child
        bst.delete(5);
        assertNull(bst.search(5));
        assertNotNull(bst.search(4));
        assertNotNull(bst.search(6));
        assertNotNull(bst.search(8));
    }
    @Test
    public void testInsertDuplicateValues() {
        BST<Integer> bst = new BST<Integer>();
        bst.insert(5);
        bst.insert(3);
        bst.insert(7);
        bst.insert(2);
        bst.insert(4);
        bst.insert(6);
        bst.insert(8);

        // Insert duplicate value, should not change the tree
        bst.insert(5);
        bst.insert(2);
        bst.insert(7);

        assertEquals(Integer.valueOf(5), bst.getRoot().getData());
        assertEquals(Integer.valueOf(3), bst.search(3).getData());
        assertEquals(Integer.valueOf(7), bst.search(7).getData());
        assertEquals(Integer.valueOf(2), bst.search(2).getData());
        assertEquals(Integer.valueOf(4), bst.search(4).getData());
        assertEquals(Integer.valueOf(6), bst.search(6).getData());
        assertEquals(Integer.valueOf(8), bst.search(8).getData());
    }

    @Test
    public void testInsertAndDeleteAll() {
        BST<Integer> bst = new BST<Integer>();
        bst.insert(5);
        bst.insert(3);
        bst.insert(7);
        bst.insert(2);
        bst.insert(4);
        bst.insert(6);
        bst.insert(8);

        // Delete all nodes
        bst.delete(5);
        bst.delete(3);
        bst.delete(7);
        bst.delete(2);
        bst.delete(4);
        bst.delete(6);
        bst.delete(8);
        assertNull(bst.search(5));
        assertNull(bst.search(3));
        assertNull(bst.search(7));
        assertNull(bst.search(2));
        assertNull(bst.search(4));
        assertNull(bst.search(6));
        assertNull(bst.search(8));
    }

    @Test
    public void testInsertAndDeleteRootNode() {
        BST<Integer> bst = new BST<Integer>();
        bst.insert(5);

        // Delete root node
        bst.delete(5);

        assertNull(bst.getRoot());
        assertNull(bst.search(5));
    }

    @Test
    public void testInsertAndDeleteSingleNode() {
        BST<Integer> bst = new BST<Integer>();
        bst.insert(5);

        // Delete single node
        bst.delete(5);

        assertNull(bst.getRoot());
        assertNull(bst.search(5));
    }

    @Test
    public void testInsertAndSearchMinMaxValues() {
        BST<Integer> bst = new BST<Integer>();
        bst.insert(Integer.MIN_VALUE);
        bst.insert(Integer.MAX_VALUE);

        assertEquals(Integer.valueOf(Integer.MIN_VALUE), bst.search(Integer.MIN_VALUE).getData());
        assertEquals(Integer.valueOf(Integer.MAX_VALUE), bst.search(Integer.MAX_VALUE).getData());
    }
    @Test
    public void testPrintInOrder() {
        BST<Integer> bst = new BST<Integer>();
        bst.insert(5);
        bst.insert(3);
        bst.insert(7);
        bst.insert(2);
        bst.insert(4);
        bst.insert(6);
        bst.insert(8);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        bst.printInOrder();

        String expectedOutput = "2 3 4 5 6 7 8 " + "\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void testPrintInOrderEmptyTree() {
        BST<Integer> bst = new BST<Integer>();

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        bst.printInOrder();

        String expectedOutput = "Tree does not exist" + "\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void testPrintBF() {
        BST<Integer> bst = new BST<Integer>();
        bst.insert(5);
        bst.insert(3);
        bst.insert(7);
        bst.insert(2);
        bst.insert(4);
        bst.insert(6);
        bst.insert(8);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        bst.printBF();

        String expectedOutput = "5 3 7 2 4 6 8 " + "\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void testPrintBFEmptyTree() {
        BST<Integer> bst = new BST<Integer>();

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        bst.printBF();

        String expectedOutput = "Tree does not exist" + "\n";
        assertEquals(expectedOutput, outContent.toString());
    }
}
