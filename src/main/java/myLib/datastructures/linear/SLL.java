package main.java.myLib.datastructures.linear;
import java.util.NoSuchElementException;

import main.java.myLib.datastructures.nodes.*;

public class SLL<T extends Comparable<T>> {
    
    private Node<T> head;
    private Node<T> tail;
    private int size;
    
    // Default constructor
    public SLL() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    
    // Overload constructor with Node argument
    public SLL(Node<T> head) {
        this.head = head;
        this.tail = head;
        this.size = 1;
    }
    
    // Insert node at head of the list
    public void insertHead(Node<T> node) {
        if (head == null) {
            head = node;
            tail = node;
        } else {
            node.setNext(head);
            head = node;
        }
        size++;
    }
    
    // Insert node at tail of the list
    public void insertTail(Node<T> node) {
        if (tail == null) {
            head = node;
            tail = node;
        } else {
            tail.setNext(node);
            tail = node;
        }
        size++;
    }
    
    // Insert node in the specified position
    public void insert(Node<T> node, int position) {
        if (position < 0 || position > size) {
            throw new IndexOutOfBoundsException();
        } else if (position == 0) {
            insertHead(node);
        } else if (position == size) {
            insertTail(node);
        } else {
            Node<T> prev = getNode(position - 1);
            node.setNext(prev.getNext());
            prev.setNext(node);
            size++;
        }
    }
    
    // Inserts node object in its proper position in a sorted list
    public void sortedInsert(Node<T> node) {
        if (isSorted()){
            sort();
        }
        if (head == null || node.getData().compareTo(head.getData()) <= 0) {
            insertHead(node);
            return;
        }
        Node<T> curr = head;
        while (curr.getNext() != null && node.getData().compareTo(curr.getNext().getData()) > 0) {
            curr = curr.getNext();
        }
        node.setNext(curr.getNext());
        curr.setNext(node);
        size++;
    }
    
    // Looks up node in the list
    public Node<T> search(Node<T> node) {
        Node<T> curr = head;
        while (curr != null) {
            if (curr.equals(node)) {
                return curr;
            }
            curr = curr.getNext();
        }
        return null;
    }
    
    // Delete head node
    public void deleteHead() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        head = head.getNext();
        size--;
        if (size == 0) {
            tail = null;
        }
    }
    
    // Delete tail node
    public void deleteTail() {
        if (tail == null) {
            throw new NoSuchElementException();
        }
        if (head == tail) {
            head = null;
            tail = null;
            size--;
            return;
        }
        Node<T> curr = head;
        while (curr.getNext() != tail) {
            curr = curr.getNext();
        }
        curr.setNext(null);
        tail = curr;
        size--;
    }

    public void delete(Node<T> node){
        node = search(node);
        if(node == null){
            return;
        }
        if(node == head){
            deleteHead();
        }
        if(node == tail){
            deleteTail();
        }
        Node<T> curNode = head;
        while(curNode.getNext() != node){
            curNode = curNode.getNext();
        }
        curNode.setNext(node.getNext());
        size--;
    }

    private Node<T> getNode(int position){
        if (position < 0 || position > size) {
            throw new IndexOutOfBoundsException();
        } else if (position == 0) {
            return head;
        } else if (position == size) {
            return tail;
        } else {
            var curNode = head;
            for(int i=0 ; i < position; i++){
                curNode = curNode.getNext();
            }
            return curNode;
        }
    }

    public boolean isSorted() {
        if (head == null || head.getNext() == null) {
            // If the list is empty or has only one element, it is considered sorted
            return true;
        }
        Node<T> current = head;
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
            // If the list is empty or has only one element, it is considered sorted
            return;
        }
            // use insertion sort algorithm to sort the list
        Node<T> prev = head;
        Node<T> curr = head.getNext();

        while (curr != null) {
            Node<T> node = curr.getNext();
            prev.setNext(null);

            if (curr.getData().compareTo(head.getData()) < 0) {
                curr.setNext(head);
                head = curr;
            } else {
                Node<T> temp = head;
                while (temp.getNext() != null) {
                    if (curr.getData().compareTo(temp.getNext().getData()) < 0) {
                        curr.setNext(temp.getNext());
                        temp.setNext(curr);
                        break;
                    }
                    temp = temp.getNext();
                }
                if (temp.getNext() == null) {
                    temp.setNext(curr);
                    curr.setNext(null);
                }
            }
            curr = node;
        }
        // update tail pointer
        Node<T> temp = head;
        while (temp.getNext() != null) {
            temp = temp.getNext();
        }
        tail = temp;
    }

    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    public void print(){
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
        }
    }
}