package LinkedList.SinglyLL;

import java.util.Stack;

import LinkedList.SinglyLL.SinglyLinkedList.Node;

public class PalindromeSLL {
    // BRUTEFORCE
    // T.C. - O(2N) & S.C. - O(N)
    static boolean bruteForce (Node head) {
        if (head == null || head.next == null) return true;
        
        Node temp = head;
        Stack <Integer> st = new Stack<>();

        while (temp != null) {
            st.push(temp.data);
            temp = temp.next;
        }

        temp = head;

        while (temp != null) {
            if (temp.data != st.pop()) return false;
            temp = temp.next;
        }
        return true;
    }

    // OPTIMAL
    // T.C. - O(N/2 + N/2) = O(N) & S.C. - O(1)
    static boolean optimal (Node head) {
        if (head == null || head.next == null) return true;

        Node slow = head;
        Node fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node first = head;

        Node newHead = reverseLL(slow.next);
        Node second = newHead;

        while (second != null) {
            if (first.data != second.data) {
                reverseLL(newHead);
                return false;
            }

            first = first.next;
            second = second.next;
        }

        reverseLL(newHead);
        return true;
    }

    static Node reverseLL (Node head) {
        if (head == null || head.next == null) return head;

        Node temp = head;
        Node prev = null;

        while (temp != null) {
            Node nextNode = temp.next;
            temp.next = prev;
            prev = temp;
            temp = nextNode;
        }

        return prev;
    }
}
