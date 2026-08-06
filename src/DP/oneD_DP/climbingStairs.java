package src.DP.oneD_DP;

import java.util.Arrays;

public class climbingStairs {
    public int stockBuySell(int[] arr, int n) {
        if (n == 0) {
            return 0;
        }

        int[][] dp = new int[n + 1][2];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        dp[n][0] = dp[n][1] = 0;

        int profit = 0;

        for (int ind = n - 1; ind >= 0; ind--) {
            for (int buy = 0; buy <= 1; buy++) {
                if (buy == 0) {
                    profit = Math.max(0 + dp[ind + 1][0], (-1) * arr[ind] + dp[ind + 1][1]);
                } else {
                    profit = Math.max(0 + dp[ind + 1][1], arr[ind] + dp[ind + 1][0]);
                }

                dp[ind][buy] = profit;
            }
        }

        return dp[0][0];
    }
}
