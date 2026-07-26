package src.Arrays.ArraysFAQs;

import java.util.ArrayList;
import java.util.List;

public class pascalTriangle3 {
    public List<List<Integer>> pascalTriangleIII(int n) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(generateRow(i));
        }
        return list;
    }

    private List<Integer> generateRow(int row) {
        long ans = 1;
        List<Integer> ansRow = new ArrayList<>();

        ansRow.add(1);

        for (int col = 1; col < row; col++) {
            ans = ans * (row - col);
            ans = ans / col;
            ansRow.add((int) ans);
        }

        return ansRow;
    }
}
