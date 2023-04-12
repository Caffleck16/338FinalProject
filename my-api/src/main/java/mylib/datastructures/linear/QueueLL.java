package mylib.datastructures.linear;
import mylib.datastructures.nodes.*;

public class QueueLL<T extends Comparable<T>> extends SLL<T>{
    //Constructors

    public QueueLL(){
        super();
    }

    public QueueLL(SNode<T> head){
        super(head);
    }

    /**
     * enqueue(SNode<T> node);
     * @param node - node to be queued
     */
    public void enqueue(SNode<T> node){
        super.insertTail(node);
    }

    /**
     * dequeue();
     * @return previous head
     */
    public SNode<T> dequeue(){
        SNode<T> node = head;
        super.deleteHead();
        return node;
    }

    /**
     * peek();
     * @return head without dequeueing
     */
    public SNode<T> peek(){
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

    public void insertHead(SNode<T> node){}

    public void insert(SNode<T> node, int position){}

    public void sortedInsert(SNode<T> node){}

    public void deleteTail(){}

    public void delete(SNode<T> node){}

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
        SNode<T> curNode = head;
        for(int i = 0; i<size; i++){
            System.out.println("Node " + i + ": " + curNode.getData());
            curNode = curNode.getNext();
        }
    }
}
