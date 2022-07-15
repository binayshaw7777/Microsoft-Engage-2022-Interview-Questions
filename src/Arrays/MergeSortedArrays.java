package Arrays;

import java.util.Arrays;

public class MergeSortedArrays {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 7, 8};
        int[] brr = {3, 5, 6, 9, 10};

        System.out.println(Arrays.toString(mergeArray(arr, brr)));
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
