package mylib.datastructures.trees;
import mylib.datastructures.nodes.*;
import java.util.Queue;
import java.util.Stack;
import java.util.LinkedList;
/**
 * BST - Binary Search Tree (assumes nodes will not have duplicate values) 
 * 
 */
public class BST<T extends Comparable<T>> {
    protected TNode<T> root;

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
    public BST(T val) {
        TNode<T> tempNode = new TNode<T>(val, 0, null, null, null);
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
    public void insert(T val) {
        TNode<T> tempNode = new TNode<T>(val, 0, null, null, null);
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
    public void delete(T val) {
        TNode<T> temp = new TNode<T>(val, 0, root, root, root);
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
        }
        if (iter.getRight() == null && iter.getLeft() != null) {
            if (iter.getParent() == null) {
                iter.setData(iter.getLeft().getData());
                iter.setLeft(null);
            } else if (iter.getParent().getRight() == iter) {
                iter.getParent().setRight(iter.getLeft());
                iter.getLeft().setParent(iter);
            } else {
                iter.getParent().setLeft(iter.getLeft());
                iter.getLeft().setParent(iter);
            }
        }                                              
        else if (iter.getRight() != null && iter.getLeft() == null) {
            if (iter.getParent() == null) {
                iter.setData(iter.getRight().getData());
                iter.setRight(null);
            } else if (iter.getParent().getRight() == iter) {
                iter.getParent().setRight(iter.getRight());
                iter.getRight().setParent(iter);
            } else {
                iter.getParent().setLeft(iter.getRight());
                iter.getRight().setParent(iter);
            }
        }
        else if (iter.getRight() == null && iter.getLeft() == null) {
            if (iter.getParent() == null) {
                this.root = null;
            } else if (iter.getParent().getLeft() == iter) {
                iter.getParent().setLeft(null);
            } else {
                iter.getParent().setRight(null);
            }
        } else {                                       
            TNode<T> finder = iter.getRight();          
            while(finder.getLeft() != null) {
                finder = finder.getLeft();
            }                                          
            if (finder.getParent() == iter)  {
                iter.setData(finder.getData());
                iter.setRight(null);
            } else {
                iter.setData(finder.getData());             
                finder.getParent().setLeft(null);      
            }        
        }
        
    }
    /**
     * Search() - searches through the given binary search tree to find the node with a value matching the given value
     * @param val - value of node to delete
     * @return - Null if node is not found, node if found.
     */
    public TNode<T> search(T val) {
            TNode<T> node = new TNode<T>(val, 0, null, null, null);
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
        /**
         * printInOrder() - method to print all nodes in the tree in order.
         */
    public void printInOrder() {
        if (this.root == null) {
            System.out.print("Tree does not exist\n");
            return;
        }
        String txt = "";
        TNode<T> temp = this.root;
        Stack<TNode<T>> stack = new Stack<>();

        while (temp != null || !stack.isEmpty()) {
            while (temp != null) {
                stack.push(temp);
                temp = temp.getLeft();
            }

            temp = stack.pop();
            txt += temp.toString() + " ";

            temp = temp.getRight();
        }
        System.out.print(txt + "\n");
    }
    /**
     * printBF() - prints the tree in breadth-first order
     */
    public void printBF() {
        String txt = "";
        if (this.root == null) {
            System.out.print("Tree does not exist\n");
            return;
        }
        // IF WE ARE ALLOWED TO USE UTIL

        Queue<TNode<T>> queue = new LinkedList<>();
        queue.add(this.root);

        while (!queue.isEmpty()) {
            TNode<T> node = queue.poll();
            txt += node.toString() + " ";

            if (node.getLeft() != null) {
                queue.add(node.getLeft());
            }

            if (node.getRight() != null) {
                queue.add(node.getRight());
            }
        }
        System.out.print(txt + "\n");
        // IF NOT :(
        // Node<TNode<T>> node = new Node<>(this.root);
        // Queue<T> queue = new Queue<>();
        // queue.enqueue(node);

        // while(!queue.empty()) {
        //     Node<TNode<T>> out = queue.dequeue();
        //     txt += out.getData().toString();

        //     if (out.getData().getLeft() != null) {
        //         Node<TNode<T>> outLeft = new Node<TNode<T>>(out.getData().getLeft());
        //         queue.enqueue(outLeft);
        //     }

        //     if (out.getData().getRight() != null) {
        //         Node<TNode<T>> outRight = new Node<TNode<T>>(out.getData().getLeft());
        //         queue.enqueue(outRight);
        //     }
        // }

    }
}
