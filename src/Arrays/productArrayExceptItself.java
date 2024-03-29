package Arrays;
//Leetcode: https://leetcode.com/problems/product-of-array-except-self/

import java.util.Arrays;

public class productArrayExceptItself {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};

        System.out.println(Arrays.toString(divideMethod(arr))); //Not acceptable
        System.out.println(Arrays.toString(product(arr)));  //Accepted
    }

    private static int[] divideMethod(int[] arr) {
        int[] ans = Arrays.copyOf(arr, arr.length);
        int prod = 1;
        for (int i : arr)
            prod *= i;

        for (int i=0; i<ans.length; i++) {
            ans[i] = prod/ans[i];
        }

        return ans;
    }

    private static int[] product(int[] arr) {
        int n = arr.length;
        int[] left = new int[n];
        int[] right = new int[n];

        left[0] = 1;
        right[n-1] = 1;

        for (int i=1; i<n; i++)
            left[i] = left[i-1] * arr[i-1];

        for (int i=n-2; i>=0; i--)
            right[i] = right[i+1] * arr[i+1];

        for (int i=0; i<n; i++)
            arr[i] = left[i] * right[i];

        return arr;
    }
}
