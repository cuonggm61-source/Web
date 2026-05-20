

public class luyentap4 {

    public static boolean op(Character a, Character b){
        return false;
    }


    public static boolean isValid (String string){
        LinkedListStack <Character> stack = new LinkedListStack<>();
        for(int i =0 ; i < string.length(); i++){

            if(string.charAt(i) == '(' || string.charAt(i) == '{' || string.charAt(i) == '[' ){
                stack.push(string.charAt(i));;
            }
            else if(stack.isEmpty()){

                return false;
            }
            else if(string.charAt(i) == ')' || string.charAt(i) == '}' || string.charAt(i) == ']'){

                if(string.charAt(i) == ')'){
                    if(stack.pop() != '('){
                        return false;
                    }
                }
                else if(string.charAt(i) == '}'){
                    if(stack.pop() != '{'){
                        return false;
                    }
                }
                else if(string.charAt(i) == ']'){
                    if(stack.pop() != '['){
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] agrs){
        System.out.print(isValid("()"));
    }

}
