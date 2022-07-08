//Leetcode: https://leetcode.com/problems/delete-node-in-a-linked-list/
public class deleteA_LinkedListNode {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int data) {
            this.val = data;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        printNode(head);

        delete(head.next); //2 is passed or the 2nd node
        System.out.println();

        printNode(head);
    }

    private static void printNode(ListNode head) {
        if(head==null) return;
        ListNode temp = head;
        while(temp!=null) {
            System.out.print(temp.val);
            temp = temp.next;
        }
    }

    public static void delete(ListNode node) {
        if (node != null && node.next != null) {
            node.val = node.next.val;
            node.next = node.next.next;
        }
    }
}
