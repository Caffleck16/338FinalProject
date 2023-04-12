package main.java.myLib.datastructures.nodes;

/**
 * 
 * The Node class represents a node in a singly linked list data structure.
 * 
 * @param <T> the type of data stored in the node
 */
public class SNode<T> {

    /**
     * 
     * The data stored in the node.
     */
    private T data;
    /**
     * 
     * The reference to the next node in the list.
     */
    private SNode<T> next;

    /**
     * 
     * Constructs a new Node object with the specified data.
     * 
     * @param data the data to be stored in the node
     */
    public SNode(T data) {
        this.data = data;
        this.next = null;
    }

    /**
     * 
     * Returns the data stored in the node.
     * 
     * @return the data stored in the node
     */
    public T getData() {
        return data;
    }

    /**
     * 
     * Sets the data stored in the node to the specified data.
     * 
     * @param data the data to be stored in the node
     */
    public void setData(T data) {
        this.data = data;
    }

    /**
     * 
     * Returns the reference to the next node in the list.
     * 
     * @return the reference to the next node in the list
     */
    public SNode<T> getNext() {
        return next;
    }

    /**
     * 
     * Sets the reference to the next node in the list to the specified node.
     * 
     * @param next the node to be set as the next node in the list
     */
    public void setNext(SNode<T> next) {
        this.next = next;
    }
}