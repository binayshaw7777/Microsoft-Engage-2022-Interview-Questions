//Leetcode: https://leetcode.com/problems/merge-k-sorted-lists/
//GFG: https://www.geeksforgeeks.org/merge-k-sorted-linked-lists/

package LinkedList;

import java.util.PriorityQueue;

public class mergeKsortedLists {

    public static void main(String[] args) {
        ListNode head1 = new ListNode();
        for (int i = 1; i <= 20; i+=4)
            push(head1, i);
        printNode(head1.next);

        ListNode head2 = new ListNode();
        for (int i=2; i<=20; i+=5)
            push(head2, i);
        printNode(head2.next);

        ListNode head3 = new ListNode();
        for (int i=3; i<=20; i+=3)
            push(head3, i);
        printNode(head3.next);

        ListNode head4 = new ListNode();
        for (int i=4; i<=20; i+=4)
            push(head4, i);
        printNode(head4.next);

        ListNode[] list = {head1.next, head2.next, head3.next, head4.next};

        ListNode merged = mergeLists(list);

        System.out.println("\nMerged: ");

        printNode(merged);
    }

    private static ListNode mergeLists(ListNode[] list) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (ListNode head : list) {
            while (head != null) {
                pq.add(head.val);
                head = head.next;
            }
        }

        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;

        while (!pq.isEmpty()) {
            head.next = new ListNode(pq.poll());
            head = head.next;
        }

        return dummy.next;
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

    private static void push(ListNode head, int i) {
        if (head==null) {
            ListNode newHead = new ListNode(i);
            head = newHead;
        } else {
            ListNode temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new ListNode(i);
        }
    }
}
