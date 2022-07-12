import java.util.HashSet;

public class TripletWithSum0 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        int[] brr = {-1, -2, -3, -5, -7};
        int[] crr = {-1, -2, -1, -3, 4};

        /*  Target = 0
        *   Example the three elements are: 2, -1, -1 that makes the sum = 0;
        *   We will store the first array elements in the set DS
        *   Now we will use nested loop for brr and crr to find the remaining element
        *   It can be calculated using the equation a + b + c = 0  -> a = - ( b + c)
        *   if (set contains -1 * (b + c)) //Negative of (b + c)
        *
        * We could use 3 nested loops for arr, brr and crr. But that will cause the TC O(i*j*k)
        * Instead using Set Data Structure will reduce TC to O(j*k) and SC will be O(i)
        * Here i, j and k are the length of the array arr, brr and crr respectively.
        * */

        triplet(arr, brr, crr);
    }

    private static void triplet(int[] arr, int[] brr, int[] crr) {
        HashSet<Integer> set = new HashSet<>();
        for (int i : arr)
            set.add(i);

        for (int i=0; i<brr.length; i++) {
            for (int j=0; j<crr.length; j++) {
                if (set.contains(-1 * (brr[i] + crr[j]))) {
                    System.out.println("The triplets are: (" + (-1*(brr[i]+crr[j]) +","+ brr[i] +","+ crr[j]) +")");
                }
            }
        }
    }
}
