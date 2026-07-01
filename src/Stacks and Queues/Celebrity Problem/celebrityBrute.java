
public class celebrityBrute {
    public int celebrity(int[][] M) {
        int n = M.length;
        int m = M[0].length;
        int[] knowMe = new int[n];
        int[] iknow = new int[m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (M[i][j] == 1) {
                    knowMe[j]++;
                    iknow[i]++;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (knowMe[i] == n - 1 && iknow[i] == 0) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] M = {
                { 0, 1, 1, 0 },
                { 0, 0, 0, 0 },
                { 1, 1, 0, 0 },
                { 0, 1, 1, 0 }
        };
        celebrityBrute sol = new celebrityBrute();
        int ans = sol.celebrity(M);
        System.out.println("The index of celebrity is: " + ans);
    }

}
