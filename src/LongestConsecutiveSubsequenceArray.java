import java.util.HashSet;

public class LongestConsecutiveSubsequenceArray {
    public static void main(String[] args) {
        int[] arr = new int[] {100, 2, 1, 3, 101, 200, 4};
        System.out.println(lcsa(arr));
    }

    private static int lcsa(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for (int i : nums) set.add(i);      //Add elements in the set first

        int max = 0;    //initially max count is 0
        for (int i : nums) {    //iterate using for each loop
            if (!set.contains(i-1)) {   //check if set contains 1 less than its no. or not
                int c = 1;  //temp counter
                int curr = i;    //current element

                while (set.contains(curr + 1)) {    //check if 1 greater than its value present or not
                    ++c;    //if yes increate counter and current value
                    curr++;
                }
                max = Math.max(max, c);     //after the while loop get max of main and temp counter
            }
        }
        return max; //return max count
    }
}
