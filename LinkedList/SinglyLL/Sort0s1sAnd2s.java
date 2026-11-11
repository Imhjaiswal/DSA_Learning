package LinkedList.SinglyLL;

import LinkedList.SinglyLL.SinglyLinkedList.Node;

public class Sort0s1sAnd2s {
    // BRUTEFORCE
    // T.C. - O(2N) & S.C. - O(1)
    Node bruteForce (Node head) {
        if (head == null || head.next == null) return head;

        int zero = 0;
        int one = 0;
        int two = 0;
        Node temp = head;

        while (temp != null) {
            if (temp.data == 0) zero++;
            else if (temp.data == 1) one++;
            else two++;

            temp = temp.next;
        }

        temp = head;
        while (zero > 0 && temp != null) {
            temp.data = 0;
            zero--;
            temp = temp.next;
        }

        while (one > 0 && temp != null) {
            temp.data = 1;
            one--;
            temp = temp.next;
        }

        while (two > 0 && temp != null) {
            temp.data = 2;
            two--;
            temp = temp.next;
        }

        return head;
    }

    // BETTER
    // T.C. - O(N) & S.C. - O(1)
    Node better (Node head) {
        if (head == null || head.next == null) return head;

        Node dummyZero = new Node(-1);
        Node zero = dummyZero;
        
        Node dummyOne = new Node(-1);
        Node one = dummyOne;
        
        Node dummyTwo = new Node(-1);
        Node two = dummyTwo;

        Node temp = head;

        while (temp != null) {
            if (temp.data == 0) {
                zero.next = temp;
                zero = zero.next;
            } else if (temp.data == 1) {
                one.next = temp;
                one = one.next;
            } else {
                two.next = temp;
                two = two.next;
            }

            temp = temp.next;
        }

        zero.next = (dummyOne.next != null) ? dummyOne.next : dummyTwo.next;
        one.next = dummyTwo.next;
        two.next = null;

        return dummyZero.next;
    }

    // OPTIMAL
    // T.C. - O() & S.C. - O()
    Node optimal (Node head) {
        if (head == null || head.next == null) return head;

        Node zero = new Node(-1);
        Node zeroHead = zero;
        Node one = new Node(-1);
        Node two = new Node(-1);

        Node temp = head;

        while (temp != null) {
            if (temp.data == 0) {
                zero.next = temp;
                zero = zero.next;
            } else if (temp.data == 1) {
                one.next = temp;
                one = one.next;
            } else {
                two.next = temp;
                two = two.next;
            }

            temp = temp.next;
        }
        

        return zeroHead.next;
    }
}
