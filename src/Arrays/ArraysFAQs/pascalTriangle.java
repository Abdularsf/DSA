package src.Arrays.ArraysFAQs;

public class pascalTriangle {
    public int pascalTriangleI(int r, int c) {
        return ncr(r - 1, c - 1);
    }

    private int ncr(int n, int r) {
        int res = 1;
        for (int i = 0; i < r; i++) {
            res *= (n - i);
            res = res / (i + 1);
        }
        return res;

    }
}
