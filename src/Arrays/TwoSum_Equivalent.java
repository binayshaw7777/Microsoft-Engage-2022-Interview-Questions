package Arrays;/* Refernce: https://www.geeksforgeeks.org/given-an-array-a-and-a-number-x-check-for-pair-in-a-with-sum-as-x/
   Leetcode:https://leetcode.com/problems/two-sum/
   InterviewBit: https://www.interviewbit.com/problems/2-sum/
 */

import java.util.HashSet;
import java.util.Scanner;

public class TwoSum_Equivalent {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the array elements: ");
        for( int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("Enter the target: ");   //Target = summation of 2 elements in the array
        int target = sc.nextInt();  //Example: arr = [1,2,3,4,5], target = 9. return true because [4,5] = 9
        System.out.println("\n"+twoSum(arr, target));
    }
    public static boolean twoSum(int[] arr, int target) {
        HashSet<Integer> set = new HashSet<>();
        for (int i : arr) {     //Iterate using forLoop or forEachLoop
            if (set.contains(target-i))     //If the set contains x = target - i, here x may be in the set
                return true;    //Then return true;
            set.add(i);     //Hence add in the set as nothing was returned
        }
        return false;   //Finally return false if there was no return initially
    }
}
