public class DeleteNthNode {
    static class Node {
        int data;
        Node next;
        Node(int data) { this.data = data; }
    }

    static Node deleteNthNode(Node head, int n) {
        if (n == 1) return head.next;

        Node current = head;
        for (int i = 1; i < n - 1; i++) {   // stops at (n-1)th node
            current = current.next;
        }
        current.next = current.next.next;
        return head;
    }
}