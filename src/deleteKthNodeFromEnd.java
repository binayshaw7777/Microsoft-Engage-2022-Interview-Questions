//Leetcode: https://leetcode.com/problems/remove-nth-node-from-end-of-list/

import java.util.Scanner;

public class deleteKthNodeFromEnd {
    static ListNode head;

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int data) {
            this.val = data;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int i=1; i<=10; i++)
            push(i);

        printNode();

        System.out.println("\nEnter the node to be deleted between the range 1 to 10\n");
        int n = sc.nextInt();

        removeLast(n);
        System.out.println("");
        printNode();
    }

    private static void removeLast(int n) {
        ListNode start = new ListNode(0);
        start.next = head;
        ListNode slow = start;
        ListNode fast = start;

        for (int i=1; i<=n; ++i) {
            fast = fast.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
    }

    private static void printNode() {
        if (head == null) return;
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val+" ");
            temp = temp.next;
        }
    }


    private static void push(int i) {
        if (head == null)
            head = new ListNode(i);
        else {
            ListNode temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new ListNode(i);
        }
    }
}
