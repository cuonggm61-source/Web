import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class luyentap3 {
    
    public static void deleteMid(Stack<Integer> s) {
    List<Integer> temp = new ArrayList<>();

    
    while (!s.isEmpty()) {
        temp.add(s.pop());
    }
    
    int count = temp.size();
    int middleIndex = count / 2;
    for (int i = count - 1; i >= 0; i--) {
        if (i == middleIndex) { 
            continue;
        } else {
            s.push(temp.get(i)); 
        }
    }
    while(!s.isEmpty()){
        System.out.print(s.pop() + " ");
    }
}
    public static void main(String[] agrs){
        Stack<Integer> s= new Stack<>();
        s.add(1);
        s.add(2);
        s.add(3);
        deleteMid(s);
    }
}
