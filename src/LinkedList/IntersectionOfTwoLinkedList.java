package LinkedList;//Leetcode: https://leetcode.com/problems/intersection-of-two-linked-lists/

public class IntersectionOfTwoLinkedList {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int data) {
            this.val = data;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        ListNode first = new ListNode(1);
        first.next = new ListNode(2);
        first.next.next = new ListNode(3);
        first.next.next.next = new ListNode(4);
        first.next.next.next.next = new ListNode(5);

        ListNode second = new ListNode(1);
        second.next = new ListNode(2);
        second.next.next = new ListNode(3);
        second.next.next.next = first.next.next.next;

        intersection(first, second);
    }

    private static void intersection(ListNode first, ListNode second) {
        if (first==null || second==null) return;
        ListNode firstHead = first;
        ListNode secondHead = second;

        while (firstHead != secondHead) {
            if (firstHead == null) firstHead = second;
            else firstHead = firstHead.next;

            if (secondHead == null) secondHead = first;
            else secondHead = secondHead.next;
        }
        System.out.println(firstHead.val);
    }
}
