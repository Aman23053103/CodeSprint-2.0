import java.util.*;

public class Castlebfs {
    public static List<Integer> bfstraversal(int n, List<List<Integer>> adj) {
        List<Integer> result = new ArrayList<>();
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visited[0] = true;
        while (!queue.isEmpty()) {
            int current = queue.poll();
            result.add(current);
            for (int neighbour : adj.get(current)) {
                if (!visited[neighbour]) {
                    visited[neighbour] = true;
                    queue.add(neighbour);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of castles: ");
        int n = Integer.parseInt(sc.nextLine());
        List<List<Integer>> adj = new ArrayList<>();
        System.out.println("Enter adjacency list: ");
        for (int i = 0; i < n; i++) {
            System.out.print("Castle " + i + " connects to: ");
            String line = sc.nextLine().trim();
            List<Integer> neighbours = new ArrayList<>();
            if (!line.isEmpty()) {
                String[] parts = line.split("[,\\s]+");
                for (String part : parts) {
                    neighbours.add(Integer.parseInt(part));
                }
            }
            adj.add(neighbours);
        }
        List<Integer> order = bfstraversal(n, adj);
        System.out.println("Visiting order: " + order);
    }
}