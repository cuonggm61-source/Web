package codelearn;
import java.util.*;
class GfG {
    static ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj, int top, int bot) {
        int V = adj.size();       
        int s = top; 
        ArrayList<Integer> res = new ArrayList<>();     
        Queue<Integer> q = new LinkedList<>();

        boolean[] visited = new boolean[V];
        int[] pre = new int[V];
        Arrays.fill(pre,-1);
        
        visited[s] = true;
        q.add(s);

        while (!q.isEmpty()) {
            int curr = q.poll();
            res.add(curr);
            for (int x : adj.get(curr)) {
                if (!visited[x]) {
                    pre[x] = curr;
                    visited[x] = true;
                    q.add(x);
                }
            }
        }
        int count = bot;
        ArrayList<Integer> path = new ArrayList<>();
        while(count != -1){
            path.add(count);
            count = pre[count];
        }
        return path;
    }
    
    public static void main(String[] args) {
     
       
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        adj.add(new ArrayList<>(Arrays.asList(1, 2)));
        adj.add(new ArrayList<>(Arrays.asList(0, 2, 3)));       
        adj.add(new ArrayList<>(Arrays.asList(0, 4)));       
        adj.add(new ArrayList<>(Arrays.asList(1,4)));          
        adj.add(new ArrayList<>(Arrays.asList(2,3)));          
        
        
        ArrayList<Integer> ans = bfs(adj,0,4);
        for (int i : ans) {
            System.out.print(i + " ");
        }
    }
}