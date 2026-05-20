import java.util.Stack;

public class luyentap5 {
    public static int op(char x, int a, int b) {
        switch (x) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            case '/': return a / b;
        }
        return 0;
    }

    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(op(token.charAt(0), a, b));
            } else {
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }

    public static void main(String[] args) {
        String[] string = {"4","13","5","+","+"};
        System.out.println(evalRPN(string)); 
    }
}
