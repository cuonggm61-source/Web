import java.util.Scanner;

public class bai3 {
    class Node {
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node top = null;
    private Node bot = null;
    private int n = 0;

    public void add(int data) {
        Node newNode = new Node(data);
        if (top == null) {
            top = newNode;
            bot = newNode;
        } else {
            bot.next = newNode;
            bot = newNode;
        }
        n++;
    }
    public void insert(int x, int k){
        if(k < 0 || k >= n){
            throw new IndexOutOfBoundsException();
        }
        if(k==0){
            add(x);
        }

        Node newNode = new Node(x);
        Node current = top;
        for(int i =0; i < k-1;i++){
            current = current.next;
        }
        newNode.next = current.next;
        current.next = newNode;
        while(current!=null){
            current = current.next;
            bot = current;
        }
        n++;
    }
    public void erase(int k){
        if( k < 0 || k>=n){
            throw new IndexOutOfBoundsException();
        }
        if(k==0){
            top = top.next;
        }
        Node current = top;
        for(int i =0; i < k-1;i++){
            current = current.next;
        }
        current.next = current.next.next;
        n--;
    }
    public int find(int k){
        Node current = top;
        if( k < 0 || k>=n){
            throw new IndexOutOfBoundsException();
        }
        if(k==0){
            return current.data;
        }else {
           for(int i =0; i< k -1 ;i++){
            current = current.next;
           }
        }
        return current.data;
    }
    public void swap(int a, int b){
        Node current = top;
        while(current!=null){
            if(current.data == a){
                current.data = b;
            }
            current = current.next;
        }
    }
  
public void removeGreaterThan(int k) {
    while (top != null && top.data > k) {
        top = top.next; 
        n--;
    }
    if (top == null) {
        return;
    }
    Node current = top;
    while (current.next != null) {
        if (current.next.data > k) {
            
            current.next = current.next.next;
            n--;
        } else {
            current = current.next;
        }
    }
}


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        bai3 list = new bai3();             

        int count = sc.nextInt();          
        for (int i = 0; i < count; i++) {
            int x = sc.nextInt();
            list.add(x);                  
        }
        sc.close();

        Node current = list.top;
        list.insert(7, 2);        
        list.erase(2);   
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}
