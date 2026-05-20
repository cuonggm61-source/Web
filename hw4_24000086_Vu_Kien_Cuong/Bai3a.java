import java.util.Stack;
public class Bai3a {
    public static boolean checkBalance (String string){
        Stack <Character> stack = new Stack<>();
        
        for(int i =0; i< string.length();i++){
            if(string.charAt(i) == '('){
                stack.push(string.charAt(i));
            }else if(string.charAt(i)==')'){
                if(stack.isEmpty()){
                    return false;
                }
                char top = stack.pop();
                if(top != '('){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
    public static void main(String[] args) {
        System.err.println("xem " +checkBalance("(a-b)*(c+d)"));
    }

}
