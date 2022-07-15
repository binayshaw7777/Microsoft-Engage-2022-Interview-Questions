package Queues;//GFG: https://www.geeksforgeeks.org/implement-stack-using-queue/
//Video Reference: https://www.youtube.com/watch?v=jDZQKzEtbYQ (Striver)
//Leetcode: https://leetcode.com/problems/implement-stack-using-queues/

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class StackUsingQueue {
    static class Stack {
        static Queue<Integer> q1 = new LinkedList<>();
        static Queue<Integer> q2 = new LinkedList<>();
        static int curr_size;

        Stack() {
            curr_size = 0;
        }

        static void push(int x) {
            curr_size++;
            q2.add(x);  // Push x first in empty q2

            while (!q1.isEmpty()) // Push all the remaining elements in q1 to q2.
                q2.add(q1.remove());

            // swap the names of two queues
            Queue<Integer> q = q1;
            q1 = q2;
            q2 = q;
            System.out.println("Element pushed: " + x);
        }

        static void pop() {
            // if no elements are there in q1
            if (q1.isEmpty())
                return;
            System.out.println("Element popped: " + q1.remove());
            curr_size--;
        }

        static int top() {
            if (q1.isEmpty())
                return -1;
            return q1.peek();
        }

        static int size() {
            return curr_size;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack s = new Stack();
        boolean loop = true;
        System.out.println("Enter your operation: ");
        while (loop) {
            System.out.println("1. Push\n2. Pop\n3. Top\n4. Size\n5. Exit");
            int n = sc.nextInt();
            switch (n) {
                case 1-> {
                    System.out.println("Enter the value to push");
                    int x = sc.nextInt();
                    s.push(x);
                }
                case 2-> {s.pop();}
                case 3-> {
                    System.out.println("Top of the Stack is: " + s.top());
                }
                case 4-> {System.out.println(s.size());}
                case 5-> {loop = false;}
                default -> {System.out.println("Wrong Input!");}
            }
        }
    }
}
