package String;

import java.util.Scanner;
import java.util.Stack;

public class checkPalindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your String: ");  //Try inputs: "RACECAR", "NOON", "BLOB", "MASON"
        String st = sc.nextLine();

        System.out.println(isPalindromeUsingStack(st));
        System.out.println(isPalindromeReverseString(st));
        System.out.println(isPalindrome(st));
    }

    private static boolean isPalindromeReverseString(String st) {
        StringBuilder sb = new StringBuilder(st);
        sb.reverse();
        for (int i=0; i<st.length(); i++) {
            if (st.charAt(i) != sb.charAt(i))
                return false;
        }
        return true;
    }

    private static boolean isPalindromeUsingStack(String st) {
        Stack<Character> stack = new Stack<>();
        for (char c : st.toCharArray())
            stack.add(c);

        for (char c : st.toCharArray()) {
            if (stack.pop() != c)
                return false;
        }
        return true;
    }

    private static boolean isPalindrome(String st) {
        int start = 0, end = st.length() - 1;
        for (int i = 0; i < st.length() / 2; i++) {
            if (st.charAt(start) != st.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }
}

