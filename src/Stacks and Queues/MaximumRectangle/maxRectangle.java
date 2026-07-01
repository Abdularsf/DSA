import java.util.Stack;

public class maxRectangle {
    public int maximalAreaOfSubMatrixOfAll1(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int maxArea = 0;
        int[][] prefixMat = new int[row][col];
        for (int i = 0; i < col; i++) {
            int sum = 0;
            for (int j = 0; j < row; j++) {
                sum += matrix[j][i];
                if (matrix[j][i] == 0)
                    sum = 0;
                prefixMat[j][i] = sum;
            }
        }

        for (int i = 0; i < row; i++) {
            maxArea = Math.max(maxArea, lHist(prefixMat[i]));
        }
        return maxArea;
    }

    private int lHist(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int n = heights.length;
        int max = 0;
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && heights[st.peek()] > heights[i]) {
                int element = st.pop();
                int nse = i;
                int pse = -1;
                if (st.isEmpty()) {
                    pse = -1;
                } else {
                    pse = st.peek();
                }
                max = Math.max(max, heights[element] * (nse - pse - 1));
            }
            st.push(i);
        }
        while (!st.isEmpty()) {
            int nse = n;
            int element = st.pop();
            int pse = -1;
            if (st.isEmpty()) {
                pse = -1;
            } else {
                pse = st.peek();
            }
            max = Math.max(max, heights[element] * (nse - pse - 1));
        }
        return max;
    }

}
