package LinkedList.SinglyLL;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import LinkedList.SinglyLL.SinglyLinkedList.Node;

public class MergeSortedSLL {
    // BRUTEFORCE
    // T.C. - O(2*(N + M) + (N+M)*Log(N+M)) & S.C. - O(N+M)
    Node bruteForce (Node head1, Node head2) {
        List<Integer> list = new ArrayList<>();

        Node t1 = head1;
        while (t1 != null) {
            list.add(t1.data);
            t1 = t1.next;
        }

        Node t2 = head2;
        while (t2 != null) {
            list.add(t2.data);
            t2 = t2.next;
        }

        Collections.sort(list);

        Node dummyHead = new Node(-1);
        Node temp = dummyHead;

        for (int num: list) {
            temp.next = new Node(num);
            temp = temp.next;
        }

        return dummyHead.next;
    }

    // OPTIMAL
    // T.C. - O(N+M) & S.C. - O(1)
    Node optimal (Node head1, Node head2) {
        Node t1 = head1;
        Node t2 = head2;
        Node dummy = new Node(-1);
        Node temp = dummy;

        while (t1 != null && t2 != null) {
            if (t1.data <= t2.data) {
                temp.next = t1;
                t1 = t1.next;
            }
            else {
                temp.next = t2;
                t2 = t2.next;
            }
            temp = temp.next;
        }

        if (t1 != null) {
            temp.next = t1;
        }
        else {
            temp.next = t2;
        }   

        return dummy.next;
    }
}