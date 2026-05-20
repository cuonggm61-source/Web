package hw3_24000086_vu_kien_cuong;
import java.util.Scanner;

public class Bai5 {
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
    private Node top = null;
    private int n =0;

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


    public int  countElemnt(){
        int count =0;
        Node current = top;
        while(current!=null){
            current = current.next;
            count++;
        }
        return count;
    }
    public static void main(String[]agrs){
        Bai5 list = new Bai5();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=0; i< n;i++){
            int x = sc.nextInt();
            list.add(x);
        }
        int element = list.countElemnt();
        System.out.print(element);
    }
}
