import java.util.*;

class Club {
    HashSet<String> members = new HashSet<>();

    void addMember(String name) {
        if (members.add(name)) {
            System.out.println("Added");
        } else {
            System.out.println("Duplicate rejected");
        }
    }

    void checkMember(String name) {
        if (members.contains(name)) {
            System.out.println(name + " is a member");
        } else {
            System.out.println(name + " is not a member");
        }
    }

    void displayCount() {
        System.out.println("Member count: " + members.size());
    }
}

public class StudentClubSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Club club = new Club();
        ArrayList<String> checks = new ArrayList<>();

        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            String[] input = sc.nextLine().split(" ", 2);

            String operation = input[0];
            String name = input[1];

            switch (operation) {
                case "ADD":
                    club.addMember(name);
                    break;

                case "CONTAINS":
                    checks.add(name);
                    break;
            }
        }

        club.displayCount();

        for (String name : checks) {
            club.checkMember(name);
        }

        sc.close();
    }
}