package dsaonl;
public class FormulaEval {

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

	public double eval(String formula)
	{
        formula = formula.replaceAll("\\s+","");
        LinkedListStack <Integer> value = new LinkedListStack<>();
        LinkedListStack <Character> op = new LinkedListStack<>();

        for(int i =0; i < formula.length();i++){
            char c = formula.charAt(i);

            if(c == '('){
                continue;
            }
            if(c >= '0' && c <= '9'){
                String s = "";
                while( i < formula.length() && formula.charAt(i) >= '0' && formula.charAt(i) < '9'){
                    s = s+ formula.charAt(i);                    
                    i++;
                }
                value.push(Integer.parseInt(s));
                i--;
            }
            else if(c == '+' || c == '-' || c == '*' || c == '/'){
                op.push(c);
            }
            else if(c == ')'){
                if(!op.isEmpty()){
                    char ops = op.pop();
                    int val1 = value.pop();
                    int val2 = value.pop();
                    value.push(applyOp(ops, val1, val2));
                }
            }
        }
        return value.pop();
	}
}
