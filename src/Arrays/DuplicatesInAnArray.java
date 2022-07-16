package Arrays;//Leetcode: https://leetcode.com/problems/contains-duplicate/

import java.util.Arrays;
import java.util.HashSet;

public class DuplicatesInAnArray {
    public static void main(String[] args) {
        int[] arr = new int[] {1, 3, 6, 2, 5, 7, 3};                                                                    //TC             SC
        System.out.println(nestedLoopDuplicate(arr)); //Nested loop to check duplicates in an array                     O(N^2)          O(1)
        System.out.println(sortDuplicate(arr)); //Sort the array first and check i and i-1 element if they are same     O(N log N)      O(N)
        System.out.println(setDuplicate(arr)); //User HashSet to find if the element already exist in the set or not    O(N)            O(N)
    }

    private static boolean nestedLoopDuplicate(int[] arr) {
        if (arr.length < 2) return false;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) return true;
            }
        }
        return false;
    }

    private static boolean sortDuplicate(int[] arr) {
        if (arr.length < 2) return false;
        Arrays.sort(arr);
        for (int i = 1; i<arr.length; i++) {
            if (arr[i] == arr[i-1]) return true;
        }
        return false;
    }

    private static boolean setDuplicate(int[] arr) {
        HashSet<Integer> set = new HashSet<>();

        for (int i : arr) {
            if (set.contains(i))
                return true;
            set.add(i);
        }
        return false;
    }
}
