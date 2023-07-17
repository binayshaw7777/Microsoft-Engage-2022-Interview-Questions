package Tree.BT;

import Tree.TreeNode;

public class LCA_BT {

    public static void main(String[] args) {
        //3 5 1 6 2 0 8 7 4
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        System.out.print("Tree: ");
        printTree(root);
        System.out.println();

        TreeNode node1 = lowestCommonAncestor(root, root.left, root.left.right.right);
        TreeNode node2 = lowestCommonAncestor(root, root.left, root.right);
        System.out.println(node1.val);
        System.out.println(node2.val);
    }

    private static void printTree(TreeNode root) {
        if (root == null) return;
        System.out.print(root.val+" ");
        printTree(root.left);
        printTree(root.right);
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root.val == p.val || root.val == q.val) return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left == null) return right;
        if (right == null) return left;

        return root;
    }
}
