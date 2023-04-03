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
        DLLTest();
    }

    public static void SLLTest(){
        SLL<Integer> sll = new SLL<>(nodeList.get(0));
        sll.insertHead(nodeList.get(1));
        sll.insertHead(nodeList.get(2));
        sll.insertHead(nodeList.get(3));
        sll.sortedInsert(nodeList.get(4));
        sll.print();
    }

    public static void DLLTest(){
        DLL<Integer> dll = new DLL<>(dNodeList.get(0));
        dll.insertHead(dNodeList.get(1));
        dll.insertHead(dNodeList.get(2));
        dll.insertHead(dNodeList.get(3));
        dll.insert(dNodeList.get(4), 0);
        dll.print();
    }
}
