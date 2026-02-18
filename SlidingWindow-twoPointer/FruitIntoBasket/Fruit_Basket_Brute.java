import java.util.HashSet;
import java.util.Set;

public class Fruit_Basket_Brute {
    public int totalFruits(int[] fruits) {
        int n = fruits.length;
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            Set<Integer> uniqueFruits = new HashSet<>();
            for (int j = i; j < n; j++) {
                uniqueFruits.add(fruits[j]);
                if (uniqueFruits.size() <= 2) {
                    int len = j - i + 1;
                    maxLen = Math.max(maxLen, len);
                } else {
                    break;
                }
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int[] input = { 3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4 };
        Fruit_Basket_Brute sol = new Fruit_Basket_Brute();
        int length = sol.totalFruits(input);
        System.out.println("Maximum fruits in the basket is: " + length);
    }
}
