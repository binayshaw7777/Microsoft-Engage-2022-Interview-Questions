//Leetcode: https://leetcode.com/problems/reverse-words-in-a-string/

import java.util.Scanner;
import java.util.Stack;

public class ReverseWordsInAString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a sentence: ");
        String st = sc.nextLine();
        System.out.println("Actual sentence: " + st);
        System.out.println("Reversed words: " + reverseWord(st));
    }

    private static String reverseWord(String st) {
        /** Does works on strings like "GAMING    IS MY   LIFE"   **/
//        StringBuilder sb = new StringBuilder();
//        String[] s = st.split("\\s");
//        for (int i=s.length-1; i>=0; i--) {
//            sb.append(s[i]+" ");
//        }
//        return sb.toString().trim();

        /** Works on all string **/
        Stack<String> stack = new Stack<>();
        String x = st.trim();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<x.length(); i++) {
            if(x.charAt(i) == ' ') {
                if(sb.length()!=0) {
                    stack.push(sb.toString());
                    sb.setLength(0);
                }
            } else {
                sb.append(x.charAt(i));
            }
        }
        stack.push(sb.toString());
        sb.setLength(0);
        while(!stack.isEmpty()) {
            sb.append(stack.pop() + " ");
        }
        return sb.toString().trim();
    }
}
