package src.Graph.TraversalProbelm;

import java.util.LinkedList;
import java.util.Queue;

class Pair {
    int first;
    int second;

    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

public class floodfillalgo {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int iniColor = image[sr][sc];
        int[][] ans = image;
        int[] delRow = { -1, 0, +1, 0 };
        int[] delCol = { 0, -1, 0, +1 };
        bfs(sr, sc, image, ans, newColor, delRow, delCol, iniColor);
        return ans;
    }

    private void bfs(int row, int col, int[][] image, int[][] ans, int newColor, int[] delRow, int[] delCol,
            int iniColor) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(row, col));
        ans[row][col] = newColor;
        int n = ans.length;
        int m = ans[0].length;
        while (!q.isEmpty()) {
            int crow = q.peek().first;
            int ccol = q.peek().second;
            q.poll();
            for (int i = 0; i < 4; i++) {

                int nrow = crow + delRow[i];
                int ncol = ccol + delCol[i];

                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m &&
                        image[nrow][ncol] == iniColor && ans[nrow][ncol] != newColor) {
                    ans[nrow][ncol] = newColor;
                    q.add(new Pair(nrow, ncol));
                }
            }
        }
    }
}
