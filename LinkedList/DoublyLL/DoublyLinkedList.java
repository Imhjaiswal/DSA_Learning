package LinkedList.DoublyLL;

import java.util.Stack;

public class DoublyLinkedList {
    // IMPLEMENTATION OF DOUBLY LINKED LIST
    static class Node {
        int data;
        Node back;
        Node next;

        Node(int data) {
            this.data = data;
            this.back = null;
            this.next = null;
        }

        Node(int data, Node back, Node next) {
            this.data = data;
            this.back = back;
            this.next = next;
        }
    }

    static Node convertArr2DLL (int nums[]) {
        Node head = new Node(nums[0]);
        Node prev = head;

        for (int i=1; i<nums.length; i++) {
            Node temp = new Node(nums[i], prev,null);
            prev.next = temp;
            prev = temp;
        }

        return head;
    }

    static void printDLL (Node head) {
        Node temp = head;
        
        while (temp != null) {
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
    }

    static Node deleteHeadDLL (Node head) {
        if (head == null || head.next == null) return null;

        Node temp = head;
        head = head.next;

        head.back = null;
        temp.next = null;
        
        return head;
    }

    static Node deleteTailDLL (Node head) {
        if (head == null || head.next == null) return null;

        Node temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }

        temp.back.next = null;
        temp.back = null;

        return head;
    }

    static Node deleteElementOfDLL (Node head, int ele) {
        if (head == null) return null;

        Node temp = head;

        while (temp != null) {
            if (temp.data == ele) {
                // DELETE HEAD
                if (temp == head) return  head.next;
                // UPDATE PREVIOUS NODE
                if (temp.back != null) temp.back.next = temp.next;
                // UPDATE NEXT NODE
                if (temp.next != null) temp.next.back = temp.back;

                // REMOVE BACK & NEXT OF ELEMENT 
                temp.back = null;
                temp.next = null;

                break;
            }
            temp = temp.next;
        }

        return head;
    }

    // INSERT OPERATIONS
    static Node insertAtHead(Node head, int val) {
        if (head == null) return new Node(val);

        Node temp = new Node(val, null, head);
        head.back = temp;

        return temp;
    }

    static Node insertAtTail(Node head, int val) {
        if (head == null) return new Node(val);

        Node temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }

        Node newNode = new Node(val, temp, null);
        temp.next = newNode;

        return head;
    }

    static Node insertBeforePosK (Node head, int k, int val) {
        if (head == null) {
            if (k == 1) return  new Node(val, null, head);
            return null;
        }
        
        if (k <= 0) return head;

        if (k == 1) return  new Node(val, null, head);
            
        Node temp = head.next;
        int count = 1;

        while (temp != null) {
            if (count == k-1) {
                Node newNode = new Node(val, temp, temp.next);

                if (temp.next != null) temp.next.back = newNode;

                temp.next = newNode;

                break;
            }

            temp = temp.next;
            count++;
        }

        return head;
    }

    static Node insertBeforeEle (Node head, int ele, int val) {
        if (head == null) return null;
            
        Node temp = head;

        while (temp != null) {
            if (temp.data == ele) {
                if (temp == head) {
                    Node newNode = new Node(val, null, head);
                    head.back = newNode;
                    return newNode;
                }

                Node newNode = new Node(val, temp.back, temp);

                temp.back.next = newNode;
                temp.back = newNode;

                break;
            }

            temp = temp.next;
        }

        return head;
    }

    void main () {
        int arr[] = {10,20,30,40,50,60,70};
        Node head = convertArr2DLL(arr);;
        printDLL(head);
    }
}
