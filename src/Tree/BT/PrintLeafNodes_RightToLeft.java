package Tree.BT;

public class PrintLeafNodes_RightToLeft {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int data) {
            this.val = data;
            this.left = this.right = null;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(1);
        root.right.right = new TreeNode(9);
        root.right.left = new TreeNode(7);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(8);

        printRightToLeft(root);     //Modified Pre-Order Principle

        /*       5
         *      / \
         *     3   1
         *    / \  / \
         *   4  8  7  9
         *
         * */
    }

    private static void printRightToLeft(TreeNode root) {
        if (root == null) return;
        if (root.left == null && root.right == null) System.out.print(root.val + " ");
        printRightToLeft(root.right);
        printRightToLeft(root.left);
    }
}
