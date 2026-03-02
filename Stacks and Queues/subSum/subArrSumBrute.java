public class subArrSumBrute {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int mod = (int) 1e9 + 7;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int min = arr[i];
            for (int j = i; j < n; j++) {
                min = Math.min(min, arr[j]);
                sum = (sum + min) % mod;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arr = { 3, 1, 2, 5 };
        subArrSumBrute sol = new subArrSumBrute();
        int ans = sol.sumSubarrayMins(arr);

        System.out.println("The sum of minimum value in each subarray is: " + ans);
    }
}
