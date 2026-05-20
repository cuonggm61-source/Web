
import java.util.Scanner;

public class Bai6 {
    public class Node{
        int data;
        Node next;

        public Node(int data){
            this.data= data;
            this.next = null;
        }
        public Node(){

        }
    }
    private Node top =null;
    int n =0;
    public void add (int data){
        Node newNode = new Node(data);
        Node current = top;
        if(top == null){
            top = newNode;
        }else {
            while(current.next!=null){
                current=current.next;
            }
            current.next = newNode;
        }
        n++;
    }
    public int indexElement(int k){
        if(k < 0 || k >n){
            return -1;
        }

        Node current = top;
        for(int i =0; i < n-k;i++){
            current= current.next;
        }
        int data = current.data;
        return data;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Bai6 list = new Bai6();
        for(int i =0; i< n;i++){
            int x = sc.nextInt(); 
            list.add(x);      
        }
        int second = list.indexElement(5);
        System.out.print(second);
        
    }



    
}
