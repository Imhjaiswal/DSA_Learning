package LinkedList.SinglyLL;

import java.util.ArrayList;
import java.util.List;

import LinkedList.SinglyLL.SinglyLinkedList.Node;

public class OddEvenLL {
    // BRUTEFORCE - T.C. : O(2N) & S.C. : O(N)
    static Node bruteForce (Node head) {
        if (head == null || head.next == null) return head;

        List<Integer> list = new ArrayList<>();

        // ODD POSITIONS
        Node temp = head;
        while (temp != null) {
            list.add(temp.data);
            if (temp.next == null) break;
            temp = temp.next.next;
        }

        // EVEN POSITIONS
        temp = head.next;
        while (temp != null) {
            list.add(temp.data);
            if (temp.next == null) break;
            temp = temp.next.next;
        }

        temp = head;
        int i = 0;
        while (temp != null) {
            temp.data = list.get(i);
            i++;
            temp = temp.next;
        }

        return head;
    }
    
    // better - T.C. : O(N) & S.C. : O(1)
    static Node better (Node head) {
        if (head == null || head.next == null) return head;

        Node dummyNodeOdd = new Node(-1);
        Node odd = dummyNodeOdd;

        Node dummyNodeEven = new Node(-1);
        Node even = dummyNodeEven;

        int position = 1;
        Node temp = head;
        
        while (temp != null) {
            if (position % 2 == 1) {
                even.next = temp;
                even = even.next;
            } else {
                odd.next = temp;
                odd = odd.next;
            }

            temp = temp.next;
            position++;
        }

        even.next = null;
        odd.next = dummyNodeEven.next;
        
        return dummyNodeOdd.next;
    }

    // OPTIMAL - T.C. : O(N) & S.C. : O(1)
    static Node optimal (Node head) {
        if (head == null || head.next == null) return head;

        Node odd = head;
        Node even = head.next;
        Node evenHead = even;

        while (even != null && even.next != null) {
            odd.next = odd.next.next;
            odd = odd.next;

            even.next = even.next.next;
            even = even.next;
        }

        odd.next = evenHead;

        return head;
    }
}
