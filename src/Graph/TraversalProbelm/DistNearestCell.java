package src.Graph.TraversalProbelm;

import java.util.LinkedList;
import java.util.Queue;

class Pair {
    int first;
    int second;
    int steps;

    Pair(int first, int second, int steps) {
        this.first = first;
        this.second = second;
        this.steps = steps;
    }
}

public class DistNearestCell {
    public int[][] nearest(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        int[][] dis = new int[n][m];
        Queue<Pair> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    q.add(new Pair(i, j, 0));
                } else {
                    vis[i][j] = 0;
                }
            }
        }
        int[] delRow = { -1, 0, 1, 0 };
        int[] delCol = { 0, 1, 0, -1 };

        while (!q.isEmpty()) {
            int row = q.peek().first;
            int col = q.peek().second;
            int step = q.peek().steps;
            dis[row][col] = step;
            q.poll();
            for (int i = 0; i < 4; i++) {
                int nrow = row + delRow[i];
                int ncol = col + delCol[i];

                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && vis[nrow][ncol] != 1) {
                    vis[nrow][ncol] = 1;
                    q.add(new Pair(nrow, ncol, step + 1));
                }
            }
        }
        return dis;
    }
}
