package main.java.myLib.datastructures.nodes;

public class DNode<T>{
    private DNode<T> previous;
    private T data;
    private DNode<T> next;

    public DNode(T data){
        next = null;
        previous = null;
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public DNode<T> getPrevious(){
        return this.previous;
    }
    
    public void setPrevious(DNode<T> node){
        this.previous = node;
    }

    public DNode<T> getNext() {
        return next;
    }

    public void setNext(DNode<T> next) {
        this.next = next;
    }
}
