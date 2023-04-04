package main.java.myLib.datastructures.trees;
import main.java.myLib.datastructures.nodes.*;

/**
 * BST - Binary Search Tree (assumes nodes will not have duplicate values) 
 * 
 */
public class BST<T extends Comparable<T>> {
    private TNode<T> root;

// Constructors
    /**
     * Default Constructor - sets root node to null
     */
    public BST() {
        this.root = null;
    }
    /**
     * Constructor - given a val argument, create a new root node with val 
     */
    public BST(int val) {
        TNode<T> tempNode = new TNode(val, 0, null, null, null);
        this.root = tempNode; 
    }
    /**
     * Constructor - given a node argument set the root of this tree to the node
     */
    public BST(TNode<T> node) {
        this.root = node;
    }

// Setters:

    /**
     * setRoot() - sets the value of the root node (argument must be of TNode type)
     */
    public void setRoot(TNode<T> node) {
        this.root = node;
    }

// Getters:

    /**
     * getRoot() - gets the value of the root node
     */
    public TNode<T> getRoot() {
        return this.root;
    }
// Functions:
    /**
     * insert() - creates a node with the integer value and then calls insert(node)
     * @params val - value for node to insert
     */
    public void insert(int val) {
        TNode<T> tempNode = new TNode(val, 0, null, null, null);
        insert(tempNode);
    }
    /**
     * insert() - searches through tree to insert node to correct spot
     * @params node - node to insert
     */
    public void insert(TNode<T> node) {
        if (this.root == null) {
            this.root = node;
            return;
        }
        TNode<T> finder = this.root;
        while (true) {
            if (finder.getData().compareTo(node.getData()) > 0) {               // node < root
                if (finder.getLeft() == null) {
                    finder.setLeft(node);
                    finder.getLeft().setParent(finder);
                    break;
                } else {
                    finder = finder.getLeft();
                }
            } else if (finder.getData().compareTo(node.getData()) < 0) {        // node > root
                if (finder.getRight() == null) {
                    finder.setRight(node);
                    finder.getRight().setParent(finder);
                    break;
                } else {
                    finder = finder.getRight();
                }
            } else {
                break;                                                          // duplicate value so wont be inserted into a tree
            }
        }
    }
    /**
     * delete() - deletes the node holding the integer value given by val
     * @param val - value of node to be deleted
     * 
     */
    public void delete(int val) {
        TNode<T> temp = new TNode(val, 0, root, root, root);
        // if tree is empty
        if (this.root == null) {
            System.out.println("Tree does not exist, therefore no nodes can be found");
        }
        TNode<T> iter = this.root;
        // find node:
        while (true) {
            if (iter.getData().compareTo(temp.getData()) > 0) {
                iter = iter.getLeft();
                if (iter == null) {
                    System.out.println("Val does not exist");
                    break;
                }
            } else if (iter.getData().compareTo(temp.getData()) < 0) {
                iter = iter.getRight();
                if (iter == null) {
                    System.out.println("Val does not exist");
                    break;
                }
            } else {
                break;
            }
        }                                               // iter should now be equal to the value of the node to be deleted
        if (iter.getLeft() == null) {
            if (iter.getParent() == null) {
                iter = iter.getRight();
                return;
            }
            iter.getParent().setRight(iter.getRight()); // iter parent's right is now set to iters right effectively skipping iter.
            return;
        } else if (iter.getRight() == null) {
            if (iter.getParent() == null) {
                iter = iter.getLeft();
                return;
            }
            iter.getParent().setLeft(iter.getLeft());   // iter parent's left is now set to iters left effectively skipping iter.
            return;
        } else {                                        // left and right nodes are not null, meaning node must be set to right subtrees min value
            TNode<T> finder = iter.getRight();          // finder = root of right subtree
            while(finder.getLeft() != null) {
                finder = finder.getLeft();
            }                                           // finder is now equal to the right subtrees min value
            iter.setData(finder.getData());             // node to delete is now gone and set to equal finder's data.
            finder.getParent().setLeft(null);      // set the node finder was holding to null to correct the tree.
        }
        
    }
    /**
     * Search() - searches through the given binary search tree to find the node with a value matching the given value
     * @param val - value of node to delete
     * @return - Null if node is not found, node if found.
     */
    public TNode<T> search(int val) {
            TNode<T> node = new TNode(val, 0, null, null, null);
            TNode<T> finder = this.root;
            while(finder != null) {
                if (finder.getData().compareTo(node.getData()) > 0 ) {      // node < finder
                    finder = finder.getLeft();
                } else if (finder.getData().compareTo(node.getData()) < 0 ) { // node > finder
                    finder = finder.getRight();
                } else if (finder.getData().compareTo(node.getData()) == 0) {
                    return finder;
                }
            }
            return null;
        }
    public void printInOrder() {
        String txt = "";
        TNode<T> temp = this.root;
        TNode<T> prev;
        if (temp == null) {
            txt += "No Bst Exists";
            return;
        }
        while (temp != null) {
            if (temp.getLeft() == null) {
                txt += temp.toString() + " ";
                temp = temp.getRight();
            } else {
                prev = temp.getRight();
                while (prev.getRight() != null && prev.getRight() != temp) {
                    prev = prev.getRight();
                }

                if (prev.getRight() == null) {
                    prev.setRight(temp); // this might cause lots of errors later.
                    temp = temp.getLeft();
                } else {
                    prev.setRight(null);
                    txt += temp.toString() + " ";
                    temp = temp.getRight();
                }
            }
        }
        System.out.println(txt);
    }
}
