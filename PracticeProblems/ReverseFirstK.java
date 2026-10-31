public class ReverseFirstK {
    static class Node {
        int data;
        Node next;
        Node(int data) { this.data = data; }
    }

    static Node reverseFirstKNodes(Node head, int k) {
        Node prev = null, current = head, next = null;
        int count = 0;

        while (current != null && count < k) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }

        // head is now the k-th node, connect it to the (k+1)-th
        head.next = current;
        return prev;
    }
}