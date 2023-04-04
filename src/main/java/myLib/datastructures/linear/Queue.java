package main.java.myLib.datastructures.linear;
import main.java.myLib.datastructures.nodes.*;

public class Queue<T extends Comparable<T>> extends SLL<T>{
    //Constructors

    public Queue(){
        super();
    }

    public Queue(Node<T> head){
        super(head);
    }

    /**
     * enqueue(Node<T> node);
     * @param node - node to be queued
     */
    public void enqueue(Node<T> node){
        super.insertTail(node);
    }

    /**
     * dequeue();
     * @return previous head
     */
    public Node<T> dequeue(){
        Node<T> node = head;
        super.deleteHead();
        return node;
    }

    /**
     * peek();
     * @return head without dequeueing
     */
    public Node<T> peek(){
        return this.head;
    }

    /**
     * empty();
     * @return true if queue is empty
     */
    public boolean empty(){   
        return size==0;
    }

    //Overiding methods not useful to queue

    public void insertHead(Node<T> node){}

    public void insert(Node<T> node, int position){}

    public void sortedInsert(Node<T> node){}

    public void deleteTail(){}

    public void delete(Node<T> node){}

    public void sort(){}

    /**
     * print();
     * prints out queue's length and contents.
     */
    public void print(){
        System.out.println("Queue Length: " + size);
        System.out.println("Queue Contents:");
        if(head == null){
            System.out.println("Queue is empty");
        }
        var curNode = head;
        for(int i = 0; i<size; i++){
            System.out.println("Node " + i + ": " + curNode.getData());
            curNode = curNode.getNext();
        }
    }
}
