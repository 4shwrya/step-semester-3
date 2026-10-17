class Node {
    String name;
    Node next;

    Node(String name) {
        this.name = name;
        this.next = null;
    }
}

class CircularLinkedList {
    Node tail;

    // Add player at the end
    void addLast(String name) {
        Node newNode = new Node(name);

        if (tail == null) {
            tail = newNode;
            tail.next = tail;
        } else {
            newNode.next = tail.next;
            tail.next = newNode;
            tail = newNode;
        }
    }

    // Print players for the given number of turns
    void printTurns(int turns) {
        if (tail == null) {
            return;
        }

        Node current = tail.next; // Head

        for (int i = 0; i < turns; i++) {
            System.out.print(current.name + " ");
            current = current.next;
        }

        System.out.println();
    }
}

public class RoundRobinGame {
    public static void main(String[] args) {
        CircularLinkedList players = new CircularLinkedList();

        players.addLast("Asha");
        players.addLast("Ravi");
        players.addLast("Neha");

        players.printTurns(7);
    }
}