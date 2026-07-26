package src.Arrays.ArraysFAQs;

public class pascalTriangle2 {
    public int[] pascalTriangleII(int r) {
        int[] arr = new int[r];
        int res = 1;
        arr[0] = 1;
        for (int i = 1; i < r; i++) {
            res = res * (r - i);
            res = res / (i);
            arr[i] = res;
        }
        return arr;
    }
}
