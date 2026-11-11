package LinkedList.SinglyLL;

import LinkedList.SinglyLL.SinglyLinkedList.Node;

public class Add1ToLL {
    // BRUTEFORCE 
    // T.C. - O(3N) & S.C. - O(1)
    Node bruteForce (Node head) {
        if (head == null) return new Node(1);

        Node newNode = reverseLL(head);
        Node temp = newNode;
        int carry = 1;

        while (temp != null) {
            int sum = carry + temp.data;
            
            temp.data = sum % 10;
            
            carry = sum / 10;
            if (carry == 0) break;

            temp = temp.next;
        }

        if (carry != 0) {
            Node extraNode = new Node(carry);
            newNode = insertAtHead(newNode, extraNode);
        }

        return reverseLL(newNode);
    }

    static Node insertAtHead (Node head, Node newHead) {
        newHead.next = head;
        return newHead;
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

    // RECURSIVE APPROACH - 
    // T.C. - O(N) & S.C. - O(N)
    Node recursive (Node head) {
        if (head == null) return new Node(1);

        int carry = addOne(head);

        if (carry == 1) {
            Node newNode = new Node(1);
            newNode.next = head;
            head = newNode;
        }

        return head;
    }

    int addOne (Node temp) {
        if (temp == null) return 1;

        int carry = addOne(temp.next);
        temp.data += carry;

        if (temp.data < 10) return 0;

        temp.data = 0;
        return 1;
    }
}