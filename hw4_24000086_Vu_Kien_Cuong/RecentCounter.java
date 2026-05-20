
import java.util.LinkedList;

class RecentCounter {
    // thay vi dung queue thi ta se su dung LinkedList luon
    
    private LinkedList<Integer> times;

    public RecentCounter() {
        this.times = new LinkedList<>();
    }

    public int ping(int t) {
        times.add(t);
        int windowStart = t - 3000;
        while (!times.isEmpty() && times.peek() < windowStart) {
            times.removeFirst();
        }
        return times.size();
    }
}