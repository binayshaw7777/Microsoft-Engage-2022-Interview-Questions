//  Given a sorted array find the number of times a given element appears

public class TargetFrequency {
    public static void main(String[] args) {
        int[] arr = new int[] {1, 2, 3, 4, 4, 5, 5, 5, 6, 7, 8, 8, 8, 8, 9, 9, 10};
        int target = 5;
        int count = 0;

        for (int i : arr)
            if (i==target)
                ++count;

        System.out.println(count);
    }
}
