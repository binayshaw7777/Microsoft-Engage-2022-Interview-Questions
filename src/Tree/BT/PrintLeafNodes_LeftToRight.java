package Tree.BT;

import Tree.TreeNode;

public class PrintLeafNodes_LeftToRight {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(1);
        root.right.right = new TreeNode(9);
        root.right.left = new TreeNode(7);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(8);

        printLeftToRight(root);     //Pre-Order principle

        /*       5
         *      / \
         *     3   1
         *    / \  / \
         *   4  8  7  9
         *
         * */
    }

    private static void printLeftToRight(TreeNode root) {
        if (root == null) return;
        if (root.left == null && root.right == null) System.out.print(root.val + " ");
        printLeftToRight(root.left);
        printLeftToRight(root.right);
    }
}
