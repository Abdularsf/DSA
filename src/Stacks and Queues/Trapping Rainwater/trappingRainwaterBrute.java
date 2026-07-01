
public class trappingRainwaterBrute {
    public int trap(int[] height) {
        int n = height.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        prefix[0] = height[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = Math.max(prefix[i - 1], height[i]);
        }
        suffix[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = Math.max(suffix[i + 1], height[i]);
        }
        int total = 0;
        for (int i = 0; i < n; i++) {
            if (height[i] < prefix[i] && height[i] < suffix[i]) {
                total += (Math.min(prefix[i], suffix[i]) - height[i]);
            }
        }
        return total;
    }

    public static void main(String[] args) {
        int[] heights = { 4, 2, 0, 3, 2, 5 };

        // Creating an instance of Solution class
        trappingRainwaterBrute sol = new trappingRainwaterBrute();

        // Function call to get the trapped water
        int ans = sol.trap(heights);

        System.out.println("The trapped rainwater is: " + ans);
    }
}
