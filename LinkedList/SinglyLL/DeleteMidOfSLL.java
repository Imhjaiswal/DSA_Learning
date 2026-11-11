package LinkedList.SinglyLL;

import LinkedList.SinglyLL.SinglyLinkedList.Node;

public class DeleteMidOfSLL {
    // BRUTEFORCE
    // T.C. - O(N + N/2) & S.C. - O(1)
    Node bruteForce (Node head) {
        if (head == null || head.next == null) return null;

        int len = 0;
        Node temp = head;

        while (temp != null) {
            len++;
            temp = temp.next;
        }

        temp = head;
        int beforeMid = len/2;

        for (int i=1; i<beforeMid; i++) {
            temp = temp.next;
        }

        temp.next = temp.next.next;

        return head;
    }

    // OPTIMAL
    // T.C. - O(N) & S.C. - O(1)
    Node optimal (Node head) {
        if (head == null || head.next == null) return null;

        Node slow = head;
        Node fast = head.next.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        slow.next = slow.next.next;

        return head;
    }
}
