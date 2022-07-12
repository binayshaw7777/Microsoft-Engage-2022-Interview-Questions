//Leetcode: https://leetcode.com/problems/search-a-2d-matrix/
public class SearchElementAtMatrix {
    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        int targetElement = 8;

        linearSearch(arr, targetElement);
        binarySearch(arr, targetElement);
    }

    private static void binarySearch(int[][] arr, int target) {
        if (arr.length == 0) {
            System.out.println("Element not found!");
            return;
        }
        int row = arr.length, col = arr[0].length;
        int left = 0, right = row * col - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int m = arr[mid/col][mid%col];

            if (target == m) {
                System.out.println("Element found at index (" + mid/col + "," + mid%col + ")");
                return;
            } else if (target < m)
                right = mid-1;
            else
                left = mid+1;
        }
    }

    private static void linearSearch(int[][] arr, int target) {
        for (int i=0; i<arr.length; i++) {
            for (int j=0; j<arr[0].length; j++) {
                if (arr[i][j] == target) {
                    System.out.println("Element found at index (" + i +"," + j +")");
                    return;
                }
            }
        }
        System.out.println("Element not found!");
    }
}
