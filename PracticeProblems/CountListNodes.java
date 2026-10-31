public class CountListNodes {
    static class Node {
        int data;
        Node next;
        Node(int data) { this.data = data; }
    }

    static int countNodes(Node head) {
        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }
}