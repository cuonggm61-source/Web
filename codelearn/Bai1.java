package codelearn;
public class Bai1 {
    class Node{
        int data;
        Node next;
        Node prev;
        public Node(){

        }
        public Node(int data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }
    private Node top=null;
    private Node bot =null;
    private int n =0;

    public void add(int data){
        Node newNode = new Node(data);
        if(top==null){
            top = newNode;
            bot = newNode;
        }else{
            bot.next = newNode;
            newNode.prev = bot;
            bot = newNode;
        }
    }
    public String listLinker(int arg1) {
        String s = "";
        for(int i=arg1;i >= 1 ;i--){
            add(i);
        }
        Node current = top;
        while(current.next!=null){
            s = s +" "+ current.data;
            current = current.next;
        }
        while (current!=null){
            s = s + " " + current.data;
            current =current.prev;
        }
        return s;
    }
    public static void main(String[] args) {
        Bai1 list = new Bai1();
        System.out.print(list.listLinker(7));
    }
}
