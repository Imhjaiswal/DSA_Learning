package LinkedList.SinglyLL;

import LinkedList.SinglyLL.SinglyLinkedList.Node;

public class RotateSLL {
    // 
    // 
    Node optimal (Node head, int k) {
        if (head == null || head.next == null) return head;

        Node tail = head;
        int len = 1;
        while (tail.next != null) {
            len++;
            tail = tail.next;
        }

        k = k % len;
        if (k == 0) return head;
        

        tail.next = head;
        Node newTail = findNewTail(head, len - k);
        head = newTail.next;
        newTail.next = null;

        return head;
    }

    Node findNewTail (Node head, int position) {
        Node tail = head;
        for (int i=1; i<position; i++) {
            tail = tail.next;
        }
        return tail;
    }
}
