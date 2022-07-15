package Arrays;//Leetcode: https://leetcode.com/problems/contains-duplicate/

import java.util.HashSet;

public class DuplicatesInAnArray {
    public static void main(String[] args) {
        int[] arr = new int[] {1, 3, 6, 2, 5, 7, 3};
        System.out.println(duplicate(arr));
    }

    private static boolean duplicate(int[] arr) {
        HashSet<Integer> set = new HashSet<>();

        for (int i : arr) {
            if (set.contains(i))
                return true;

            set.add(i);
        }
        return false;
    }
}
