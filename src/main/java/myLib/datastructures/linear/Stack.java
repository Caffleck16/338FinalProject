package main.java.myLib.datastructures.linear;
import main.java.myLib.datastructures.nodes.*;

public class Stack<T extends Comparable<T>> extends SLL<T>{
    //Constructors
    public Stack(){
        super();
    }

    public Stack(Node<T> head){
        super(head);
    }

    /*
     * push(Node<T> node);
     * @params node - node to be pushed to stack
     */
    public void push(Node<T> node){
        super.insertHead(node);
    }

    /*
     * pop();
     * @returns node at the head of the stack and deletes it from stack
     */
    public Node<T> pop(){
        Node<T> node = this.head;
        super.deleteHead();
        return node;
    }

    /*
     * peek();
     * @returns head of stack without popping
     */
    public Node<T> peek(){
        return this.head;
    }

    /*
     * @returns whether stack is empty or not.
     */
    public boolean empty(){
        return size==0;
    }

    //Overriding methods not useful to a stack
    public void insertTail(Node<T> node){}

    public void insert(Node<T> node, int position){}

    public void sortedInsert(Node<T> node){}

    public void deleteTail(){}

    public void delete(Node<T> node){}

    public void sort(){}

    /*
     * print();
     * prints out stack length and contents.
     */
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
