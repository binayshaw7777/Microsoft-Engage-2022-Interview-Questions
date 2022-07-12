/*"Given three arrays find the smallest common element
        A = {2,6,8,69,74}
        B = {1,3,6,45,65}
        C = {2,6,8,75,46,78}

        O/P - 6 */

//Reference: https://www.geeksforgeeks.org/find-common-elements-three-sorted-arrays/#:~:text=A%20simple%20solution%20is%20to,%5B%5D%20and%20ar3%5B%5D%20respectively.

import java.util.Scanner;

public class MinCommonElement {

    public static void main(String[] args) {
        int[] a = inputArray();
        int[] b = inputArray();
        int[] c = inputArray();
        findMin(a, b, c);
    }

    private static void findMin(int[] a, int[] b, int[] c) {
        int i=0, j=0, k=0;

        while (i < a.length && j < b.length     //x = element at a, y = element at b and z = element at z
                && k < c.length) {

            if (a[i] == b[j] && b[j] == c[k]) { // If x = y and y = z, print
                System.out.print(a[i]);
                break;
            }
            else if (a[i] < b[j])   i++;    // x < y
            else if (b[j] < c[k])   j++;   // y < z
            else    k++;    //z < x

        }
    }

    private static int[] inputArray() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array: ");
        int n1 = sc.nextInt();
        int[] arr = new int[n1];
        System.out.println("Enter the array elements: ");
        for (int i=0; i<n1; i++)
            arr[i] = sc.nextInt();
        return arr;
    }
}
