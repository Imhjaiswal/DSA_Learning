package LinkedList.SinglyLL.CycleOrLoopProblems;

import java.util.HashSet;

import LinkedList.SinglyLL.SinglyLinkedList.Node;

public class DetectCycle {
    // BRUTEFORCE
    // T.C. - O(N) & S.C. - O(N)
    static boolean burteforce (Node head) {
        if (head == null || head.next == null) return false;

        Node temp = head;
        HashSet<Node> set = new HashSet<>();

        while (temp != null) {
            if (set.contains(temp)) return true;

            set.add(temp);
            temp = temp.next;
        }

        return false;
    }

    // OPTIMAL
    // T.C. - O(N) & S.C. - O(1)
    static boolean optimal (Node head) {
        if (head == null || head.next == null) return false;

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) return true;
        }

        return false;
    }
}
