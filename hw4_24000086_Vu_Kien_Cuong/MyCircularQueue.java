class MyCircularQueue {
    int[] arr;
    int font =0; 
    int count =0;
    int n;


    public MyCircularQueue(int k) {
        n = k;
        arr = new int[k];
    }
    
    public boolean enQueue(int value) {
        if(count < n){
            int index = (count + font ) % n;
            arr[index] = value;
            count++;
            return true;
        }
        return false;
    }
    
    public boolean deQueue() {
        if(count  > 0){
            int element = arr[font];
            font++;
            count--;
            if(font == n){
                font = 0;
            }
            return true;
        }
        return false;
        
    }
    
    public int Front() {
        if(count > 0){
            return arr[font];
        }
        return -1;
    }
    
    public int Rear() {
        if (count == 0) return -1;
        int rear = (font + count - 1) % n;
        return arr[rear];
    }
    
    public boolean isEmpty() {
        return count == 0;
    }
    
    public boolean isFull() {
        return count == n;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */