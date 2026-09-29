import java.util.*;

public class CampusNoticeMain {

    interface NotificationChannel {
        void send(String studentName, String title);
    }

    static class EmailChannel implements NotificationChannel {
        public void send(String name, String title) {
            System.out.println("[Email → " + name + "] " + title);
        }
    }

    static class SmsChannel implements NotificationChannel {
        public void send(String name, String title) {
            System.out.println("[SMS → " + name + "] " + title);
        }
    }

    static class AppChannel implements NotificationChannel {
        public void send(String name, String title) {
            System.out.println("[App → " + name + "] " + title);
        }
    }

    static class Student {
        private String name;
        private String department;
        private List<NotificationChannel> channels;

        Student(String name, String department) {
            this.name = name;
            this.department = department;
            channels = new ArrayList<>();
        }

        void addChannel(NotificationChannel channel) {
            channels.add(channel);
        }

        String getName() {
            return name;
        }

        String getDepartment() {
            return department;
        }

        List<NotificationChannel> getChannels() {
            return channels;
        }
    }

    static class Notice {
        private String title;
        private Set<String> departments;

        Notice(String title, Set<String> departments) {
            if (title == null || title.trim().isEmpty()) {
                throw new IllegalArgumentException(
                        "Notice title is required.");
            }

            if (departments == null || departments.isEmpty()) {
                throw new IllegalArgumentException(
                        "At least one target department is required.");
            }

            this.title = title;
            this.departments = new HashSet<>(departments);
        }

        String getTitle() {
            return title;
        }

        Set<String> getDepartments() {
            return departments;
        }
    }

    static class NoticeBoard {
        private List<Student> students = new ArrayList<>();

        void addStudent(Student student) {
            students.add(student);
        }

        void postNotice(Notice notice) {
            System.out.println("Notice '" + notice.getTitle()
                    + "' posted to "
                    + String.join(", ", notice.getDepartments())
                    + ".");

            for (Student student : students) {
                if (notice.getDepartments().contains(
                        student.getDepartment())) {

                    for (NotificationChannel channel
                            : student.getChannels()) {
                        channel.send(
                                student.getName(),
                                notice.getTitle());
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        NoticeBoard board = new NoticeBoard();

        Student asha = new Student("Asha", "CSE");
        asha.addChannel(new EmailChannel());
        asha.addChannel(new AppChannel());

        Student ravi = new Student("Ravi", "ECE");
        ravi.addChannel(new SmsChannel());

        board.addStudent(asha);
        board.addStudent(ravi);

        Notice notice1 = new Notice(
                "Lab Closed Tomorrow",
                new HashSet<>(Arrays.asList("CSE")));

        board.postNotice(notice1);

        Notice notice2 = new Notice(
                "Fee Deadline Extended",
                new HashSet<>(Arrays.asList("CSE", "ECE")));

        board.postNotice(notice2);

        try {
            Notice notice3 = new Notice(
                    "Sports Day", new HashSet<>());
            board.postNotice(notice3);
        } catch (IllegalArgumentException e) {
            System.out.println("Cannot post notice: "
                    + e.getMessage());
        }
    }
}