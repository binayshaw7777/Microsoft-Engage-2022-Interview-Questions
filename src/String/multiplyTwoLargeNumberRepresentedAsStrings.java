//GFG: https://www.geeksforgeeks.org/multiply-large-numbers-represented-as-strings/
//Leetcode: https://leetcode.com/problems/multiply-strings/

package String;

import java.math.BigInteger;

public class multiplyTwoLargeNumberRepresentedAsStrings {
    public static void main(String[] args) {
        String firstNumber = "1235421415454545454545454544";
        String secondNumber = "1714546546546545454544548544544545";

        System.out.println(multiplyUsingBigInteger(firstNumber, secondNumber)); //Not accepted in Leetcode
        System.out.println(multiplyByLoopingBackwards(firstNumber, secondNumber));

    }

    private static String multiplyByLoopingBackwards(String firstNumber, String secondNumber) {
        int len1 = firstNumber.length();
        int len2 = secondNumber.length();
        if (len1 == 0 || len2 == 0)
            return "0";

        // will keep the result number in vector
        // in reverse order
        int result[] = new int[len1 + len2];

        // Below two indexes are used to
        // find positions in result.
        int i_n1 = 0;
        int i_n2 = 0;

        for (int i = len1 - 1; i >= 0; i--) {
            int carry = 0;
            int n1 = firstNumber.charAt(i) - '0';

            i_n2 = 0;

            for (int j = len2 - 1; j >= 0; j--) {
                int n2 = secondNumber.charAt(j) - '0';

                // Multiply with current digit of first number
                // and add result to previously stored result
                // charAt current position.
                int sum = n1 * n2 + result[i_n1 + i_n2] + carry;

                // Carry for next itercharAtion
                carry = sum / 10;

                // Store result
                result[i_n1 + i_n2] = sum % 10;

                i_n2++;
            }

            if (carry > 0)
                result[i_n1 + i_n2] += carry;

            // To shift position to left after every
            // multipliccharAtion of a digit in num1.
            i_n1++;
        }

        // ignore '0's from the right
        int i = result.length - 1;
        while (i >= 0 && result[i] == 0)
            i--;

        // If all were '0's - means either both
        // or one of num1 or num2 were '0'
        if (i == -1)
            return "0";

        // genercharAte the result String
        String s = "";

        while (i >= 0)
            s += (result[i--]);

        return s;
    }

    private static String multiplyUsingBigInteger(String firstNumber, String secondNumber) {
        BigInteger first = new BigInteger(firstNumber);
        BigInteger second = new BigInteger(secondNumber);

        first = first.multiply(second);
        return String.valueOf(first);
    }
}
