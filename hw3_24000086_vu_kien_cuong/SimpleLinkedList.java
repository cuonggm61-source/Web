
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleLinkedList <T>{
    
    class Node{
        T data;
        Node next;

        public Node( T data){
            this.data = data;
            this.next = null;    
        }
        public Node(){
        }

    }

    private Node top = null;
    private Node bot = null;
    private int n = 0;

    public void add (T data){
        Node newNode = new Node(data);

        if(top == null){
            top = newNode;
            bot = newNode;
        }else {
            bot.next = newNode;
            bot = newNode;
        }
        n++;
    }

    public T get(int i){
        if(i < 0 || i > n){
            throw new IndexOutOfBoundsException();
        }

        Node newNode = top;
        for (int idx =0; idx < i;idx++){
            newNode = newNode.next;
        }
        return newNode.data;

    }

    public void set(int i, T data){
        if(i < 0 || i > n){
            throw new IndexOutOfBoundsException();
        }

        Node newNode = top;

        for(int idx = 0; idx < i; idx++){
            newNode = newNode.next;
        }
        newNode.data= data;
    }

    public void remove(int i){
        if(i < 0 || i > n){
            throw new IndexOutOfBoundsException();
        }

        if(i==0){
            top = top.next;
            if(top == null){
                bot = null;
            }
        }else {
            Node current = top;
            for(int idx = 0; idx < i -1; idx ++){
                current = current.next;
            }
            current.next = current.next.next;
            if(current.next == null){
                bot = current;
            }
        }
        n--;
    }
    public boolean isContain(T data){
        Node current = top;
        while(current!=null){
            if(current.data.equals(data)){
                return true;
            }
            current = current.next;
        }
        return false;
    }
    public int indexOf(T data){
        Node newNode =  top;
        for(int idx =0; idx < n;idx ++){
            if(newNode.data.equals(data)){
                return idx;
            }
            newNode = newNode.next;
        }
        return -1;
    }
    
    public int size(){
        return n;
    }
    public boolean isEmpty(){
        return n==0;
    }
    public Iterator<T> iterator(){
        return new LinkedListIterator();
    }
    class LinkedListIterator implements Iterator<T>{
        private  Node currentNode = top;
        public boolean hasNext(){
            return currentNode !=null;
        }
        public T next(){
            if(!hasNext()){
                throw new NoSuchElementException();
            }
            T data = currentNode.data;
            currentNode = currentNode.next;
            return data;
        }
    }
}
