package mylib.datastructures.trees;
import java.util.Stack;

import mylib.datastructures.nodes.*;
/**
 * AVL class for a self balancing binary tree
 */
public class AVL<T extends Comparable<T>> extends BST<T>{
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
    public AVL(T val) {
        TNode<T> node = new TNode<T>(val, 0, null, null, null); 
            this.root = node;
        
    }

    /**
     * Overloaded Constructor - constructor performs a self balancing algorithim on the tree when setting a node = root
     * @param node - node to set equal to root
     */
    public AVL(TNode<T> node) {
        this.root = null;
        if (node.getLeft() != null || node.getRight() != null) {
            TNode<T> temp = node;
            Stack<TNode<T>> stack = new Stack<>();

            while (temp != null || !stack.isEmpty()) {
                while (temp != null) {
                    stack.push(temp);
                    temp = temp.getLeft();
                }

                temp = stack.pop();
                insert(temp.getData());

                temp = temp.getRight();
            }
        } else {
            this.root = node;
        }
    }

    /**
     * getRoot() - getter method for root
     * @return - root
     */
    public TNode<T> getRoot() {
        return this.root;
    }

    /**
     * setRoot() - setter method for root
     * @param node - node to set root
     */
    public void setRoot(TNode<T> node) {
        this.root = node;
        if (node.getLeft() != null || node.getRight() != null) {
            root = balanceTree(node);
        }
    }

    /**
     * insert() - inserts a node into the tree then balances the tree
     * @param val - integer value for node
     */
    public void insert(T val) {
        this.root = insert(this.root, val);
    }

    /**
     * insert() - inserts a node into the tree then balances the ree
     * @param node - node to insert into the tree
     */
    public TNode<T> insert(TNode<T> node, T val) {
        if (node == null) {
            return new TNode<T>(val, 0, null, null, null);
        }
        
        if (node.getData().compareTo(val) > 0) {
            node.setLeft(insert(node.getLeft(), val));
        } else if (node.getData().compareTo(val) < 0) {
            node.setRight(insert(node.getRight(), val));
        } else {
            return node;
        }
        
        node.setBalance(1 + Math.max(height(node.getLeft()), height(node.getRight())));
        int balance = balanceFactor(node);
        if (balance > 1) {
            if (node.getLeft().getData().compareTo(val) > 0) {
                return rotateRight(node);
            } else if (node.getLeft().getData().compareTo(val) < 0) {
                node.setLeft(rotateLeft(node.getLeft()));
                return rotateRight(node);
            }
        }
        if (balance < -1) {
            if (node.getRight().getData().compareTo(val) < 0) {
                return rotateLeft(node);
            } else if (node.getRight().getData().compareTo(val) > 0) {
                node.setRight(rotateRight(node.getRight()));
                return rotateLeft(node);
            }
        }
        return node;
    }
    /**
     * delete() - call delete with root node
     * @param value - value of node to be deleted
     */
    @Override
    public void delete(T value) {
        this.root = delete(this.root, value);
    }

    /**
     * delete() - delete the node with the matching value
     * @param node - root node of tree to delete
     * @param value - value to delete
     * @return - new balanced tree with deleted node
     */
    public TNode<T> delete(TNode<T> node, T value) {
        if (node == null) {
            return node;
        }

        if (node.getData().compareTo(value) > 0) { // node < value

            node.setLeft(delete(node.getLeft(), value));
        } else if (node.getData().compareTo(value) < 0) { // node > value
            node.setRight(delete(node.getRight(), value));
        } else {
            // Node to delete is this

            if (node.getLeft() == null || node.getRight() == null) {
                TNode<T> finder;
                if (node.getLeft() != null) {
                    finder = node.getLeft();
                } else {
                    finder = node.getRight();
                }

                if (finder == null) {
                    finder = node;
                    node = null;
                } else {
                    node = finder;
                }
                } else {
                    T finder = minValue(node.getRight());
                    node.setData(finder);
                    node.setRight(delete(node.getRight(), finder));
                }
            }

            node = balanceTree(node);
            return node;
    }
    
    /**
     * calls parent class search method
     * 
     * @return - node with value in the tree.
     */
    public TNode<T> search(T val) {
        return super.search(val);
    }

    /**
     * printInOrder() - calls parent method
     */
    public void printInOrder() {
        super.printInOrder();
    }

    /**
     * printBF() - calls parent method
     */
    public void printBF() {
        super.printBF();
    }

    /**
     * minValue() - private helper function to find minvalue of a tree
     * @param node - node to find minvalues of
     * @return - returns the min value
     */
    private T minValue(TNode<T> node) {
        T minValue = node.getData();
        while (node.getLeft() != null) {
            minValue = node.getLeft().getData();
            node = node.getLeft();
        }
        return minValue;
    }

    /**
     * balanceTree() - private helper function that balances the tree 
     * @param node - node to perform the balance on
     * @return - returns a balanced subtree for the given node
     */
    private TNode<T> balanceTree(TNode<T> node) {
        if (node == null) {
            return null;
        }

        int balance = balanceFactor(node);

        if (balance < -1) {
            if (balanceFactor(node.getRight()) <= 0) { // val > right
                return rotateLeft(node);
            } else { // val < right
                node.setRight(rotateRight(node.getRight()));
                return rotateLeft(node);
            }
        }
        if (balance > 1) {
            if (balanceFactor(node.getLeft()) >= 0) { // val < left
                return rotateRight(node);
            } else { 
                node.setLeft(rotateLeft(node.getLeft()));
                return rotateRight(node);
            }
        }

        return node;
    }

    /**
     * balanceFactor() - helper function to easily access the balance factor of a node (PUBLIC FOR TESTING)
     * @param node - node to get balance factor of
     * @return - balance factor node
     */
    public int balanceFactor(TNode<T> node) {
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
            return -1;
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
        TNode<T> T2 = x.getRight();

        y.setLeft(T2);
        x.setRight(y);

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
        TNode<T> T2 = y.getLeft();

        y.setLeft(x);
        x.setRight(T2);

        x.setBalance(Math.max(height(x.getLeft()), height(x.getRight())) + 1);
        y.setBalance(Math.max(height(y.getLeft()), height(y.getRight())) + 1);        

        return y;
    }
}
