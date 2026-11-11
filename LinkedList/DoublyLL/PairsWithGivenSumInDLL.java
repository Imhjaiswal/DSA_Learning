package LinkedList.DoublyLL;

import java.util.ArrayList;
import java.util.List;

import LinkedList.DoublyLL.DoublyLinkedList.Node;

public class PairsWithGivenSumInDLL {
    // BRUTEFORCE
    // T.C. - O(N**2) & S.C. - O(1) --excluding output List
    static List<List<Integer>> bruteforce (Node head, int k) {
        List<List<Integer>> pairs = new ArrayList<>();

        if (head == null || head.next == null) return pairs;

        Node temp1 = head;

        while (temp1.next != null) {
            Node temp2 = temp1.next;

            while (temp2 != null && temp1.data + temp2.data <= k) {
                if (temp1.data + temp2.data == k) {
                    List<Integer> list = new ArrayList<>();
                    list.add(temp1.data);
                    list.add(temp2.data);

                    pairs.add(list);
                }
                temp2 = temp2.next;
            }

            temp1 = temp1.next;
        }
        return pairs;
    }

    // OPTIMAL
    // T.C. - O(N) & S.C. - O(1) --excluding output List
    static List<List<Integer>> optimal (Node head, int k) {
        List<List<Integer>> pairs = new ArrayList<>();

        if (head == null || head.next == null) return pairs;

        Node left = head;
        Node right = head;
        // FIND TAIL
        while (right.next != null) {
            right = right.next;
        }

        while (left != right && left.back != right) {
            int sum = left.data + right.data;

            if (sum == k) {
                List<Integer> list = new ArrayList<>();

                list.add(left.data);
                list.add(right.data);
                pairs.add(list);

                left = left.next;
                right = right.next;
            } 
            else if (sum > k) {
                right = right.back;
            } 
            else {
                left = left.next;
            }

        }

        return pairs;
    }
}