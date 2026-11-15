package LinkedList.SinglyLL;

import LinkedList.SinglyLL.SinglyLinkedList.Node;

public class MidOfLL {
    // BRUTEFORCE
    // T.C. - O(3N/2) & S.C. - O(1)
    Node bruteforce (Node head) {
        if (head == null || head.next == null) return head;

        int len = 0;
        Node temp = head;

        while (temp != null) {
            len++;
            temp = temp.next;
        }

        temp = head;
        int mid = len/2 + 1;

        for (int i=1; i<mid; i++) {
            temp = temp.next;
        }
        
        return temp;
    }

    // Optimal
    // T.C. - O(N/2) & S.C. - O(1)
    Node optimal (Node head) {
        if (head == null || head.next == null) return head;

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
