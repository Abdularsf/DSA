import java.util.*;

class Assign_Cookies {
    public int findMaximumCookieStudents(int[] Student, int[] Cookie) {
        int n = Student.length;
        int m = Cookie.length;
        int l = 0, r = 0;
        Arrays.sort(Student);
        Arrays.sort(Cookie);
        while (l < n && r < m) {
            if (Cookie[r] >= Student[l]) {
                l++;
            }
            r++;
        }
        return l;
    }

    public static void main(String[] args) {
        int[] Student = { 1, 2 };
        int[] Cookie = { 1, 2, 3 };
        Assign_Cookies solution = new Assign_Cookies();
        int result = solution.findMaximumCookieStudents(Student, Cookie);
        System.out.println("Number of students satisfied: " + result);
    }
}