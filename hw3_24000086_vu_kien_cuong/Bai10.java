
import static java.util.Arrays.sort;
import java.util.Scanner;

public class Bai10 {
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
        Node newNode= new Node(data);
        if(top ==null){
            bot = newNode;
            top = newNode;

        }else{
            bot.next = newNode;
            bot = newNode;
        }
        n++;
    }
    public Node newNode(){
        int[] arr = new int[n];
        Node current = top; 
        int count =0;
        while(current != null){
            arr[count] = current.data;
            current= current.next;
            count ++;
        }
        sort(arr);

        if(n == 0) return null; 

        Node head = new  Node(arr[0]);
        Node tail = head;

        for(int i = 1; i < arr.length; i++){
            Node newNode = new Node(arr[i]);
            tail.next = newNode;
            tail = newNode; 
        }
        return head;
    }
    public void check(Node head){
        Node current = head;
        while(current.next !=null){
            if(current.data == current.next.data){
                current.next = current.next.next;
            }else {
                current = current.next;
            }   
        }
    }
    public void print(Node head){
        Node current = head;
        while (current !=null){
            System.out.print(current.data + " ");
            current = current.next;
        }
    }

    public static void main(String [] agrs){
        Scanner sc= new Scanner(System.in);
        int x = sc.nextInt();
        Bai10 list = new Bai10();
        for(int i=0; i <x ;i++){
            int temp = sc.nextInt();
            list.add(temp);
        }
        Node node = list.newNode();
        list.check(node);
        list.print(node);

    }



}
