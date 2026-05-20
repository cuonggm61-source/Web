import java.util.Stack;

public class Bai3b {

    public static int applyOp(char op, int b, int a) {
       switch (op) {
           case '+' : return a +b;
           case '-' : return a-b;
           case '*' : return a*b;
           case '/' : if(b==0) System.err.println("Khong duoc");
           else{
            return a/b;
           }
       }
        return 0;
    }

    public static int evaluate(String string) {
        string = string.replaceAll("\\s+", ""); 

        Stack<Integer> values = new Stack<>();
        Stack<Character> ops = new Stack<>();  

        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);

            if (c == '(') {
                continue; 
            }
        
            if (c >= '0' && c <= '9') {
                StringBuffer sbuf = new StringBuffer();
                while (i < string.length() && string.charAt(i) >= '0' && string.charAt(i) <= '9') {
                    sbuf.append(string.charAt(i++));
                }

                values.push(Integer.parseInt(sbuf.toString()));
                i--; 
            } 
            else if (c == '+' || c == '-' || c == '*' || c == '/') {
                ops.push(c);
            } 
            else if (c == ')') {
                if (!ops.isEmpty()) {
                    char op = ops.pop();
                    int val2 = values.pop();
                    int val1 = values.pop();
                    values.push(applyOp(op, val2, val1));
                }
            }
        }
        return values.pop();
    }

    public static void main(String[] args) {
        String ex1 = "(1 + ((2 + 3) * (8 * 5)))";
        String ex2 = "(5 - (8 - 4) * (2 + 3)) + (8 / 4)";      
        System.out.println("1: " + evaluate(ex1)); 
    }
}