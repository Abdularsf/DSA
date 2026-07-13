package src.Graph.TraversalProbelm;

import java.util.LinkedList;
import java.util.Queue;

class Pair {
    int first;
    int second;
    int tm;

    Pair(int first, int second, int tm) {
        this.first = first;
        this.second = second;
        this.tm = tm;
    }
}

public class rottenOranges {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        int[][] vis = new int[n][m];
        int cntFresh = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    q.add(new Pair(i, j, 0));
                    vis[i][j] = 2;
                } else {
                    vis[i][j] = 0;
                }
                if (grid[i][j] == 1) {
                    cntFresh++;
                }
            }
        }

        int[] delRow = { -1, 0, 1, 0 };
        int[] delCol = { 0, 1, 0, -1 };

        int time = 0;
        int cnt = 0;
        while (!q.isEmpty()) {
            int row = q.peek().first;
            int col = q.peek().second;
            int t = q.peek().tm;
            q.poll();
            time = Math.max(time, t);
            for (int i = 0; i < 4; i++) {
                int nrow = row + delRow[i];
                int ncol = col + delCol[i];
                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && vis[nrow][ncol] != 2 && grid[nrow][ncol] == 1) {
                    q.add(new Pair(nrow, ncol, t + 1));
                    vis[nrow][ncol] = 2;
                    cnt++;
                }
            }
        }
        if (cntFresh != cnt)
            return -1;
        return time;
    }
}
