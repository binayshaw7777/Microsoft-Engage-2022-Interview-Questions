package String;//Longest Palindromic Subsequence
//Leetcode: https://leetcode.com/problems/longest-palindromic-substring/

import java.util.Arrays;
import java.util.Scanner;

public class LPS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your string: ");
        String s = sc.nextLine();
        String t = reverse(s);
        int[][] dp = new int[s.length()+1][t.length()+1];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        int lp = lps(s, t, s.length(), t.length(), dp);

        int i = 0, j = lp;
        while (lp < s.length()-1) {
            String st = s.substring(i, j);
            if (st.equals(reverse(st))) {
                System.out.println(st + " Length - "+ lp);
                System.exit(0);
            }
            i++;
            j++;
        }
    }

    private static int lps(String s1, String s2, int l1, int l2, int[][] dp) {
        if (l1 == 0 || l2 == 0) return 0;
        if (dp[l1][l2] != -1) return dp[l1][l2];
        if (s1.charAt(l1-1) == s2.charAt(l2-1)) {
            dp[l1][l2] = 1 + lps(s1, s2, l1 - 1, l2 - 1, dp);
            return dp[l1][l2];
        }
        dp[l1][l2] = Math.max(lps(s1, s2, l1, l2-1, dp), lps(s1, s2, l1-1, l2, dp));
        return dp[l1][l2];
    }

    private static String reverse(String s) {
        String t = "";
        for (int i=s.length()-1; i>=0; i--)
            t += s.charAt(i);
        return t;
    }
}
