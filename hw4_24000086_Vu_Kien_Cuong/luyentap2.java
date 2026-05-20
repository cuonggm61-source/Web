
class myStack {
    private final int n; 
    private final int[] stack; 
    private int count = 0; 

    public myStack(int n) {
        this.n = n;
        this.stack = new int[n];
    }
    public boolean isEmpty() {
        return count == 0; 
    }
    public boolean isFull() {
        return count >= n;
    }

    public void push(int x) {
        if (isFull()) {
            throw new StackOverflowError("Stack is full!"); 
        }
        stack[count] = x; 
        count++; 
    }
public int pop() {
    if (isEmpty()) {
        throw new java.util.EmptyStackException(); 
    }
    count--;
    return stack[count]; 
}

    public int peek() {
    if (count == 0) {
        throw new IndexOutOfBoundsException();
    }
    return stack[count - 1]; 
}

}