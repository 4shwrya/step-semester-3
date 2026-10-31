public class PrintCircularList {
    static class Node {
        int data;
        Node next;
        Node(int data) { this.data = data; }
    }

    static void printCircular(Node head) {
        if (head == null) {
            System.out.println();
            return;
        }
        StringBuilder sb = new StringBuilder();
        Node current = head;
        do {
            sb.append(current.data).append(" ");
            current = current.next;
        } while (current != head);
        System.out.println(sb.toString().trim());
    }
}