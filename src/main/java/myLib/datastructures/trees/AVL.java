package main.java.myLib.datastructures.trees;
import main.java.myLib.datastructures.nodes.*;
/**
 * AVL class for a self balancing binary tree
 */
public class AVL<T extends Comparable<T>> extends BST<T>{
    private TNode<T> root;
    /**
     * Default Constructor
     */
    public AVL() {
        this.root = null;
    }
    /**
     * Overloaded Constructor
     * @param val - value of node
     */
    public AVL(int val) {
        TNode<T> node = new TNode(val, 0, null, null, null); 
            this.root = node;
        
    }
    /**
     * Overloaded Constructor - constructor performs a self balancing algorithim on the tree when setting a node = root
     * @param node - node to set equal to root
     */
    public AVL(TNode<T> node) {
        this.root = node;

        if (node.getLeft() != null || node.getRight() != null) {
            root = balanceTree(node);
        }
    }
    /**
     * balanceTree() - private helper function
     * @param node - node to perform the balance on
     * @return - returns a balanced subtree for the given node
     */
    private TNode<T> balanceTree(TNode<T> node) {
        if (node == null) {
            return null;
        }

        int balance = balanceFactor(node);

        if (balance > 1) {
            if (balanceFactor(node.getLeft()) < 0) {
                node.setLeft(rotateLeft(node.getLeft()));
            }

            node = rotateRight(node);
        }

        else if (balance < -1) {
            if (balanceFactor(node.getRight()) > 0) {
                node.setRight(rotateRight(node.getRight()));
            }

            node = rotateLeft(node.getLeft());
        }

        node.setLeft(balanceTree(node.getLeft()));
        node.setRight(balanceTree(node.getRight()));

        node.setBalance(Math.max(height(node.getLeft()), height(node.getRight())) + 1);

        return node;
    }
    /**
     * balanceFactor() - helper function to easily access the balance factor of a node
     * @param node - node to get balance factor of
     * @return - balance factor node
     */
    private int balanceFactor(TNode<T> node) {
        if (node == null) {
            return 0;
        }
        return height(node.getLeft()) - height(node.getRight());
    }
    /**
     * height() - helper function to easily access the height/balance of a node but checks to avoid nullpointers
     * @param node - node to get height of
     * @return - integer height value
     */
    private int height(TNode<T> node) {
        if (node == null) {
            return 0;
        }
        return node.getBalance();
    }
    /**
     * rotateRight() - performs a right rotation on the given node
     * @param y - node to perform rotation on
     * @return - rotated node 
     */
    private TNode<T> rotateRight(TNode<T> y) {
        TNode<T> x = y.getLeft();
        TNode<T> T = x.getRight();

        x.setRight(y);
        y.setLeft(T);

        y.setBalance(Math.max(height(y.getLeft()), height(y.getRight())) + 1);
        x.setBalance(Math.max(height(x.getLeft()), height(x.getRight())) + 1);

        return x;
    }
    /**
     * rotateLeft() - performs a left rotation on the given node
     * @param x - node to perform rotation on
     * @return - rotated node
     */
    private TNode<T> rotateLeft(TNode<T> x) {
        TNode<T> y = x.getRight();
        TNode<T> T = y.getLeft();

        y.setLeft(x);
        x.setRight(T);

        x.setBalance(Math.max(height(x.getLeft()), height(x.getRight())) + 1);
        y.setBalance(Math.max(height(y.getLeft()), height(y.getRight())) + 1);

        return y;
    }
}
