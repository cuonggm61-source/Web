
public class Bai5 {
    public static boolean isPalindrome(String string){
        LinkedListStack <Character> stack = new LinkedListStack<>();
        LinkedListQueue <Character> deque = new LinkedListQueue<>();
        string = string.replaceAll("\\s+","");
        for(int i=0; i < string.length();i++){
            stack.push(string.charAt(i));
            deque.enqueue(string.charAt(i));
        }
        for(int i=0; i< string.length();i++){
            if(stack.pop() != deque.dequeue()){
                return false;
            }
        }
        return true;
    }


    public static void main(String[] agrs){
        String s ="level";
        System.out.print(isPalindrome(s));
    }

}
