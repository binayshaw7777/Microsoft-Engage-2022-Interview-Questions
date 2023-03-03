package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MissingPositiveNumber {
    //This question is similar to: https://leetcode.com/problems/missing-number/
    /**
     * Given an array nums containing n distinct numbers in the range [0, n]
     * return the only number in the range that is missing from the array.
     * */

    //Driver code
    private static void generateTestCasesAndExpectedOutputs(List<int[]> testCases, List<Integer> expectedOutput) {
        testCases.add(new int[]{3,0,1});
        testCases.add(new int[]{0,1});
        testCases.add(new int[]{9,6,4,2,3,5,7,0,1});

        expectedOutput.add(2);
        expectedOutput.add(2);
        expectedOutput.add(8);
    }

    //Solution beings here
    public static void main(String[] args) {

        List<int[]> testCases = new ArrayList<>();
        List<Integer> expectedOutput = new ArrayList<>();
        generateTestCasesAndExpectedOutputs(testCases, expectedOutput);
        //Here I generated some test cases with expected outputs

        for (int i = 0; i < testCases.size(); i++) {
            if (missingNumber1(testCases.get(i)) == expectedOutput.get(i))
                System.out.println("Test case Passed (Function 1)");
            else
                System.out.println("Test case Failed (Function 1)");
            if (missingNumber2(testCases.get(i)) == expectedOutput.get(i))
                System.out.println("Test case Passed (Function 2)");
            else
                System.out.println("Test case Failed (Function 2)");
        }
    }


    //Given function
    public static int missingNumber1(int[] nums) {
//        We take the size first, if there's only one element, if it's 1 return 0, else return 1
        int size = nums.length;
        if (size == 1 && nums[0] == 0) return 1;
        if (size == 1 && nums[0] == 1) return 0;
//        Now we sort the array to find the difference between [i]th and [i - 1]th index (expected = 1)
//        If it's not 1, the missing number if the [i]th index's value - 1
        Arrays.sort(nums);
        if (nums[0] == 1)  return 0;
        for (int i = 1; i < size; i++) {
            if (nums[i] - nums[i-1] != 1)
                return nums[i] - 1;
        }
        return nums[size-1] + 1;
    }

    private static int missingNumber2(int[] nums) {
//        Take the sum of all numbers, because we've to find the positive missing number
//        We can easily use this method, sum of first 'N' (Size of the array) numbers - actual sum found
        int sum = 0, n = nums.length;
        for (int i : nums)
            sum += i;

        return (n*(n+1))/2 - sum;
    }

}
