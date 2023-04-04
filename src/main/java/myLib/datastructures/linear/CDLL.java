package main.java.myLib.datastructures.linear;
import main.java.myLib.datastructures.nodes.*;

public class CDLL<T extends Comparable<T>> extends DLL<T> {
    public CDLL(){
        super();
    }

    public CDLL(DNode<T> head){
        super(head);
        head.setNext(tail);
        head.setPrevious(tail);
    }

    public void insertHead(DNode<T> node){
        super.insertHead(node);
        tail.setNext(head);
        head.setPrevious(tail);
    }
    
    public void insertTail(DNode<T> node){
        super.insertTail(node);
        tail.setNext(head);
        head.setPrevious(tail);
    }

    public void deleteHead(){
        super.deleteHead();
        head.setPrevious(tail);
        tail.setNext(head);
    }

    public void deleteTail(){
        super.deleteTail();
        head.setPrevious(tail);
        tail.setNext(head);
    }

    public void sort(){
        super.sort();
        head.setPrevious(tail);
        tail.setNext(head);
    }
}
