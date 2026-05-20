import java.util.Iterator;

public class LinkedListStack <E> implements StackInterface<E>{
    class Node {
        E element;
        Node next;
        public Node(){

        }
        public Node(E data){
            this.element = data;
            this.next =null;
        }
    }
    private Node stack = null;

    public void push(E element){
        Node newNode = new Node(element);
        if(stack == null){
            stack = newNode;
        }else{
            newNode.next = stack;
            stack = newNode;
        }
    }
    public E pop(){
        if (stack == null) {
            throw new java.util.NoSuchElementException("Stack is empty");
        }
        E element = stack.element;
        stack = stack.next;
        return element;
    }

    public boolean isEmpty(){
        return stack ==null;
    }   
    public E top(){
        if (stack == null) {
            throw new java.util.NoSuchElementException("Stack is empty");
        }
        E element = stack.element;
        return element;
    }

    public Iterator <E> iterator(){
        return new StackIterator();
    }
    class StackIterator implements Iterator<E>{
        private Node current = stack;
        public boolean hasNext(){
            return current!=null;
        }
        public E next(){
            E data = current.element;
            current = current.next;
            return data;
        }
    }


}
