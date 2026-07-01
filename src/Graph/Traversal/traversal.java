package src.Graph.Traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class traversal {

    // DFS Traversal
    public List<Integer> dfsOfGraph(int V, List<List<Integer>> edges) {
        boolean[] vis = new boolean[V];
        List<Integer> ans = new ArrayList<>();
        List<List<Integer>> adj = new ArrayList<>();

        // Create adjacency list
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Undirected graph
        for (List<Integer> edge : edges) {
            adj.get(edge.get(0)).add(edge.get(1));
            adj.get(edge.get(1)).add(edge.get(0));
        }

        // Handle disconnected graph
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                dfs(i, adj, ans, vis);
            }
        }

        return ans;
    }

    private void dfs(int node, List<List<Integer>> adj, List<Integer> ans, boolean[] vis) {
        vis[node] = true;
        ans.add(node);

        for (int next : adj.get(node)) {
            if (!vis[next]) {
                dfs(next, adj, ans, vis);
            }
        }
    }

    public List<Integer> bfsOfGraph(int V, List<List<Integer>> edges) {
        boolean[] vis = new boolean[V];
        List<Integer> ans = new ArrayList<>();
        List<List<Integer>> adj = new ArrayList<>();

        // Create adjacency list
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Undirected graph
        for (List<Integer> edge : edges) {
            adj.get(edge.get(0)).add(edge.get(1));
            adj.get(edge.get(1)).add(edge.get(0));
        }

        // Handle disconnected graph
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                bfs(i, adj, ans, vis);
            }
        }

        return ans;
    }

    private void bfs(int node, List<List<Integer>> adj, List<Integer> ans, boolean[] vis) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(node);
        vis[node] = true;

        while (!q.isEmpty()) {
            int curr = q.poll();
            ans.add(curr);

            for (int next : adj.get(curr)) {
                if (!vis[next]) {
                    vis[next] = true;
                    q.offer(next);
                }
            }
        }
    }

    public static void main(String[] args) {

        int V = 7;

        List<List<Integer>> edges = new ArrayList<>();

        edges.add(List.of(0, 1));
        edges.add(List.of(0, 2));
        edges.add(List.of(1, 3));
        edges.add(List.of(2, 4));
        edges.add(List.of(5, 6));

        traversal solution = new traversal();

        System.out.println("DFS Traversal:");
        System.out.println(solution.dfsOfGraph(V, edges));

        System.out.println("BFS Traversal:");
        System.out.println(solution.bfsOfGraph(V, edges));
    }
}