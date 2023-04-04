package test;
import main.java.myLib.datastructures.linear.*;
import main.java.myLib.datastructures.nodes.*;
import java.util.*;

public class DataStructuresTest {
    private static ArrayList<Node<Integer>> nodeList = new ArrayList<>();
    private static ArrayList<DNode<Integer>> dNodeList = new ArrayList<>();
    public static void main(String args[]){
        nodeList.add(new Node<>(10));
        nodeList.add(new Node<>(50));
        nodeList.add(new Node<>(30));
        nodeList.add(new Node<>(40));
        nodeList.add(new Node<>(20));
        dNodeList.add(new DNode<>(10));
        dNodeList.add(new DNode<>(50));
        dNodeList.add(new DNode<>(30));
        dNodeList.add(new DNode<>(40));
        dNodeList.add(new DNode<>(20));
        CDLLTest();
    }

    public static void SLLTest(){
        SLL<Integer> sll = new SLL<>(nodeList.get(0));
        sll.insertHead(nodeList.get(1));
        sll.insertHead(nodeList.get(3));
        sll.sortedInsert(nodeList.get(2));
        sll.sortedInsert(nodeList.get(4));
        sll.print();
        sll.delete(nodeList.get(2));
        sll.print();
        sll.deleteHead();
        sll.print();
        sll.deleteTail();
        sll.print();
    }

    public static void DLLTest(){
        DLL<Integer> dll = new DLL<>(dNodeList.get(0));
        dll.insertHead(dNodeList.get(1));
        dll.insertHead(dNodeList.get(2));
        dll.insertHead(dNodeList.get(3));
        dll.sortedInsert(dNodeList.get(4));
        dll.print();
        dll.delete(dNodeList.get(2));
        dll.print();
        dll.deleteHead();
        dll.print();
        dll.deleteTail();
        dll.print();
    }

    public static void CSLLTest(){
        CSLL<Integer> csll = new CSLL<>(nodeList.get(0));
        csll.insertHead(nodeList.get(1));
        csll.insertHead(nodeList.get(3));
        csll.sortedInsert(nodeList.get(2));
        csll.sortedInsert(nodeList.get(4));
        csll.print();
        csll.delete(nodeList.get(2));
        csll.print();
        csll.deleteHead();
        csll.print();
        csll.deleteTail();
        csll.print();
    }

    public static void CDLLTest(){
        CDLL<Integer> cdll = new CDLL<>(dNodeList.get(0));
        cdll.insertHead(dNodeList.get(1));
        cdll.insertHead(dNodeList.get(2));
        cdll.insertHead(dNodeList.get(3));
        cdll.sortedInsert(dNodeList.get(4));
        cdll.print();
        cdll.delete(dNodeList.get(2));
        cdll.print();
        cdll.deleteHead();
        cdll.print();
        cdll.deleteTail();
        cdll.print();
    }
}
