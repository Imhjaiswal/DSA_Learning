package LinkedList.SinglyLL.CycleOrLoopProblems;

import java.util.HashSet;

import LinkedList.SinglyLL.SinglyLinkedList.Node;;

public class LengthOfCycle {
    // BruteForce
    // T.C. - O(2N) & S.C. - O(N)
    static int BruteForce (Node head) {
        if (head == null || head.next == null) return 0;

        Node temp = head;
        HashSet<Node> set = new HashSet<>();

        while (temp != null && temp.next != null) {
            if (set.contains(temp)) break;

            set.add(temp);
            temp = temp.next;
        }

        if (temp == null) return 0;

        Node cycleStart = temp;
        temp = temp.next;
        int count = 1;

        while (temp != cycleStart) {
            temp = temp.next;
            count++;
        }

        return count;
    }

    // OPTIMAL
    // T.C. - O(N) & S.C. - O(1)
    int optimal (Node head) {
        if (head == null || head.next == null) return 0;

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                int count = 1;
                fast = fast.next;

                while (slow != fast) {
                    count++;
                    fast = fast.next;
                }
                return count;
            }
        }

        return 0;
    }
}
