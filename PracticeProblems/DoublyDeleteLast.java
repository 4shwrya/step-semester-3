public class DoublyDeleteLast {
    static class DNode {
        int data;
        DNode prev, next;
        DNode(int data) { this.data = data; }
    }

    static DNode deleteLastNodeDoubly(DNode head) {
        if (head == null) return null;
        if (head.next == null) return null;   // single node

        DNode last = head;
        while (last.next != null) last = last.next;

        last.prev.next = null;
        last.prev = null;
        return head;
    }
}