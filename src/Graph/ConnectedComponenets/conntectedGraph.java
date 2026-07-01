package Graph.ConnectedComponenets;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class connectedGraph {
    // Function for BFS traversal
    private void bfs(int node, List<Integer>[] adjLs, boolean[] vis) {
        vis[node] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(node);

        while (!q.isEmpty()) {
            int i = q.poll();
            for (int adjNodes : adjLs[i]) {
                if (!vis[adjNodes]) {
                    vis[adjNodes] = true;
                    q.add(adjNodes);
                }
            }
        }
    }

    // private void dfs(int node, List<Integer>[] adjLs,
    // boolean[] vis) {
    // vis[node] = true;

    // for (int it : adjLs[node]) {
    // if (!vis[it]) {
    // dfs(it, adjLs, vis);
    // }
    // }
    // }
    public int findNumberOfComponent(int V, List<List<Integer>> edges) {
        int E = edges.size();
        @SuppressWarnings("unchecked")
        List<Integer>[] adjLs = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adjLs[i] = new ArrayList<>();
        }
        for (int i = 0; i < E; i++) {
            adjLs[edges.get(i).get(0)].add(edges.get(i).get(1));
            adjLs[edges.get(i).get(1)].add(edges.get(i).get(0));
        }
        boolean[] vis = new boolean[V];
        int cnt = 0;
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                cnt++;
                bfs(i, adjLs, vis);
                // dfs(i, adjLs, vis);
            }
        }

        // Return the count
        return cnt;
    }

    public static void main(String[] args) {

        int V = 7;

        List<List<Integer>> edges = new ArrayList<>();

        edges.add(List.of(0, 1));
        edges.add(List.of(0, 2));
        edges.add(List.of(1, 2));
        edges.add(List.of(3, 4));
        edges.add(List.of(5, 6));

        connectedGraph obj = new connectedGraph();

        int components = obj.findNumberOfComponent(V, edges);

        System.out.println("Number of Connected Components = " + components);
    }
}