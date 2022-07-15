package String;/* Check whether the two String are String.Anagram or not
String.Anagram means the frequency of every character in both String must be equal
Leetcode: https://leetcode.com/problems/valid-anagram/
 */

import java.util.Scanner;

public class Anagram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the first String: ");
        String a = sc.nextLine();
        System.out.println("Enter the second String: ");
        String b = sc.nextLine();

        System.out.println(isAnagram(a, b));    //Print True/False
    }

    public static boolean isAnagram(String a, String b) {
        int[] arr = new int[256];   //Create an array of 256 (ASCII)

        for (char c : a.toCharArray())
            arr[c] += 1;    //Increment the character corresponding to ASCII Index for String 1
        for (char c : b.toCharArray())
            arr[c] -= 1;    //Decrement the character corresponding to ASCII Index for String 2
        for (int i : arr)
            if (i != 0)     //Check if every element of Array is not 0, that means the frequency are not equal
                return false;   //Hence return false;

        return true;
    }
}
