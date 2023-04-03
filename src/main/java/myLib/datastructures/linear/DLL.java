package main.java.myLib.datastructures.linear;
import main.java.myLib.datastructures.nodes.*;


public class DLL<T extends Comparable<T>>{
    private DNode<T> head;
    private DNode<T> tail;
    private int size;
    
    public DLL(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public DLL(DNode<T> head){
        this.head = head;
        this.tail = head;
        this.size = 1;
    }

    public void insertHead(DNode<T> node) {
        if (size==0) {
            tail = node;
        } else {
            head.setPrevious(node);
            node.setNext(head);
        }
        head = node;
        size++;
    }

    public void insertTail(DNode<T> node) {
        if (size==0) {
            head = node;
        } else {
            tail.setNext(node);
            node.setPrevious(tail);
        }
        tail = node;
        size++;
    }

    public void insert(DNode<T> node, int position) {
        if (position < 0 || position > size) {
            throw new IndexOutOfBoundsException();
        }
        if (position == 0) {
            insertHead(node);
        } else if (position == size) {
            insertTail(node);
        } else {
            DNode<T> current = head;
            for (int i = 0; i < position; i++) {
                current = current.getNext();
            }
            node.setPrevious(current.getPrevious());
            node.setNext(current);
            current.getPrevious().setNext(node);
            current.setPrevious(node);
            size++;
        }
    }

    public void sortedInsert(DNode<T> newNode) {
        if(!isSorted()){
            sort();
        }

        // If the list is empty, insert the new node as the head
        if (head == null) {
            insertHead(newNode);
            return;
        }
    
        // If the new node is less than the head node, insert it at the head
        if (newNode.getData().compareTo(head.getData()) < 0) {
            insertHead(newNode);
            return;
        }
    
        // If the new node is greater than the tail node, insert it at the tail
        if (newNode.getData().compareTo(tail.getData()) > 0) {
            insertTail(newNode);
            return;
        }
    
        // Search for the correct position to insert the new node
        DNode<T> currNode = head.getNext();
        while (currNode != null && newNode.getData().compareTo(currNode.getData()) > 0) {
            currNode = currNode.getNext();
        }
    
        // Insert the new node before the current node
        DNode<T> prevNode = currNode.getPrevious();
        newNode.setPrevious(prevNode);
        newNode.setNext(currNode);
        currNode.setPrevious(newNode);
        prevNode.setNext(newNode);
    
        size++;
    }

    public boolean isSorted() {
        if (head == null || head.getNext() == null) {
            // If the list is empty or has only one element, it is considered sorted
            return true;
        }
        DNode<T> current = head;
        while (current.getNext() != null) {
            if (current.getData().compareTo(current.getNext().getData()) > 0) {
                // If the current node is greater than the next node, the list is not sorted
                return false;
            }
            current = current.getNext();
        }
        // If we reach the end of the list without finding an out-of-order pair, it is sorted
        return true;
    }

    private void sort(){
        if (head == null || head.getNext() == null) {
            return; // The list is already sorted
        }
    
        DNode<T> current = head.getNext();
        while (current != null) {
            T data = current.getData();
            DNode<T> prev = current.getPrevious();
            while (prev != null && prev.getData().compareTo(data) > 0) {
                prev.getNext().setData(prev.getData());
                prev = prev.getPrevious();
            }
            if (prev == null) {
                head.setData(data);
            } else {
                prev.getNext().setData(data);
            }
            current = current.getNext();
        }
    }

    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }
    
    public void print() {
        System.out.println("List Length: " + size);
        System.out.println("Sorted Status: " + isSorted());
        System.out.println("List Contents:");
        if(head == null){
            System.out.println("List is empty");
        }
        var curNode = head;
        int i = 0;
        while(curNode != null){
            System.out.println("Node " + i + ": " + curNode.getData());
            curNode = curNode.getNext();
            i++;
        }
    }
}
