public class StackClass {
    
    public static void pushAtBottom(int data, LinkedListStack <Integer> s){
        if(s.isEmpty()){
            s.push(data);
            return;
        }
        int top = s.pop();
        pushAtBottom(data, s);
        s.push(top);
    } 
    public static void main(String args[]){
        LinkedListStack<Integer> s= new LinkedListStack <>();
        s.push(1);
        s.push(2);
        s.push(3);

        for(Integer data : s){
            System.err.print(data + " ");
        }
    }


}
