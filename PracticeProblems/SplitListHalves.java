public class SplitListHalves {
    static class Node {
        int data;
        Node next;
        Node(int data) { this.data = data; }
    }

    // Time: O(n), Space: O(1)
    static Node splitListInHalf(Node head) {
        if (head == null) return null;

        Node slow = head;
        Node fast = head.next;      // starting fast one ahead gives first half the extra node

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node secondHalf = slow.next;
        slow.next = null;           // terminate first half
        return secondHalf;
    }
}