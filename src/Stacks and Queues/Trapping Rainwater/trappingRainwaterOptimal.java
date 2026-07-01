
public class trappingRainwaterOptimal {
    public int trap(int[] height) {
        int n = height.length;
        int lMax = 0, rMax = 0, total = 0;
        int l = 0, r = n - 1;
        while (l < r) {
            if (height[l] <= height[r]) {
                if (lMax > height[l]) {
                    total += lMax - height[l];
                } else {
                    lMax = height[l];
                }
                l = l + 1;
            } else {
                if (rMax > height[r]) {
                    total += rMax - height[r];
                } else {
                    rMax = height[r];
                }
                r = r - 1;
            }
        }
        return total;
    }

    public static void main(String[] args) {
        int[] heights = { 4, 2, 0, 3, 2, 5 };

        trappingRainwaterOptimal sol = new trappingRainwaterOptimal();

        int ans = sol.trap(heights);

        System.out.println("The trapped rainwater is: " + ans);
    }
}
