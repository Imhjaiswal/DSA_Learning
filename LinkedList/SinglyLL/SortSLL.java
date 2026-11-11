package LinkedList.SinglyLL;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import LinkedList.SinglyLL.SinglyLinkedList.Node;

public class SortSLL {
    // BRUTEFORCE
    // T.C. - O(2N + NLogN) & S.C. - O(N)
    Node burteforce (Node head) {
        if (head == null || head.next == null) return head;

        List<Integer> list = new ArrayList<>();
        Node temp = head;

        while (temp != null) {
            list.add(temp.data);
            temp = temp.next;
        }

        Collections.sort(list);
        temp = head;
        
        for (int i=0; i<list.size(); i++) {
            temp.data = list.get(i);
            temp = temp.next;
        }

        return head;
    }
    
    // BETTER
    // T.C. - & S.C. -
}
