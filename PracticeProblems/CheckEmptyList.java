public class CheckEmptyList {
    static class Node {
        int data;
        Node next;
        Node(int data) { this.data = data; }
    }

    static boolean checkIfEmpty(Node head) {
        return head == null;
    }
}