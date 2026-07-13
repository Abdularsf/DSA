package src.Graph.TraversalProbelm;

public class surroundedRegion {
    public char[][] fill(char[][] mat) {
        int[] delRow = { -1, 0, 1, 0 };
        int[] delCol = { 0, 1, 0, -1 };
        int n = mat.length;
        int m = mat[0].length;
        int[][] vis = new int[n][m];

        for (int j = 0; j < m; j++) {
            if (vis[0][j] != 1 && mat[0][j] == 'O') {
                dfs(0, j, vis, mat, delRow, delCol);
            }
            if (vis[n - 1][j] != 1 && mat[n - 1][j] == 'O') {
                dfs(n - 1, j, vis, mat, delRow, delCol);
            }
        }
        for (int i = 0; i < n; i++) {
            if (vis[i][0] != 1 && mat[i][0] == 'O') {
                dfs(i, 0, vis, mat, delRow, delCol);
            }
            if (vis[i][m - 1] != 1 && mat[i][m - 1] == 'O') {
                dfs(i, m - 1, vis, mat, delRow, delCol);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 'O' && vis[i][j] != 1) {
                    mat[i][j] = 'X';
                }
            }
        }

        return mat;
    }

    private void dfs(int row, int col, int[][] vis, char[][] mat, int[] delRow, int[] delCol) {
        vis[row][col] = 1;
        int n = mat.length;
        int m = mat[0].length;
        for (int i = 0; i < 4; i++) {
            int nrow = row + delRow[i];
            int ncol = col + delCol[i];

            if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && mat[nrow][ncol] == 'O' && vis[nrow][ncol] != 1) {
                dfs(nrow, ncol, vis, mat, delRow, delCol);
            }
        }
    }
}
