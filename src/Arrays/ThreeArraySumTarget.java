package Arrays;//Reference: https://www.geeksforgeeks.org/find-three-element-from-different-three-arrays-such-that-that-a-b-c-k/
import java.util.HashSet;

public class ThreeArraySumTarget {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int[] brr = {2, 3, 6, 1, 2};
        int[] crr = {3, 2, 4, 5, 6};

        int target = 4;

        System.out.println(ThreeSum(arr, brr, crr, target));
    }

    private static boolean ThreeSum(int[] arr, int[] brr, int[] crr, int target) {
        HashSet<Integer> set = new HashSet<>();
        for (int i : arr) set.add(i);

        for (int j : brr) {
            for (int k : crr) {
                if (set.contains(target - j - k)) return true;
            }
        }

        return false;
    }
}
