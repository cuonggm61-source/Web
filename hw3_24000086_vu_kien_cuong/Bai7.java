import java.util.Scanner;

public class Bai7 {
    class Node {
        int data;
        Node next;
        public Node(int data){
            this.data = data;
            this.next = null;
        }
        public Node(){

        }
    }

    private Node top = null;
    int n=0;

    public void add(int data){

        Node newNode = new Node(data);
        Node current = top;

        if(top==null){
            top = newNode;
        }else{
            while(current.next!=null){
                current = current.next;
            }
            current.next = newNode;
        }
        n++;
    }
    public int countElemnt(int data){
        Node current = top;
        int count =0;
        while(current != null){
            if(current.data == data){
                count++;
            }
            current = current.next;
        }
        return count;
    }
    
    public static void main(String[]agrs){
        Bai7 list1 = new Bai7();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=0; i< n;i++){
            int x = sc.nextInt();
            list1.add(x);
        }
        int element = list1.countElemnt(2);
        System.out.print(element);
    }
}
