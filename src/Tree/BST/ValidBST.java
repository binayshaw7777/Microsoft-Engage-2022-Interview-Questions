package Tree.BST;

//Reference: https://www.geeksforgeeks.org/a-program-to-check-if-a-binary-tree-is-bst-or-not/
//Leetcode: https://leetcode.com/problems/validate-binary-search-tree/
public class ValidBST {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int data) {
            this.val = data;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(5);

        System.out.println(isValid(root));
    }

    private static boolean isValid(TreeNode node) {
        if (node == null) return true;
        if (node.left != null && node.left.val > node.val) return false;
        if (node.right != null && node.right.val < node.val) return false;
        return isValid(node.left) && isValid(node.right);
    }
}
