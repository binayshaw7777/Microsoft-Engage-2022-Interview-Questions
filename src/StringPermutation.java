import java.util.Scanner;

public class StringPermutation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your string: ");
        String s = sc.nextLine();
        int n = s.length();
        permutation(s, 0, n);
    }

    public static void permutation(String str, int start, int end) {
        if (start == end - 1)
            System.out.println(str);
        else {
            for (int i = start; i < end; i++) {
                //Swapping the string by fixing a character
                str = swapString(str, start, i);
                //Recursively calling function generatePermutation() for rest of the characters
                permutation(str, start + 1, end);
                str = swapString(str, start, i);    //Backtracking to recover actual String (UNDO)
            }
        }
    }

    public static String swapString(String a, int i, int j) {
        char[] b = a.toCharArray();
        char ch;
        ch = b[i];
        b[i] = b[j];
        b[j] = ch;
        return String.valueOf(b);
    }
}
