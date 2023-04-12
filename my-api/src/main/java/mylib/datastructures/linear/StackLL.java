package mylib.datastructures.linear;
import mylib.datastructures.nodes.*;

public class StackLL<T extends Comparable<T>> extends SLL<T>{
    //Constructors
    public StackLL(){
        super();
    }

    public StackLL(SNode<T> head){
        super(head);
    }

    /**
     * push(SNode<T> node);
     * @param node - node to be pushed to stack
     */
    public void push(SNode<T> node){
        super.insertHead(node);
    }

    /**
     * pop();
     * @return node at the head of the stack and deletes it from stack
     */
    public SNode<T> pop(){
        SNode<T> node = this.head;
        super.deleteHead();
        return node;
    }

    /**
     * peek();
     * @return head of stack without popping
     */
    public SNode<T> peek(){
        return this.head;
    }

    /**
     * @return whether stack is empty or not.
     */
    public boolean empty(){
        return size==0;
    }

    //Overriding methods not useful to a stack
    public void insertTail(SNode<T> node){}

    public void insert(SNode<T> node, int position){}

    public void sortedInsert(SNode<T> node){}

    public void deleteTail(){}

    public void delete(SNode<T> node){}

    public void sort(){}

    /**
     * print();
     * prints out stack length and contents.
     */
    public void print(){
        System.out.println("Stack Length: " + size);
        System.out.println("Stack Contents:");
        if(head == null){
            System.out.println("Stack is empty");
        }
        SNode<T> curNode = head;
        for(int i = 0; i<size; i++){
            System.out.println("Node " + i + ": " + curNode.getData());
            curNode = curNode.getNext();
        }
    }
}
