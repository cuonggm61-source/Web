
import java.util.*;

public class AdjacencyListBuilder {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // BƯỚC 1: Đọc số lượng đỉnh (N) và cạnh (M)
        System.out.print("Nhập số lượng đỉnh N: ");
        int N = scanner.nextInt(); 
        
        System.out.print("Nhập số lượng cạnh M: ");
        int M = scanner.nextInt();
        List<List<Integer>> adj = new ArrayList<>(N); 
        for (int i = 0; i < N; i++) {
            adj.add(new LinkedList<>()); 
        }

       
        System.out.println("Nhập M cạnh (u v) mỗi cạnh trên một dòng:");
        for (int i = 0; i < M; i++) {
            int u = scanner.nextInt(); 
            int v = scanner.nextInt(); 

            // Kiểm tra tính hợp lệ của đỉnh
            if (u < 0 || u >= N || v < 0 || v >= N) {
                System.out.println("Cảnh báo: Đỉnh " + u + " hoặc " + v + " nằm ngoài phạm vi [0, " + (N-1) + "]. Bỏ qua cạnh.");
                continue; 
            }
            
            // Xây dựng đồ thị VÔ HƯỚNG
            // 1. Thêm v vào danh sách kề của u
            adj.get(u).add(v); 
            
            // 2. Thêm u vào danh sách kề của v
            adj.get(v).add(u); 
        }

        // KẾT QUẢ: In ra Danh sách kề đã xây dựng
        System.out.println("\n--- Danh sách kề (Adjacency List) ---");
        for (int i = 0; i < N; i++) {
            System.out.println("Đỉnh " + i + ": " + adj.get(i));
        }

        scanner.close(); 
    }
}