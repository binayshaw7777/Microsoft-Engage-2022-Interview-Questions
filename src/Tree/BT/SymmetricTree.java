package Tree.BT;//GFG: https://www.geeksforgeeks.org/symmetric-tree-tree-which-is-mirror-image-of-itself/
//Leetcode: https://leetcode.com/problems/symmetric-tree/

import Tree.TreeNode;

public class SymmetricTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(1);
        root.right.right = new TreeNode(3);
        root.right.left = new TreeNode(1);

        if (root == null) System.out.println("true");
        else System.out.print(isSymmetric(root, root));

        /*        5
         *      / | \
         *     4  |  4
         *   / \  |  / \
         *  3  1  |  1  3
         *
         * */
    }

    private static boolean isSymmetric(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return true;

        if (root1 != null && root2 != null && root1.val == root2.val)
            return (isSymmetric(root1.left, root2.right) && isSymmetric(root1.right, root2.left));

        return false;
    }
}
