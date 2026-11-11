package LinkedList.DoublyLL;

import LinkedList.DoublyLL.DoublyLinkedList.Node;

public class RemoveDuplicatesFromSortedDLL {
    // OPTIMAL
    // T.C. - O(N) & S.C. - O(1)
    Node optimal (Node head) {
        if (head == null || head.next == null) return head;

        Node temp = head;

        while (temp != null && temp.next != null) {
            Node nextNode = temp.next;

            while (nextNode != null && nextNode.data == temp.data) {
                nextNode = nextNode.next;
            }
            
            temp.next = nextNode;
            if (nextNode != null) nextNode.back = temp;
            temp = nextNode;
        }
        return head;
    }
}