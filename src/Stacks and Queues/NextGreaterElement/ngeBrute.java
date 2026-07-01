
public class ngeBrute {
    public int[] nextLargerElement(int[] arr) {
        int n = arr.length;
        int[] nge = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] < arr[j]) {
                    nge[i] = arr[j];
                    break;
                } else {
                    nge[i] = -1;
                }
            }
        }
        nge[n - 1] = -1;
        return nge;
    }

    public static void main(String[] args) {
        int n = 4;
        int[] arr = { 1, 3, 2, 4 };

        ngeBrute sol = new ngeBrute();

        int[] ans = sol.nextLargerElement(arr);

        System.out.println("The next greater elements are: ");

        for (int i = 0; i < n; i++) {
            System.out.print(ans[i] + " ");
        }
    }
}
