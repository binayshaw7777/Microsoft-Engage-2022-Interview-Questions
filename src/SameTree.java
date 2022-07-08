//LeetCode: https://leetcode.com/problems/same-tree/
import java.util.*;
public class SameTree {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int data) {
            this.val = data;
        }
    }
    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(5);
        root1.left = new TreeNode(3);
        root1.right = new TreeNode(6);
        root1.left.left = new TreeNode(2);
        root1.left.right = new TreeNode(4);

        TreeNode root2 = new TreeNode(5);
        root2.left = new TreeNode(3);
        root2.right = new TreeNode(6); //Comment this for false value
        //root2.right = new TreeNode(0);  //Comment this for true value
        root2.left.left = new TreeNode(2);
        root2.left.right = new TreeNode(4);

        System.out.println(sameTree(root1, root2));
    }

    private static boolean sameTree(TreeNode root1, TreeNode root2) {
        if (root1==null || root2==null) return root1==root2;
        return (root1.val==root2.val) && sameTree(root1.left, root2.left) && sameTree(root1.right, root2.right);
    }
}
