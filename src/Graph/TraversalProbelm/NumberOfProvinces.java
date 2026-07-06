package src.Graph.TraversalProbelm;

import java.util.*;

class Pair {
    int distance;
    int first;
    int second;

    Pair(int distance, int first, int second) {
        this.distance = distance;
        this.first = first;
        this.second = second;
    }
}

class NumberofProvinces {
    int shortestPath(int[][] grid, int[] source, int[] destination) {
        Queue<Pair> q = new LinkedList<>();
        int n = grid.length;
        int m = grid[0].length;
        int[][] dist = new int[n][m];
        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        dist[source[0]][source[1]] = 0;
        q.add(new Pair(0, source[0], source[1]));
        int[] delRow = { -1, 0, 1, 0 };
        int[] delCol = { 0, -1, 0, 1 };
        while (!q.isEmpty()) {
            Pair elem = q.poll();
            int row = elem.first;
            int col = elem.second;
            int currDist = elem.distance;
            for (int i = 0; i < 4; i++) {
                int nrow = row + delRow[i];
                int ncol = col + delCol[i];
                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && grid[nrow][ncol] == 1
                        && currDist + 1 < dist[nrow][ncol]) {
                    if (nrow == destination[0] && ncol == destination[1])
                        return currDist + 1;
                    q.add(new Pair(currDist + 1, nrow, ncol));
                    dist[nrow][ncol] = currDist + 1;
                }
            }
        }
        return -1;
    }
}