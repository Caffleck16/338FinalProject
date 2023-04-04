package main.java.myLib.datastructures.linear;
import main.java.myLib.datastructures.nodes.*;

/*
 * Circular doubly linked list. Extends the doubly linked list class and uses DNode objects as nodes.
 */
public class CDLL<T extends Comparable<T>> extends DLL<T> {
    // constructors
    public CDLL(){
        super();
    }

    public CDLL(DNode<T> head){
        super(head);
        head.setNext(tail);
        head.setPrevious(tail);
    }

    /*
     * insertHead(DNode<T> node);
     * @params node - node to be inserted at the head
     */
    public void insertHead(DNode<T> node){
        super.insertHead(node);
        tail.setNext(head);
        head.setPrevious(tail);
    }

    /*
     * insertTail(DNode<T> node);
     * @params node - node to be inserted at the tail
     */
    public void insertTail(DNode<T> node){
        super.insertTail(node);
        tail.setNext(head);
        head.setPrevious(tail);
    }

    /*
     * deleteHead();
     * deletes the current head and reconfigures pointers
     */
    public void deleteHead(){
        super.deleteHead();
        head.setPrevious(tail);
        tail.setNext(head);
    }

    /*
     * deleteTail();
     * deletes the current tail and reconfigures pointers
     */
    public void deleteTail(){
        super.deleteTail();
        head.setPrevious(tail);
        tail.setNext(head);
    }

    /*
     * sort();
     * calls the DLL sort function and reconfigures head and tail pointers.
     */
    public void sort(){
        super.sort();
        head.setPrevious(tail);
        tail.setNext(head);
    }
}
