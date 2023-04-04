package main.java.myLib.datastructures.linear;
import main.java.myLib.datastructures.nodes.*;

public class CSLL<T extends Comparable<T>> extends SLL<T> {
    public CSLL() {
        super();
    }

    public CSLL(Node<T> node){
        super(node);
        tail.setNext(head);
    }

    public void insertHead(Node<T> node) {
        super.insertHead(node);
        tail.setNext(head);
    }

    public void insertTail(Node<T> node) {
        super.insertTail(node);
        tail.setNext(head);
    }

    public void deleteHead() {
        super.deleteHead();
        tail.setNext(head);
    }

    public void deleteTail() {
        super.deleteTail();
        tail.setNext(head);
    }

    public void sort(){
        super.sort();
        tail.setNext(head);
    }
}
