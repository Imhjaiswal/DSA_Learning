package LinkedList.SinglyLL;

import java.util.HashMap;

import LinkedList.SinglyLL.SinglyLinkedList.RNode;

public class CloneSLLWithNextAndRandomPointer {
    // BRUTEFORCE
    // T.C. - O(2N) & S.C. - O(2N) -- Map & new Node
    RNode bruteForce (RNode head) {
        if (head == null) return null;

        HashMap<RNode, RNode> map = new HashMap<>();
        RNode temp = head;

        while (temp != null) {
            map.put(temp, new RNode(temp.data));
            temp = temp.next;
        }

        temp = head;

        while (temp != null) {
            RNode clonedNode = map.get(temp);

            clonedNode.next = map.get(temp.next);
            clonedNode.random = map.get(temp.random);

            temp = temp.next;
        }

        return map.get(head);
    }

    // OPTIMAL
    // T.C. - O(3N) & S.C. - O(N)
    RNode optimal (RNode head) {
        if (head == null) return head;

        RNode temp = head;

        // STEP 1 : INSERT COPY OF NODE IN BETWEEN
        while (temp != null) {
            RNode copyNode = new RNode(temp.data);

            copyNode.next = temp.next;
            temp.next = copyNode;

            temp = temp.next.next;
        }

        // STEP 2 : COPY RANDOM POINTERS
        temp = head;
        while (temp != null) {
            if (temp.random != null ) temp.next.random = temp.random.next;
            temp = temp.next.next;
        }

        temp = head;
        RNode dummyNode = new RNode(-1);
        RNode res = dummyNode;

        // STEP 3 : RESTORE ORIGINAL LL & COPY
        while (temp != null) {
            res.next = temp.next;
            temp.next = temp.next.next;

            res = res.next;
            temp = temp.next;
        }

        return dummyNode.next;
    }
}
