package LinkedList.SinglyLL;

import java.util.HashSet;

import LinkedList.SinglyLL.SinglyLinkedList.Node;

public class IntersectionOfYLL {
    // BRUTEFORCE
    // T.C. - O(N + M) & S.C. - O(N)
    Node bruteforce (Node head1, Node head2) {
        if (head1 == null || head2 == null) return null;

        HashSet<Node> set = new HashSet<>();

        Node temp1 = head1;

        while (temp1 != null) {
            set.add(temp1);
            temp1 = temp1.next;
        }

        Node temp2 = head2;

        while (temp2 != null) {
            if (set.contains(temp2)) {
                return temp2;
            }
            temp2 = temp2.next;
        }

        return null;
    }

    // BETTER
    // T.C. - (O(N + M) + O(N - M) + O(N)) = O(3N) & S.C. - O(1)
    Node better (Node head1, Node head2) {
        if (head1 == null || head2 == null ) return null;

        Node temp1 = head1;
        int n1 = 0;
        Node temp2 = head2;
        int n2 = 0;

        while (temp1 != null) {
            n1++;
            temp1 = temp1.next;
        }

        while (temp2 != null) {
            n2++;
            temp2 = temp2.next;
        }

        temp1 = head1;
        temp2 = head2;

        if (n1 > n2) {
            return intersectionNode(temp2 , temp1, n1-n2);
        } else {
            return intersectionNode(temp1, temp2, n2-n1);
        }
    }

    Node intersectionNode (Node smallerNode, Node largerNode, int difference) {
        if (difference > 0) {
            for (int i=1; i<=difference; i++) {
                largerNode = largerNode.next;
            }
        }

        while (smallerNode != largerNode) {
            smallerNode = smallerNode.next;
            largerNode = largerNode.next;
        }

        return smallerNode;
    }

    // OPTIMAL
    // T.C. - O(N+M) & S.C. - O(1)
    Node optimal (Node head1, Node head2) {
        if (head1 == null || head2 == null) return null;

        Node temp1 = head1;
        Node temp2 = head2;

        while (temp1 != temp2) {
            temp1 = temp1.next;
            temp2 = temp2.next;

            if (temp1 == temp2) return temp1;

            if (temp1 == null) temp1 = head2;
            if (temp2 == null) temp2 = head1;
        }

        return temp1;
    }
}