package Arrays;//Reference: https://www.geeksforgeeks.org/find-three-element-from-different-three-arrays-such-that-that-a-b-c-k/
import java.util.HashSet;

public class ThreeArraySumTarget {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int[] brr = {2, 3, 6, 1, 2};
        int[] crr = {3, 2, 4, 5, 6};

        int target = 4;

        System.out.println(nestedLoopThreeSum(arr, brr, crr, target));
        System.out.println(ThreeSum(arr, brr, crr, target));
    }

    private static boolean nestedLoopThreeSum(int[] arr, int[] brr, int[] crr, int target) {
        for (int i=0; i<arr.length; i++) {
            for (int j=0; j<brr.length; j++) {
                for (int k=0; k<crr.length; k++) {
                    if (arr[i] + brr[j] + crr[k] == target)
                        return true;
                }
            }
        }
        return false;
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
