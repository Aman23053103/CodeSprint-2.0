import java.util.*;

public class Castledfs {
    public static void dfs(int node, boolean[] visited, List<List<Integer>> adj, List<Integer> result) {
        visited[node] = true;
        result.add(node);
        for (int neighbour : adj.get(node)) {
            if (!visited[neighbour]) {
                dfs(neighbour, visited, adj, result);
            }
        }
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
        boolean[] visited = new boolean[n];
        List<Integer> result = new ArrayList<>();
        dfs(0, visited, adj, result);
        System.out.println("Exploration order: " + result);
    }
}