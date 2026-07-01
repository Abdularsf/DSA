
public class subArrSumBruteRange {
    public long subArrayRanges(int[] nums) {
        long sum = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int smallest = nums[i];
            int largest = nums[i];
            for (int j = i + 1; j < n; j++) {
                largest = Math.max(largest, nums[j]);
                smallest = Math.min(smallest, nums[j]);
                sum = sum + (largest - smallest);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3 };
        subArrSumBruteRange sol = new subArrSumBruteRange();
        long ans = sol.subArrayRanges(arr);
        System.out.println("The sum of subarray ranges is: " + ans);
    }
}
