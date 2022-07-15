package Arrays;//Reference: https://www.geeksforgeeks.org/count-distinct-elements-in-an-array/

import java.util.HashSet;
import java.util.Set;

//Sorted array was given and count of distinct values were to be found.
public class CountDistinctValues {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 8, 15, 15};
        System.out.println(distinctSet(arr)); //Using HashSet (TC: O(N) | SC: O(N))
        System.out.println(distinctLoop(arr));  //Using Duplicate search method (Loop) (TC: O(N) | SC: O(1))
        //Use two nested for loops if the array is not sorted!
    }

    private static int distinctLoop(int[] arr) {
        int count = 1; //We are already considering the first element
        if (arr.length == 1) return 1;
        for (int i = 1; i < arr.length; i++) {  //This is why we're starting from index 1
            if (arr[i] != arr[i - 1])
                count++;
        }
        return count;
    }

    private static int distinctSet(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int i : arr) {
            set.add(i);
        }
        return set.size();
    }
}
