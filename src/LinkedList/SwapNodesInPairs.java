package LinkedList;//Leetcode: https://leetcode.com/problems/swap-nodes-in-pairs/
//GFG: https://www.geeksforgeeks.org/pairwise-swap-elements-of-a-given-linked-list/

public class SwapNodesInPairs {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int data) {
            this.val = data;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        printNode(head);

        ListNode newHead = swapPairs(head);

        printNode(newHead);
    }

    private static void printNode(ListNode head) {
        if (head == null) return;
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + "->");
            temp = temp.next;
        }
        System.out.print("null\n");
    }

    public static ListNode swapPairs(ListNode head) {
        ListNode temp = new ListNode(0);
        temp.next = head;
        ListNode curr = temp;

        while (curr.next != null && curr.next.next != null) {
            ListNode first = curr.next;
            ListNode second = curr.next.next;
            first.next = second.next;
            curr.next = second;
            curr.next.next = first;
            curr = curr.next.next;
        }
        return temp.next;
    }
}
