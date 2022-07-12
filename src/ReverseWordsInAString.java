//Leetcode: https://leetcode.com/problems/reverse-words-in-a-string/

import java.util.Scanner;

public class ReverseWordsInAString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a sentence: ");
        String st = sc.nextLine();
        System.out.println("Actual sentence: " + st);
        System.out.println("Reversed words: " + reverseWord(st));
    }

    private static String reverseWord(String st) {
        StringBuilder sb = new StringBuilder();
        String[] s = st.split("\\s");
        for (int i=s.length-1; i>=0; i--) {
            sb.append(s[i]+" ");
        }
        return sb.toString().trim();
    }
}
