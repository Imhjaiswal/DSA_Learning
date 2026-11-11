package LinkedList.SinglyLL;

import LinkedList.SinglyLL.SinglyLinkedList.CNode;

public class SinglyLinkedList {
    // IMPLEMENTATION OF SINGLY LINKED LIST
    public static class Node {
        public int data;
        public Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }

        Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    public static class CNode {
        public int data;
        public CNode next;
        public CNode child;

        CNode(int data) {
            this.data = data;
            this.next = null;
            this.child = null;
        }

        CNode(int data, CNode next, CNode child) {
            this.data = data;
            this.next = next;
            this.child = child;
        }
    }

    public static class RNode {
        public int data;
        public RNode next;
        public RNode random;

        RNode(int data) {
            this.data = data;
            this.next = null;
            this.random = null;
        }

        RNode(int data, RNode next, RNode random) {
            this.data = data;
            this.next = next;
            this.random = random;
        }
    }

    static Node convertArr2LL(int nums[]) {
        if (nums.length == 0 || nums == null)
            return null;

        Node head = new Node(nums[0]);
        Node mover = head;

        for (int i = 1; i < nums.length; i++) {
            Node temp = new Node(nums[i]);
            mover.next = temp;
            mover = temp;
        }

        return head;
    }

    static void printLL(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    static int lengthOfLL(Node head) {
        int count = 0;
        Node temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    static int searchInLL(Node head, int num) {
        int pos = 0;
        Node temp = head;

        while (temp != null) {
            if (num == temp.data) {
                return pos;
            }
            temp = temp.next;
            pos++;
        }
        return -1;
    }

    // DELETE OPERATIONS
    static Node deleteHead(Node head) {
        if (head == null)
            return head;
        head = head.next;
        return head;
    }

    static Node deleteTail(Node head) {
        if (head == null || head.next == null)
            return null;

        Node temp = head;

        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;

        return head;
    }

    static Node deleteKthElement(Node head, int k) {
        if (head == null || k <= 0) return head;

        if (k == 1) return head.next;

        int count = 0;
        Node temp = head;
        Node prev = null;

        while (temp != null) {
            count++;
            if (count == k) {
                prev.next = temp.next;
                break;
            }
            prev = temp;
            temp = temp.next;
        }
        return head;
    }

    static Node deleteByIndex (Node head, int pos) {
        if (head == null || pos < 0) return head;

        if (pos == 0) return head.next;

        int count = 1;
        Node temp = head.next;
        Node prev = head;

        while (temp != null) {
            if (count == pos) {
                prev.next = temp.next;
                break;
            }
            prev = temp;
            temp = temp.next;
            count++;
        }
        return head;
    }

    static Node deleteByValue (Node head, int val) {
        if (head == null) return head;

        if (head.data == val) {
            return head.next;
        }

        Node temp = head;
        while (temp.next != null) {
            if (temp.next.data == val) {
                temp.next = temp.next.next;
                break;
            }
            temp = temp.next;
        }
        return head;
    }

    // INSERT OPERATIONS
    static Node insertAtHead (Node head, int val) {
        if (head == null) return new Node(val);

        // Node temp = new Node(val);
        // temp.next = head;
        Node temp = new Node(val, head);

        return temp;
    }

    static Node insertAtTail (Node head, int val) {
        if (head == null) return new Node(val);

        Node temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = new Node(val);

        return head;
    }

    static Node insertAtBeforePositionK (Node head, int k, int val) {
        if (head == null) {
            if (k == 1) return new Node(val);
            return null;
        }

        if (k == 1) return new Node (val, head);

        Node temp = head;
        int count = 0;

        while (temp != null) {
            count++;

            if (count == k-1) {
                Node newNode = new Node(val, temp.next);
                temp.next = newNode;
                break;
            }
            temp = temp.next;
        }
        return head;
    }

    static Node insertBeforeValK (Node head, int el, int val) {
        if (head == null) return null;

        if (head.data == el) return new Node (val, head);

        Node temp = head;

        while (temp.next != null) {
            if (temp.next.data == el) {
                Node newNode = new Node(val, temp.next);
                temp.next = newNode;
                break;
            }
            temp = temp.next;
        }
        return head;
    }

    public static void main() {
        // Node M1 = new Node(0);
        // System.out.println(M1);

        int nums[] = { 20, 10, 50, 40 };
        Node head = convertArr2LL(nums);

        // printLL(head);
        // System.out.println(lengthOfLL(head));

        // System.out.println(searchInLL(head, 50));
        printLL(head);
        // head = deleteHead(head);
        // head = deleteTail(head);
        // head = deleteKthElement(head, 4);
        // head = deleteByValue(head, 40);

        // head = insertAtHead(head, 0);
        // printLL(head);
        // head = insertAtTail(head, 0);
        // printLL(head);
        head = insertAtBeforePositionK(head, 3 , 30);
        printLL(head);
    }
}