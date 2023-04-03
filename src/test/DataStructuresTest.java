package test;
import main.java.myLib.datastructures.linear.*;
import main.java.myLib.datastructures.nodes.Node;

public class DataStructuresTest {
    public static void main(String args[]){
        Node<Integer> node1 = new Node<>(10);
        Node<Integer> node2 = new Node<>(50);
        Node<Integer> node3 = new Node<>(30);
        Node<Integer> node4 = new Node<>(40);
        Node<Integer> node5 = new Node<>(20);
        SLL<Integer> sll = new SLL<>(node1);
        sll.insertHead(node2);
        sll.insertHead(node1);
        sll.insertHead(node3);
        sll.insertHead(node4);
        sll.insertHead(node5);
        sll.print();
    }
}
