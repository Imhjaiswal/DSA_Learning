package LinkedList.SinglyLL;

import LinkedList.SinglyLL.SinglyLinkedList.Node;

public class Add2SLL {
    Node optimal (Node l1, Node l2) {
        Node dummyHead = new Node(-1);
        Node curr = dummyHead;
        Node temp1 = l1;
        Node temp2 = l2;
        int carry = 0;

        while (temp1 != null || temp2 != null) {
            int sum = carry;

            if (temp1 != null) sum += temp1.data;
            if (temp2 != null) sum += temp2.data;

            curr.next = new Node(sum % 10);
            curr = curr.next;

            carry = sum / 10;

            if (temp1 != null) temp1 = temp1.next;
            if (temp2 != null) temp2 = temp2.next;
        }

        if (carry == 1) curr.next = new Node(carry);

        return dummyHead.next;
    }
}
