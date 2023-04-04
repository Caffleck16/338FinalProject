package main.java.myLib.datastructures.linear;
import main.java.myLib.datastructures.nodes.*;

public class Stack<T extends Comparable<T>> extends SLL<T>{
    public Stack(){
        super();
    }

    public Stack(Node<T> head){
        super(head);
    }
    
    public void push(Node<T> node){
        super.insertHead(node);
    }

    public Node<T> pop(){
        Node<T> node = this.head;
        super.deleteHead();
        return node;
    }

    public Node<T> peek(){
        return this.head;
    }

    public boolean empty(){
        if(size==0){
            return true;
        } else{
            return false;
        }
    }

    public void insertTail(Node<T> node){

    }

    public void insert(Node<T> node, int position){

    }

    public void sortedInsert(Node<T> node){

    }

    public void deleteTail(){

    }

    public void delete(Node<T> node){

    }

}
