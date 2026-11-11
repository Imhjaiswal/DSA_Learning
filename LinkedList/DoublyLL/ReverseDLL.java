package LinkedList.DoublyLL;

import java.util.Stack;

import LinkedList.DoublyLL.DoublyLinkedList.Node;

public class ReverseDLL {
    // BRUTEFORCE
    // T.C. - O(2N) & S.C. - O(N)
    static Node bruteForce (Node head) {
        if (head == null || head.next == null) return head;

        Stack <Integer> st = new Stack<>();
        Node temp = head;

        // STORING FROM DLL TO STACK
        while (temp != null) {
            st.push(temp.data);
            temp = temp.next;
        }

        // STORING BACK INTO DLL FROM STACK
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
        Node temp = head;

        while (temp != null) {
            Node front = temp.next;
            temp.next = temp.back;
            temp.back = front;
            
            temp = temp.back;
        }

        return head;
    }
}
