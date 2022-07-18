package Arrays;//Example = {3, 4, 5}
//Reason: (3*3) + (4*4) = (5*5)     i.e, 9 + 16 = 25    i.e 25 = 25

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class PythagorasTriplet {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the Array: ");
        int n = sc.nextInt();
        if (n < 3) {
            System.out.println("Array length must be greater than 2!");
            System.exit(0);
        }
        int[] arr = new int[n];
        System.out.println("\nEnter the Array elements: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(triplet(arr));
        System.out.println(py(arr));
    }

    private static boolean triplet(int[] arr) {
        if (arr.length < 3) return false;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n; j++) {
                for (int k = 2; k < n; k++) {
                    if ((arr[i] * arr[i]) + (arr[j] * arr[j]) == arr[k] * arr[k])
                        return true;
                }
            }
        }
        return false;
    }

    private static boolean py(int[] arr) {      //O(N^2) TC && O(N) SC
        int n = arr.length;
        if (n < 3) return false;

        for (int i = 0; i < n; i++)
            arr[i] = arr[i] * arr[i];

        Set<Integer> set = new HashSet<>();

        for (int i : arr)
            set.add(i);

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (set.contains(arr[i] + arr[j]))
                    return true;
            }
        }

        return false;
    }

}
