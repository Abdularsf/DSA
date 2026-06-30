import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public List<Integer> dfsOfGraph(int V, List<List<Integer>> edges) {
        boolean[] vis = new boolean[V];
        List<Integer> ans = new ArrayList<>();
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for (List<Integer> edge : edges) {
            adj.get(edge.get(0)).add(edge.get(1));
            adj.get(edge.get(1)).add(edge.get(0));
        }
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                dfs(i, adj, ans, vis);
            }
        }
        return ans;
    }

    private void dfs(int node, List<List<Integer>> adj, List<Integer> ans, boolean[] vis) {
        ans.add(node);
        vis[node] = true;
        for (int elem : adj.get(node)) {
            if (!vis[elem]) {
                dfs(elem, adj, ans, vis);
            }
        }
    }

    public List<Integer> bfsOfGraph(int V, List<List<Integer>> edges) {
        boolean[] vis = new boolean[V];
        List<Integer> ans = new ArrayList<>();
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for (List<Integer> edge : edges) {
            adj.get(edge.get(0)).add(edge.get(1));
            adj.get(edge.get(1)).add(edge.get(0));
        }

        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                bfs(i, adj, ans, vis);
            }
        }

        return ans;
    }

    private void bfs(int node, List<List<Integer>> adj, List<Integer> ans, boolean[] vis) {
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        vis[node] = true;
        while (!q.isEmpty()) {
            int elem = q.poll();
            ans.add(elem);
            List<Integer> list = adj.get(elem);
            for (int i = 0; i < list.size(); i++) {
                if (!vis[list.get(i)]) {
                    q.add(list.get(i));
                    vis[list.get(i)] = true;
                }
            }
        }
    }
}
