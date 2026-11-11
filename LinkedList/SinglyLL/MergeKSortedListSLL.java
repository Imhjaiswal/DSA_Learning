package LinkedList.SinglyLL;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

import LinkedList.SinglyLL.SinglyLinkedList.Node;

public class MergeKSortedListSLL {
    // BRUTEFORCE
    // T.C. - O(2N) + N*logN & S.C. - O(2N)
    Node bruteforce (Node[] lists) {
        List<Integer> list = new ArrayList<>();

        for (Node node: lists) {
            while (node != null) {
                list.add(node.data);
                node = node.next;
            }
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

    // BETTER
    // T.C. - O(N * (K * (K+1)/2) ) == O(N * K**2) ~ O(N**3)
    // S.C. - O(1) --using existing nodes & connecting to next
    // K = number of linked lists.
    // N = total number of nodes across all lists.
    Node better (Node[] lists) {
        if (lists == null || lists.length == 0) return null;

        Node head = lists[0];

        for (int i=1; i<lists.length; i++) {
            head = mergeLists(head, lists[i]);
        }

        return head;
    }

    Node mergeLists (Node head1, Node head2) {
        Node dummyHead = new Node(-1);
        Node temp = dummyHead;

        Node t1 = head1;
        Node t2 = head2;

        while (t1 != null && t2 != null) {
            if (t1.data <= t2.data) {
                temp.next = t1;
                t1 = t1.next;
            } else {
                temp.next = t2;
                t2 = t2.next;
            }
            temp = temp.next;
        }

        if (t1 != null) {
            temp.next = t1;
        } else {
            temp.next = t2;
        }

        return dummyHead.next;
    }

    // TBD
    // OPTIMAL
    // T.C. - & S.C. -
    Node optimal (Node[] lists) {
        if (lists == null || lists.length == 0) return null;

        Node dummy = new Node(-1);

        return dummy.next;
    }
}
