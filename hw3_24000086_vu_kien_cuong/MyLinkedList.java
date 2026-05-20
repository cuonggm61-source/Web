
class MyLinkedList {
     class Node{
        int data;
        Node next;

        public Node( int data){
            this.data = data;
            this.next = null;    
        }
        public Node(){
        }

    }

    private Node top = null;
    private int n = 0;


    public MyLinkedList() {
        
    }
    
  public int get(int index) {
    if (index < 0 || index >= n) {
        throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + n);
    }
    Node current = top; 
    for (int i = 0; i < index; i++) {
        current = current.next;
    }
    if(current!=null){
        return current.data;
    }
    return 0;
}
    
    public void addAtHead(int val) {
        Node current = new Node(val);
        current.next = top;
        top = current;
        n++;
    }
    
   public void addAtTail(int val) {
    Node newNode = new Node(val);
    if (top == null) { 
        top = newNode;
    } else {
        Node current = top;
        while (current.next != null){
            current=current.next;
        }
        current.next = newNode;
    }
    n++;
}
    
    public void addAtIndex(int index, int val) {
        Node current = top;
        Node newNode = new Node(val);
        if(index <0 || index >=n){
            throw new IndexOutOfBoundsException();
        }
        if(index == 0){
            newNode.next = top;
            top = newNode; 
        }else {
            for(int i =0; i < index -1;i++){
                current=current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
        n++;
    }
    
    public void deleteAtIndex(int index) {
         if(index <0 || index >=n){
            throw new IndexOutOfBoundsException();
        }
        Node current = top;
        if(index == 0){
            top = top.next;
        }else {
            for(int i =0; i < index -1;i++){
                current=current.next;
            }
            current.next = current.next.next;
        }
        
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */