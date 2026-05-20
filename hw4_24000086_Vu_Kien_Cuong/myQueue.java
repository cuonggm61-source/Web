
// Queue class
class myQueue {
    class Node {
        int data;
        Node next;

        Node(int new_data) {
            data = new_data;
            next = null;
        }
        Node(){
            
        }
    }
    Node top = null;
    Node count =null;
    int n = 0;
    

    public myQueue() {       
        // Initialize your data members
    }

    public boolean isEmpty() {
        return top == null;
        // check if the queue is empty
    }

    public void enqueue(int x) {  
        Node node = new Node(x);
        if(top == null){
            top = node;
            count = node;
        }else{
            count.next = node;
            count = node;
        }
        n++;
        // Adds an element x at the rear of the queue.
    }

    public void dequeue() {
        if(top  == null){
            System.out.print("loi vc");
            return;
        }else {
            top = top.next;
        }
        n--;
        // Removes the front element of the queue
    }

    public int getFront() {
        if(isEmpty()){
            return -1;
        }
        Node newNode = top;
        return newNode.data;
        // Returns the front element of the queue.
        // If queue is empty, return -1.
    }

    public int size() {
        return n;
        // Returns the current size of the queue.
    }
    public void print(){
        Node newNode = top;
        while(newNode!=null){
            System.out.print(newNode.data + " ");
            newNode = newNode.next;
        }
    }
    public static void main(String [] agrs){
        myQueue princess = new myQueue();
        princess.enqueue(1);
        princess.enqueue(2);
        princess.enqueue(3);
        princess.enqueue(4);
        System.out.println(princess.size());
        System.out.println(princess.getFront());
        princess.dequeue();
        princess.print();


    }
    
}

