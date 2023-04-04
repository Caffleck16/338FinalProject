package main.java.myLib.datastructures.linear;
import main.java.myLib.datastructures.nodes.*;

/*
 * Circular singly linked list - extends the singly linked list class and uses Node objects as nodes.
 */
public class CSLL<T extends Comparable<T>> extends SLL<T> {
    //Constructors
    public CSLL() {
        super();
    }

    public CSLL(Node<T> node){
        super(node);
        tail.setNext(head);
    }

    /*
     * insertHead(Node<T> node);
     * @params node - node to be inserted at the head.
     */
    public void insertHead(Node<T> node) {
        super.insertHead(node);
        tail.setNext(head);
    }

    /*
     * insertTail(Node<T> node);
     * @params node - node to be inserted at the tail
     */
    public void insertTail(Node<T> node) {
        super.insertTail(node);
        tail.setNext(head);
    }

    /*
     * deleteHead();
     * deletes the current head of the list
     */
    public void deleteHead() {
        super.deleteHead();
        tail.setNext(head);
    }

    /*
     * deleteTail();
     * deletes the current tail of the list
     */
    public void deleteTail() {
        super.deleteTail();
        tail.setNext(head);
    }

    /*
     * calls the SLL sort method, sets tail.next as head.
     */
    public void sort(){
        super.sort();
        tail.setNext(head);
    }
}
