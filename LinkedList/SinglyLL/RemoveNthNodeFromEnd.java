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

        int nodeBeforeDelete = count - N;
        temp = head;
        int newCount = 0;

        while (temp != null) {
            newCount++;
            if (newCount == nodeBeforeDelete) {
                temp.next = temp.next.next;
                break;
            }
            temp = temp.next;
        }

        return head;
    }

    // Optimal
    // T.C. - & S.C. -
    Node optimal (Node head, int N) {
        if (head == null || N <= 0) return head;

        Node fast = head;
        Node slow = head;

        for (int i=1; i<=N; i++) {
            if (fast == null) return head;
            fast = fast.next;
        }

        if (fast == null) return head;

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        
        slow.next = slow.next.next;

        return head;
    }
}
