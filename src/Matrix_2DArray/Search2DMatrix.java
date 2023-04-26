package Matrix_2DArray;

//Leetcode: https://leetcode.com/problems/search-a-2d-matrix/
//Constraints:
//        m == matrix.length
//        n == matrix[i].length
//        1 <= m, n <= 100
//        -10^4 <= matrix[i][j], target <= 10^4

import java.util.Scanner;

public class Search2DMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        System.out.println("Enter an element to search: ");
        int target = sc.nextInt();
        System.out.println(searchMatrix(matrix, target));

    }

    private static boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length, col = matrix[0].length;
        int itRow = row - 1, itCol = 0;

        while (itRow >= 0 && itCol < col) {
            if (matrix[itRow][itCol] == target)
                return true;
            else if (matrix[itRow][itCol] > target)
                itRow--;
            else
                itCol++;
        }

        return false;
    }
}
