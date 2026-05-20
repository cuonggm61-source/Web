import java.util.Scanner;

public class Bai9 {
    class Node{
        int data;
        Node next;
        public Node(){

        }
        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    private Node top = null;
    private Node bot = null;
    private int n = 0;

    public void add(int data){
        Node newNode = new Node(data);
        if(top == null){
            top = newNode;
            bot = newNode;

        }else{
            bot.next = newNode;
            bot=newNode;
        }
        n++;
    }

    public Node reverseList(){
        Node pre = null;
        Node next = null;
        Node current = top;
        while(current != null){
            next = current.next;
            current.next = pre;
            pre =current;
            current = next;
        }
        return pre;
    }
    public boolean check(Node head1, Node head2){
        for(int i=0; i< n;i++){
            if(head1.data != head2.data){
                return false;
            }
        }
        return true;

    }
    public Node node(){
        Node current = top;
        return current;
    }

    public  void print(Node head ){
        Node current = head;
        while(current !=null){
            System.out.print(current.data+" ");
            current = current.next;
        }
    }
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Bai9 list = new Bai9();
        for(int i =0; i< n;i++){
            int x = sc.nextInt();
            list.add(x);
        }
        
       Node newNode = list.reverseList();
       System.out.println(list.check(list.node(), newNode));
    }




}
