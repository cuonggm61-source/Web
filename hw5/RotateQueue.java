import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class RotateQueue {


    public Queue<Integer> rotate(int a[], int n, int k) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            queue.add(a[i]);
        }
        int effectiveK = k % n;
        for (int i = 0; i < effectiveK; i++) {
            int firstElement = queue.poll();
            queue.add(firstElement);
        }
        return queue;
    }
}
