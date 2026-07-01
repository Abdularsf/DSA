import java.util.*;

public class Shortest_job_first {

    public long solve(int[] bt) {
        Arrays.sort(bt);
        long waitTime = 0;
        long totalTime = 0;
        int n = bt.length;
        for (int i = 0; i < n; ++i) {
            waitTime += totalTime;
            totalTime += bt[i];
        }
        return waitTime / n;
    }

    public static void main(String[] args) {
        int[] jobs = { 1, 2, 3, 4 };
        Shortest_job_first solution = new Shortest_job_first();
        long ans = solution.solve(jobs);
        System.out.println("Total waiting time: " + ans);
    }
}
