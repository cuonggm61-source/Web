
import java.util.Iterator;

public class LinkedListQueue <E> implements QueueInterface<E>{
    class Node{
        E data;
        Node next = null;
        public Node(){

        }
        public Node(E data){
            this.data = data;
            this.next=null;
        }
    }
    Node queue =null;
    Node rear = null;
    public void enqueue(E element){
        Node newNode = new Node(element);
        if(queue == null){
            queue = newNode;
            rear = newNode;
        }else {
            rear.next = newNode;
        }
        rear = newNode;
    }
    public E dequeue(){
        if(queue!= null){
            Node node = queue;
            E element = node.data;
            queue = queue.next;
            if(node == rear){
                rear = null;
            }
            return element;
        }
        return null;
    }
    public boolean isEmpty(){
        return queue == null;
    }
    public Iterator <E> iterator(){
        return new QueueIterator();
    }
    class QueueIterator implements Iterator<E>{
        Node current = queue;

        public boolean hasNext(){
            return queue != null;
        }
        public E next(){
            E data = current.data;
            current= current.next;
            return null;
        }
    }

}
