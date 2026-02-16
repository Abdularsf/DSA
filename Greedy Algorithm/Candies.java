import java.util.*;

public class Candies {
    // To calculate number of candies
    public int candy(int[] ratings) {
        int n = ratings.length;
        if (n == 0)
            return 0;
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(left, 1);
        Arrays.fill(right, 1);
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                left[i] = left[i - 1] + 1;
            } else {
                left[i] = 1;
            }
        }

        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                right[i] = right[i + 1] + 1;
            } else {
                right[i] = 1;
            }
        }
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            ans += Math.max(left[i], right[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        Candies sol = new Candies();
        int[] ratings = { 1, 0, 2 };

        // Creating an instance of Candy class
        int result = sol.candy(ratings);

        System.out.println("Minimum candies required: " + result);
    }
}
