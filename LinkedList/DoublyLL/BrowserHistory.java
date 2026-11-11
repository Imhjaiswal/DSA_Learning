package LinkedList.DoublyLL;

public class BrowserHistory {
    Node curr;
    
    BrowserHistory(String homepage) {
        curr = new Node(homepage);
    }

    void visit(String url) {
        Node nextNode = new Node(url);
        curr.next = nextNode;
        nextNode.back = curr;
        curr = curr.next;
    }

    String back (int steps) {
        while (steps > 0) {
            if (curr.back != null) curr = curr.back;
            else break;
            steps--;
        }

        return curr.data;
    }

    String forward (int steps) {
        while (steps > 0) {
            if (curr.next != null) curr = curr.next;
            else break;
            steps--;
        }

        return curr.data;
    }
}

class Node {
    public String data;
    Node next;
    Node back;

    Node(String data) {
        this.data = data;
        this.next = null;
        this.back = null;
    }

    Node(String data, Node next, Node back) {
        this.data = data;
        this.next = next;
        this.back = back;
    }
}