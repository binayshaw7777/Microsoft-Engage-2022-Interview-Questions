package LinkedList;//Stack using LinkedList
//Reference: https://www.geeksforgeeks.org/implement-a-stack-using-singly-linked-list/

import java.util.Scanner;

public class StackViaLinkedList {
    static int size = -1;

    public static void main(String[] args) {
        ListNode head = new ListNode();
        Scanner sc = new Scanner(System.in);
        boolean loop = true;
        System.out.println("Enter your operation: ");
        while (loop) {
            System.out.println("1. Push\n2. Pop\n3. Top\n4. Size\n5. Exit");
            int n = sc.nextInt();
            switch (n) {
                case 1-> {
                    System.out.println("Enter the value to push");
                    int p = sc.nextInt();
                    push(head, p);
                }
                case 2-> {
                    if (size == -1)
                        System.out.println("Stack Underflow");
                    else
                        pop(head);
                }
                case 3-> {
                    if (size < 0)
                        System.out.println("No element in Stack");
                    else
                        top(head);
                }
                case 4-> {
                    System.out.println(size+1);
                }
                case 5-> {loop = false;}
                default -> {
                    System.out.println("Wrong Input!");
                }
            }
        }

    }

    private static void top(ListNode head) {
        ListNode temp = head;
        while (temp.next != null)
            temp = temp.next;
        System.out.println("Top: " + temp.val);
    }

    private static void pop(ListNode head) {
        size--;
        ListNode temp = head;
        ListNode prev = null;
        while (temp.next != null) {
            prev = temp;
            temp = temp.next;
        }
        prev.next = null;
    }

    private static void push(ListNode head, int p) {
        if (head == null) {
            head = new ListNode(p);
        } else {
            ListNode temp = head;
            while (temp.next != null)
                temp = temp.next;
            temp.next = new ListNode(p);
        }
    }
}
