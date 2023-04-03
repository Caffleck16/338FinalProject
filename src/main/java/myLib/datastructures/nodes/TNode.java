package main.java.myLib.datastructures.nodes;
/*
 * Class for TNodes, which are nodes made for the tree implementations
 */
public class TNode<T> {
    private T data;
    private TNode<T> left;
    private TNode<T> right;
    private TNode<T> parent;
    private int balance;

// Constructors:

    /*
     * Default Constructor
     */
    public TNode() {
        this.data = null;
        this.left = null;
        this.right = null;
        this.parent = null;
        this.balance = 0;
    }
    /*
     * Constructor
     * @Params data - data type of node (assumes instance implements a valid toString method)
     * @Params balance - balance of the node (int)
     * @Params P - parent node (TNode)
     * @Params L - left node (TNode)
     * @Params R - right node (TNode)
     */
    public TNode(T data, int balance, TNode<T> P, TNode<T> L, TNode<T> R) {
        this.data = data;
        this.left = L;
        this.right = R;
        this.parent = P;
        this.balance = balance;
    }

// Setter methods:

    /*
     * setLeft()
     * @params node - node to be set as left
     */
    public void setLeft(TNode<T> node) {
        this.left = node;
    }
    /*
     * setRight()
     * @params node - node to be set as right
     */
    public void setRight(TNode<T> node) {
        this.right = node;
    }
    /*
     * setParent()
     * @params node - node to be set as parent
     */
    public void setParent(TNode<T> node) {
        this.parent = node;
    }
    /*
     * setData()
     * @params data - the argument to be set as data (assumes argument data type has a valid toString() method)
     */
    public void setData(T data) {
        this.data = data;
    }
    /*
     * setBalance()
     * @params balance - the argument to be set as node balance
     */
    public void setBalance(int balance) {
        this.balance = balance;
    }

// Getter methods:

    /*
     * getLeft()
     * @return left node
     */
    public TNode<T> getLeft() {
        return this.left;
    }
    /*
     * getRight()
     * @return right node
     */
    public TNode<T> getRight() {
        return this.right;
    }
    /*
     * getParent()
     * @return parent node
     */
    public TNode<T> getParent() {
        return this.parent;
    }
    /*
     * getData()
     * @return node data
     */
    public T getData() {
        return this.data;
    }
    /*
     * getBalance()
     * @return node balance
     */
    public int getBalance() {
        return this.balance;
    }

// Functions:
    /*
     * print() - prints out the contents of a node including the left, right and parent node data.
     */
    public void print() {
        System.out.println("Node Information:");
        System.out.println("Data: " + this.data.toString());
        System.out.println("Left Node Data: " + this.left.getData());
        System.out.println("Right Node Data: " + this.right.getData());
        System.out.println("Parent Node Data: " + this.parent.getData());
        System.out.println("Node Balance: " + this.balance);
    }
    /*
     * toString() - converts the data attribute to a string
     * @return - returns a string of the data
     */
    @Override
    public String toString() {
        return this.data.toString();
    }
}
