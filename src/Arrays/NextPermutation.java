package Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class NextPermutation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the Array: ");
        int n = sc.nextInt();
        int[] nums = new int[n];
        System.out.println("Enter the elements: ");
        for (int i = 0; i < n; i++)
            nums[i] = sc.nextInt();

        nextPermutation(nums);
        System.out.println("Next permutation is: " + Arrays.toString(nums));
    }
    public static void nextPermutation(int[] nums) {
        int ind = - 1;
        int size = nums.length;

        for (int i = size - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                ind = i;
                break;
            }
        }

        if (ind == -1) {
            reverseOf(0, size, nums);
            return;
        }

        for (int i = size - 1; i > ind; i--) {
            if (nums[i] > nums[ind]) {
                swap(i, ind, nums);
                break;
            }
        }

        reverseOf(ind + 1, size - 1, nums);
    }

    private static void reverseOf(int start, int end, int[] nums) {
        while (start < end) {
            swap(start, end, nums);
            start++;
            end--;
        }
    }

    private static void swap(int a, int b, int[] nums) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
