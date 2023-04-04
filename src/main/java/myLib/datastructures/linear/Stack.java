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
        return size==0;
    }

    public void insertTail(Node<T> node){}

    public void insert(Node<T> node, int position){}

    public void sortedInsert(Node<T> node){}

    public void deleteTail(){}

    public void delete(Node<T> node){}

    public void sort(){}

    public void print(){
        System.out.println("Stack Length: " + size);
        System.out.println("Stack Contents:");
        if(head == null){
            System.out.println("Stack is empty");
        }
        var curNode = head;
        for(int i = 0; i<size; i++){
            System.out.println("Node " + i + ": " + curNode.getData());
            curNode = curNode.getNext();
        }
    }
}
