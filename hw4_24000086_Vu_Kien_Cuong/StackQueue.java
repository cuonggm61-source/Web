// User function Template for Java
class StackQueue {
    class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    Node top =null;
    Node bot = null;
    int n = 0;

    public void push(int B) {
        // code here
        Node newNode = new Node(B);
        if(top==null){
            top = newNode;
            bot = newNode;
        }else{
            bot.next = newNode;
            bot = newNode;
        }
        n++;
    }

   public int pop() {
    if (top == null) {
        return -1; 
    }

    int e = top.data;
    top = top.next;
    n--; 
    if (top == null) {
        bot = null;
    }
    return e;
}
}