package LinkedList.SinglyLL.CycleOrLoopProblems;

import java.util.HashSet;

import LinkedList.SinglyLL.SinglyLinkedList.Node;

public class StartingNodeOfCycle {
    // BRUTEFORCE
    // T.C. - O(N) & S.C. - O(N)
    Node bruteforce (Node head) {
        if (head == null || head.next == null) return null;

        Node temp = head;
        HashSet<Node> set = new HashSet<>();

        while (temp != null) {
            if (set.contains(temp)) return temp;

            set.add(temp);
            temp = temp.next;
        }

        return null;
    }
    
    // OPTIMAL
    // T.C. - O(N + N/2) & S.C. - O(1)
    Node optimal (Node head) {
        if (head == null || head.next == null) return null;
        
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                slow = head;

                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }

                return slow;
            }
        }

        return null;
    }
}