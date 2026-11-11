package LinkedList.SinglyLL;

import java.util.Stack;

import LinkedList.SinglyLL.SinglyLinkedList.Node;

public class ReverseSLL {
    // BRUTEFORCE - 
    // T.C. - O(2N) & S.C. - O(N)
    static Node bruteForce (Node head) {
        if (head == null || head.next == null) return head;

        Stack<Integer> st = new Stack<>();

        Node temp = head;

        while (temp != null) {
            st.push(temp.data);
            temp = temp.next;
        }

        temp = head;

        while (temp != null) {
            temp.data = st.pop();
            temp = temp.next;
        }

        return head;
    }

    // OPTIMAL
    // T.C. - O(N) & S.C. - O(1)
    static Node optimal (Node head) {
        if (head == null || head.next == null) return head;

        Node prev = null;
        Node temp = head;

        while (temp != null) {
            Node nextNode = temp.next;
            temp.next = prev;
            prev = temp;
            temp = nextNode;
        }

        return prev;
    }
}
