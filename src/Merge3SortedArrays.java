//GFG: https://www.geeksforgeeks.org/merge-3-sorted-arrays/

import java.util.Arrays;

public class Merge3SortedArrays {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 7, 8};
        int[] brr = {3, 5, 6, 9, 10};
        int[] crr = {4, 5, 7, 8, 10};

        int[] S = mergeArray(arr, brr); //Merge two arrays first
        int[] T = mergeArray(S, crr);   //Merge the previously merged array and the remaining array

        System.out.println(Arrays.toString(T));
    }

    private static int[] mergeArray(int[] arr, int[] brr) {
        int a = arr.length, b = brr.length;
        int[] crr = new int[a + b];
        int i = 0, j = 0, k = 0;
        while (i < a && j < b) {
            if (arr[i] < brr[j]) {
                crr[k] = arr[i];
                i++;
                k++;
            } else if (arr[i] > brr[j]) {
                crr[k] = brr[j];
                j++;
                k++;
            } else if (arr[i] == brr[j]) {
                crr[k] = arr[i];
                crr[k + 1] = brr[j];
                k += 2;
                i++;
                j++;
            }
        }

        while (i < a) {
            crr[k] = arr[i];
            k++;
            i++;
        }

        while (j < b) {
            crr[k] = brr[j];
            k++;
            j++;
        }

        return crr;
    }
}
