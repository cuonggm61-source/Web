import java.util.Scanner;

public class Bai12 {
    class Node{
        int data;
        Node next;
        Node prev;
        public Node(){

        }
        public Node(int data){
            this.data= data;
            this.next = null;
            this.prev = null;
        }
    }
    private Node top = null;
    private Node bot = null;
    private int n =0;

    public void add(int data, int k){
    if (k < 0 || k > n) { 
        
        throw new IndexOutOfBoundsException();
    }

    Node newNode = new Node(data);
    if (top == null) {
        top = newNode;
        bot = newNode;
    } 
    else if (k == 0) {
        newNode.next = top;
        top.prev = newNode;
        top = newNode;
    } 
    else if (k == n) {
        bot.next = newNode;
        newNode.prev = bot;
        bot = newNode;
    } 
    else {
        Node current = top;
        for (int i = 0; i < k - 1; i++) {
            current = current.next;
        }
     
        newNode.next = current.next;
        newNode.prev = current;
    
        current.next.prev = newNode; 
        current.next = newNode;     
    }
    n++;
}
    public void add(int data){
        Node newNode = new Node(data);
        if(top==null){
            top = newNode;
            bot = newNode;
        }else {
            bot.next = newNode;
            newNode.prev = bot;
            bot = newNode;
        }
    }
    public void print(){
        Node current = top;
        while(current!=null){
            System.out.print(current.data + " ");
            current = current.next;
        }
    }

    public static void main(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Bai12 list = new Bai12();
        for(int i =0; i< n;i++){
            int x = sc.nextInt();
            list.add(x);
        }
        list.print();
    }



}
