package LinkedList.SinglyLL;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import LinkedList.SinglyLL.SinglyLinkedList.CNode;

public class FlattenASLL {
    // BRUTEFORCE
    // T.C. - 2 * O(N * M) + X*logX & S.C. - O(N + M)
    CNode bruteForce (CNode head) {
        if (head == null) return head;

        CNode temp = head;
        List<Integer> list = new ArrayList<>();

        while (temp != null) {
            CNode ch = temp;

            while (ch != null) {
                list.add(ch.data);
                ch = ch.child;
            }
            temp = temp.next;
        }

        if (list.size() == 0) return null;

        Collections.sort(list);

        head = new CNode(list.get(0));
        temp = head;

        for (int i=1; i<list.size(); i++) {
            CNode newNode = new CNode (list.get(i));
            temp.child = newNode;
            temp = temp.child;
        }

        return head;
    }

    // OPTIMAL
    // T.C. - & S.C. -
}
