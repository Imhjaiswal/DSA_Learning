package LinkedList.SinglyLL;

import LinkedList.SinglyLL.SinglyLinkedList.Node;

public class RemoveNthNodeFromEnd {
    // BRUTEFORCE -
    // T.C. - O(2N) & S.C. - O(1)
    Node bruteForce (Node head, int N) {
        if (head == null || N <= 0) return head;

        int count = 0;
        Node temp = head;

        // COUNT TOTAL NODES
        while (temp != null) {
            count++;
            temp = temp.next;
        }

        if (N > count) return head;

        if (N == count) return head.next;

        temp = head;

        for (int i=1; i<=count-N; i++) {
            temp = temp.next;
        }

        temp.next = temp.next.next;

        return head;
    }

    // Optimal
    // T.C. - O(N) & S.C. - O(1)
    Node optimal (Node head, int N) {
        if (head == null || N <= 0) return head;

        Node dummy = new Node(-1);
        dummy.next = head;
        Node fast = dummy;
        Node slow = dummy;

        for (int i=0; i<=N; i++) {
            if (fast == null) return head;
            fast = fast.next;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        
        slow.next = slow.next.next;

        return dummy.next;
    }
}
