package Arrays;//LeetCode: https://leetcode.com/problems/longest-consecutive-sequence/

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;

public class LongestConsecutiveSubsequenceArray {
    public static void main(String[] args) {
        int[] arr = new int[]{100, 2, 1, 3, 101, 200, 4};
        //                                                                                 TC        SC
        System.out.println(lcsaSort(arr));  //Sort the Array and check -1 difference    O(N log N)  O(N)
        System.out.println(lcsa(arr));      //Using HashSet                             O(N^2)      O(N)
        System.out.println(lcsaPQ(arr));    //Using PriorityQueue (More Optimized)      O(N^2)      O(N)
    }

    private static int lcsaSort(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return 1;
        int max = 1;
        int c = 1;
        Arrays.sort(nums);
        for (int i=1; i<nums.length; i++) {
            if (nums[i] - nums[i-1] == 1) {
                c++;
                max = Math.max(max, c);
            } else if (nums[i] == nums[i-1])
                continue;
            else {
                max = Math.max(max, c);
                c = 1;
            }
        }
        return max;
    }

    private static int lcsaPQ(int[] nums) {
        if (nums.length == 0) return 0; //edge case

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int c = 1; // LCS Counter, set to 1 because a single digit is also consecutive.
        for (int a : nums) {
            pq.offer(a);
        }

        int a = pq.poll();
        int max = Integer.MIN_VALUE;

        while (pq.size() > 0) {
            int b = pq.poll();
            if (a == b) // if a==b then we just move forward and update variables
                continue;
            else if (a + 1 == b) { // this is when we inc. LCS counter
                c++;
                max = Math.max(max, c); // we take the maximum LCS length and return it(cause there might be multiple)
            } else if (a + 1 != b)// if variables are not equal, refresh counter,and start again
                c = 1;

            a = b; //Update a using b
        }

        return max == Integer.MIN_VALUE ? 1 : max;

    }

    private static int lcsa(int[] nums) {
        if(nums.length == 0) return 0;
        HashSet<Integer> set = new HashSet<>();

        for (int i : nums) set.add(i);      //Add elements in the set first

        int max = 0;    //initially max count is 0
        for (int i : nums) {    //iterate using for each loop
            if (!set.contains(i - 1)) {   //check if set contains 1 less than its no. or not
                int c = 1;  //temp counter
                int curr = i;    //current element

                while (set.contains(curr + 1)) {    //check if 1 greater than its value present or not
                    ++c;    //if yes increment counter and current value
                    curr++;
                }
                max = Math.max(max, c);     //after the while loop get max of main and temp counter
            }
        }
        return max; //return max count
    }
}
