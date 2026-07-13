package src.Graph.TraversalProbelm;

import java.util.ArrayList;
import java.util.HashSet;

public class NodistIsland {
    private void dfs(int row, int col, int[][] grid, int[][] vis, int rowStart, int colStart, ArrayList<String> list) {
        int n = grid.length;
        int m = grid[0].length;
        vis[row][col] = 1;
        list.add((row - rowStart) + "," + (col - colStart));

        int[] delRow = { -1, 0, 1, 0 };
        int[] delCol = { 0, -1, 0, 1 };

        for (int i = 0; i < 4; i++) {
            int nrow = row + delRow[i];
            int ncol = col + delCol[i];
            if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && vis[nrow][ncol] != 1 && grid[nrow][ncol] == 1) {
                dfs(nrow, ncol, grid, vis, rowStart, colStart, list);
            }
        }
    }

    public int countDistinctIslands(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        HashSet<ArrayList<String>> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (vis[i][j] != 1 && grid[i][j] != 0) {
                    ArrayList<String> list = new ArrayList<>();
                    dfs(i, j, grid, vis, i, j, list);
                    set.add(list);
                }
            }
        }
        return set.size();
    }
}
