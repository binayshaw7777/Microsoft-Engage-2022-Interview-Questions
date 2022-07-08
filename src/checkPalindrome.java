import java.util.Scanner;

public class checkPalindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your String: ");  //Try inputs: "RACECAR", "NOON", "BLOB", "MASON"
        String st = sc.nextLine();
        System.out.println(isPalindrome(st));
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

