public class CircularInsertEnd {
    static class Node {
        int data;
        Node next;
        Node(int data) { this.data = data; }
    }

    static Node insertAtEndCircular(Node head, int value) {
        Node newNode = new Node(value);
        if (head == null) {
            newNode.next = newNode;
            return newNode;
        }

        Node last = head;
        while (last.next != head) last = last.next;

        last.next = newNode;
        newNode.next = head;
        return head;
    }
}