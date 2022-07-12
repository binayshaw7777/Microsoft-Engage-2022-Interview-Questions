import java.util.Arrays;
import java.util.Scanner;

public class LCS {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your first string: ");
        String s = sc.nextLine();
        System.out.println("Enter your second string: ");
        String t = sc.nextLine();
        int m = s.length();
        int n = t.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int[] row: dp)
            Arrays.fill(row, -1);

        System.out.println("Length of LCS is "+lcs(s, t, m, n, dp));
    }
    static int lcs(String X,String Y,int m,int n,int[][] dp){

        if (m == 0 || n == 0) return 0;

        if (dp[m][n] != -1) return dp[m][n];

        if(X.charAt(m - 1) == Y.charAt(n - 1)){
            dp[m][n] = 1 + lcs(X, Y, m - 1, n - 1, dp);
            return dp[m][n];
        }

        dp[m][n] = Math.max(lcs(X, Y, m, n - 1, dp),lcs(X, Y, m - 1, n, dp));
        return dp[m][n];
    }
}
