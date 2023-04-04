package main.java.myLib.datastructures.nodes;

/*
 * DNode class used by DLL and CDLL. Stores previous and next nodes.
 */
public class DNode<T>{
    private DNode<T> previous;
    private T data;
    private DNode<T> next;

    //Constructor

    public DNode(T data){
        next = null;
        previous = null;
        this.data = data;
    }

    /**
     * @return data belonging to this node
     */
    public T getData() {
        return data;
    }

    /**
     * @param data - data to update node with
     */
    public void setData(T data) {
        this.data = data;
    }

    /**
     * @return previous node
     */
    public DNode<T> getPrevious(){
        return this.previous;
    }

    /**
     * @param node - node to set as previous
     */
    public void setPrevious(DNode<T> node){
        this.previous = node;
    }

    /**
     * @return next node
     */
    public DNode<T> getNext() {
        return next;
    }

    /**
     * @param next - node to set as next
     */
    public void setNext(DNode<T> next) {
        this.next = next;
    }
}
