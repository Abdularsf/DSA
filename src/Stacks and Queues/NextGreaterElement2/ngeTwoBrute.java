import java.util.Arrays;

public class ngeTwoBrute {

    public int[] nextGreaterElements(int[] arr) {
        int n = arr.length;
        int[] nge = new int[n];

        Arrays.fill(nge, -1);

        for (int i = 0; i < n; i++) {

            for (int j = i + 1; j < i + n; j++) {

                int index = j % n;

                if (arr[index] > arr[i]) {
                    nge[i] = arr[index];
                    break;
                }
            }
        }
        return nge;
    }

    public static void main(String[] args) {

        int[] arr = { 5, 7, 1, 7, 6, 0 };

        ngeTwoBrute sol = new ngeTwoBrute();

        int[] ans = sol.nextGreaterElements(arr);

        System.out.println(Arrays.toString(ans));
    }
}