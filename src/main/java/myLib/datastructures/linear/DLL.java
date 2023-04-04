package main.java.myLib.datastructures.linear;
import java.util.NoSuchElementException;

import main.java.myLib.datastructures.nodes.*;

/**
 * Doubly linked list class. Works with generic types and uses DNode objects as nodes.
 */
public class DLL<T extends Comparable<T>>{
    protected DNode<T> head;
    protected DNode<T> tail;
    protected int size;
    
    //Constructors
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

    /**
     * insertHead(DNode<T> node);
     * @param node - node to be inserted as head
     */
    public void insertHead(DNode<T> node) {
        if(search(node) != null){
            return;
        }
        if (size==0) {
            tail = node;
        } else {
            head.setPrevious(node);
            node.setNext(head);
        }
        head = node;
        size++;
    }

    /**
     * insertTail(DNode<T> node);
     * @param node - node to be inserted as tail
     */
    public void insertTail(DNode<T> node) {
        if(search(node) != null){
            return;
        }
        if (size==0) {
            head = node;
        } else {
            tail.setNext(node);
            node.setPrevious(tail);
        }
        tail = node;
        size++;
    }

    /**
     * insert(DNode<T> node, int position);
     * @param node - node to insert
     * @param position - position node will be inserted
     */
    public void insert(DNode<T> node, int position) {
        if(search(node) != null){
            return;
        }
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

    /**
     * sortedInsert(DNode<T> newNode)
     * This function will sort the linked list if it's not already sorted
     * and subsequently insert the node at its sorted location.
     * @param newNode - node to be inserted
     */
    public void sortedInsert(DNode<T> newNode) {
        if(search(newNode) != null){
            return;
        }
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

        if(newNode.getData().compareTo(tail.getData()) >= 0){
            insertTail(newNode);
        }
    
        // Search for the correct position to insert the new node
        DNode<T> currNode = head.getNext();
        while (currNode != tail.getNext() && newNode.getData().compareTo(currNode.getData()) > 0) {
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

    /**
     * search(DNode<T> node);
     * @param node - node to search for
     * @return node if found, null otherwise
     */
    public DNode<T> search(DNode<T> node){
        DNode<T> curr = head;
        for(int i = 0; i < size; i++) {
            if (curr.equals(node)) {
                return curr;
            }
            curr = curr.getNext();
        }
        return null;
    }

    /**
     * deleteHead();
     * deletes the current head of the list
     */
    public void deleteHead(){
        if(head == null){
            throw new NoSuchElementException();
        }
        head = head.getNext();
        head.setPrevious(null);
        size--;
        if (size == 0) {
            tail = null;
        }
    }

    /**
     * deleteTail();
     * deletes the current tail of
     * the list.
     */
    public void deleteTail() {
        if (tail == null) {
            throw new NoSuchElementException();
        }
        if (head == tail) {
            clear();
            return;
        }
        tail = tail.getPrevious();
        tail.setNext(null);
        size--;
    }

    /**
     * delete(DNode<T> node);
     * @param node - node to be deleted
     */
    public void delete(DNode<T> node){
        node = search(node);
        if(node == null){
            return;
        }
        if(node == head){
            deleteHead();
            return;
        }
        if(node == tail){
            deleteTail();
            return;
        }
        DNode<T> prevNode = node.getPrevious();
        DNode<T> nextNode = node.getNext();
        prevNode.setNext(nextNode);
        nextNode.setPrevious(prevNode);
        size--;
    }

    /**
     * isSorted();
     * @return true if sorted, false otherwise
     */
    public boolean isSorted() {
        if (head == null || head.getNext() == null) {
            // If the list is empty or has only one element, it is considered sorted
            return true;
        }
        DNode<T> current = head;
        while (current != tail) {
            if (current.getData().compareTo(current.getNext().getData()) > 0) {
                // If the current node is greater than the next node, the list is not sorted
                return false;
            }
            current = current.getNext();
        }
        // If we reach the end of the list without finding an out-of-order pair, it is sorted
        return true;
    }

    /**
     * sort();
     * Sorts the list using insertion sort.
     */
    public void sort(){
        if (head == null || head.getNext() == null) {
            return; // The list is already sorted
        }

        DNode<T> sortedList = null;
        DNode<T> curNode = head;

        for(int i = 0; i < size; i++){
            DNode<T> next = curNode.getNext();

            if(sortedList == null || curNode.getData().compareTo(sortedList.getData()) < 0){
                curNode.setNext(sortedList);
                if(sortedList != null){
                    sortedList.setPrevious(curNode);
                }
                sortedList = curNode;
            } else{
                DNode<T> prevNode = sortedList;
                while(prevNode.getNext() != null && prevNode.getNext().getData().compareTo(curNode.getData()) < 0){
                    prevNode = prevNode.getNext();
                }
                curNode.setNext(prevNode.getNext());
                curNode.setPrevious(prevNode);
                prevNode.setNext(curNode);
                if(curNode.getNext()!=null){
                    curNode.getNext().setPrevious(curNode);
                }
            }
            curNode = next;
        }
        if(sortedList != null){
            sortedList.setPrevious(null);
        }
        head = sortedList;
        curNode = head;
        while(curNode.getNext() != null){
            curNode = curNode.getNext();
        }
        tail = curNode;
    }

    /**
     * getNode(int position);
     * @param position -  position to get node at
     * @return node at the position specified
     */
    public DNode<T> getNode(int position){
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

    /**
     * clear();
     * deletes entire list
     */
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * print();
     * prints each item in the list, as well as the length and sorted status of the list.
     */
    public void print(){
        System.out.println("List Length: " + size);
        System.out.println("Sorted Status: " + isSorted());
        System.out.println("List Contents:");
        if(head == null){
            System.out.println("List is empty");
        }
        var curNode = head;
        for(int i = 0; i<size; i++){
            System.out.println("Node " + i + ": " + curNode.getData());
            curNode = curNode.getNext();
        }
    }

    /**
     * getHead();
     * @return head
     */
    public DNode<T> getHead(){
        return this.head;
    }

    /**
     * getTail();
     * @return tail
     */
    public DNode<T> getTail(){
        return this.tail;
    }

    /**
     * @return size of list
     */
    public int getSize(){
        return this.size;
    }
}
