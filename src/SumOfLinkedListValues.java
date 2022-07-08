public class SumOfLinkedListValues {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int data) {
            this.val = data;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        /*      LinkedList 1: 1->2->3  SumL1 = 123
        LinkedList 2: 4->5     Sum2 = 45
        Ans = Sum1 + Sum2 = 168     */

        ListNode head1 = new ListNode(1);
        ListNode head2 = new ListNode(4);
        push(head1, 2);
        push(head1, 3);
        printNode(head1);
        System.out.println("");

        push(head2, 5);
        printNode(head2);
        System.out.println("");

        summation(head1, head2);
    }

    private static void summation(ListNode head1, ListNode head2) {
        int sum1 = 0, sum2 = 0;
        ListNode temp1 = head1;
        ListNode temp2 = head2;
        while (temp1 != null) {
            sum1 = temp1.val + sum1 * 10;
            temp1 = temp1.next;
        }
        while (temp2 != null) {
            sum2 = temp2.val + sum2 * 10;
            temp2 = temp2.next;
        }
        System.out.println(sum1+sum2);
    }

    private static void printNode(ListNode head) {
        if(head==null) return;
        ListNode temp = head;
        while(temp!=null) {
            System.out.print(temp.val);
            temp = temp.next;
        }
    }

    private static void push(ListNode head, int i) {
        if (head==null) {
            head = new ListNode(i);
        } else {
            ListNode temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new ListNode(i);
        }
    }
}
