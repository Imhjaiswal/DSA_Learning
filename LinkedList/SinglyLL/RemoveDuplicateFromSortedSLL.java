package LinkedList.SinglyLL;

import LinkedList.SinglyLL.SinglyLinkedList.Node;

public class RemoveDuplicateFromSortedSLL {
    // OPTIMAL
    // T.C. - & S.C. - 
    Node optimal (Node head) {
        if (head == null || head.next == null) return head;

        Node temp = head;

        while (temp != null && temp.next != null) {
            Node nextNode = temp.next;

            while (nextNode != null && nextNode.data == temp.data) {
                nextNode = nextNode.next;
            }

            temp.next = nextNode;
            temp = nextNode;
        }
        return head;
    }
}
