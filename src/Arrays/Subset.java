package Arrays;

import java.util.ArrayList;
import java.util.List;

public class Subset {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        List<List<Integer>> list = subsets(arr);
        for (List<Integer> l : list)
            System.out.println(l);
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();

        // Start backtracking from the beginning
        backtrack(resultList, new ArrayList<>(), nums, 0);
        return resultList;
    }

    private static void backtrack(List<List<Integer>> resultSets, List<Integer> tempSet,
                           int[] nums, int start) {
        // Add the set to result set
        resultSets.add(new ArrayList<>(tempSet));
        for (int i = start; i < nums.length; i++) {

            // Case of including the number
            tempSet.add(nums[i]);

            // Backtrack the new subset
            backtrack(resultSets, tempSet, nums, i + 1);

            // Case of not-including the number
            tempSet.remove(tempSet.size() - 1);
        }
    }
}
