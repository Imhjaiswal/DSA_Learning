package LinkedList.DoublyLL;

import LinkedList.DoublyLL.DoublyLinkedList.Node;

public class DeleteOccurancesInDLL {
    // OPTIMAL
    // T.C. - O(N) & S.C. - O(1)
    Node optimal (Node head, int key) {
        if (head == null) return head;

        Node temp = head;

        while (temp != null) {
            Node nextNode = temp.next;

            if (temp.data == key) {
                if (temp == head) head = head.next;

                if (temp.back != null) {
                    temp.back.next = temp.next;
                }

                if (temp.next != null) {
                    temp.next.back = temp.back;                    
                }

                temp.next = null;
                temp.back = null;
            }

            temp = nextNode;
        }
        return head;
    }
}
