package Tree.BT;

import Tree.TreeNode;

//Invert a BT and print its preorder
//Leetcode: https://leetcode.com/problems/invert-binary-tree/
public class Mirror_Invert_BT {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(9);

        System.out.print("Original BT: ");
        printTree(root);
        System.out.print("\nMirror BT: ");
        printTree(invert(root));
    }

    private static TreeNode invert(TreeNode root) {
        if (root==null) return null;
        TreeNode left = invert(root.left);
        TreeNode right = invert(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

    private static void printTree(TreeNode root) {
        if (root == null) return;
        System.out.print(root.val+" ");
        printTree(root.left);
        printTree(root.right);
    }
}
