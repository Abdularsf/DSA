import java.util.HashMap;

public class Fruit_Basket_Better {
    public int totalFruits(int[] fruits) {
        int n = fruits.length;
        int maxLen = 0;
        int left = 0;
        int right = 0;
        HashMap<Integer, Integer> mpp = new HashMap<>();
        while (right < n) {
            mpp.put(fruits[right], mpp.getOrDefault(fruits[right], 0) + 1);
            if (mpp.size() > 2) {
                while (mpp.size() > 2) {
                    mpp.put(fruits[left], mpp.get(fruits[left]) - 1);
                    if (mpp.get(fruits[left]) == 0) {
                        mpp.remove(fruits[left]);
                    }
                    left++;
                }
            }
            if (mpp.size() <= 2) {
                maxLen = Math.max(maxLen, right - left + 1);
            }
            right++;
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int[] input = { 3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4 };
        Fruit_Basket_Better sol = new Fruit_Basket_Better();
        int length = sol.totalFruits(input);
        System.out.println("Maximum fruits in the basket is: " + length);
    }
}
