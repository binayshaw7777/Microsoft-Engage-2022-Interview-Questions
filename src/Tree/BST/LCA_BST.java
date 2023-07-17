package Tree.BST;

import Tree.TreeNode;

public class LCA_BST {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);

        System.out.print(LCA(root, root.left, root.left.right).val);
    }
    private static TreeNode LCA(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        int data = root.val;

        if (data < p.val && data < q.val) //p and q lie on the right side of the root so return right
            return LCA(root.right, p, q);

        if (data > p.val && data > q.val) //p and q lie on the left side of the root so return left
            return LCA(root.left, p, q);

        return root;    //p and q lie on the either side of the root, so return root
    }
}
