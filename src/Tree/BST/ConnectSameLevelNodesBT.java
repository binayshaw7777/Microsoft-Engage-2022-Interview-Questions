package Tree.BST;//Leetcode: https://leetcode.com/problems/populating-next-right-pointers-in-each-node/

//Does not works

public class ConnectSameLevelNodesBT {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode next;
        TreeNode (int data) {
            this.val = data;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(8);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);

//        TreeNode node = connect(root);

        printNode(root);
        System.out.println();
//        printNode(node);
    }

    private static void printNode(TreeNode root) {
        if (root == null) return;
        System.out.print(root.next.val);
        printNode(root.left);
        printNode(root.right);
    }

    public static TreeNode connect(TreeNode root) {
        if (root == null) return root;
        TreeNode temp = root;
        while (temp.left != null) {
            TreeNode head = temp;
            while (head != null) {
                head.left.next = head.right;
                if (head.next != null)
                    head.right.next = head.next.left;
                head = head.next;
            }
            temp = temp.left;
        }
        return root;
    }

//    private static void connect(TreeNode root) {
//        if (root == null) return;
//
//        if (root.left != null) {
//            root.left.next = root.right;
//            if (root.next != null)  root.right.next = root.next.left;
//        }
//        connect(root.left);
//        connect(root.right);
//    }
}
