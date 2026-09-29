import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class AssignmentPortalMain {

    enum Status {
        SUBMITTED, GRADED
    }

    abstract static class Assignment {
        private String title;
        private int maxMarks;
        private LocalDate dueDate;

        Assignment(String title, int maxMarks, LocalDate dueDate) {
            this.title = title;
            this.maxMarks = maxMarks;
            this.dueDate = dueDate;
        }

        String getTitle() { return title; }
        int getMaxMarks() { return maxMarks; }
        LocalDate getDueDate() { return dueDate; }

        abstract double getDailyPenalty();
    }

    static class CodingAssignment extends Assignment {
        CodingAssignment(String title, int maxMarks, LocalDate dueDate) {
            super(title, maxMarks, dueDate);
        }

        @Override
        double getDailyPenalty() {
            return 0.10;
        }
    }

    static class WrittenAssignment extends Assignment {
        WrittenAssignment(String title, int maxMarks, LocalDate dueDate) {
            super(title, maxMarks, dueDate);
        }

        @Override
        double getDailyPenalty() {
            return 0.20;
        }
    }

    static class Student {
        private String name;

        Student(String name) {
            this.name = name;
        }

        String getName() {
            return name;
        }
    }

    static class Submission {
        private Student student;
        private Assignment assignment;
        private LocalDate submittedDate;
        private Status status = Status.SUBMITTED;
        private double finalMarks;

        Submission(Student student, Assignment assignment,
                   LocalDate submittedDate) {
            this.student = student;
            this.assignment = assignment;
            this.submittedDate = submittedDate;
        }

        void grade(double awardedMarks) {
            if (status == Status.GRADED) {
                System.out.println("Submission has already been graded.");
                return;
            }

            if (awardedMarks < 0 ||
                    awardedMarks > assignment.getMaxMarks()) {
                System.out.println("Invalid marks.");
                return;
            }

            long lateDays = Math.max(0,
                    ChronoUnit.DAYS.between(
                            assignment.getDueDate(), submittedDate));

            double penalty = Math.min(1.0,
                    lateDays * assignment.getDailyPenalty());

            finalMarks = awardedMarks * (1 - penalty);
            status = Status.GRADED;

            System.out.printf("%s graded: %.0f/%d",
                    student.getName(), finalMarks,
                    assignment.getMaxMarks());

            if (lateDays > 0) {
                System.out.printf(" after %.0f%% late penalty",
                        penalty * 100);
            }

            System.out.println(". Status: " + status);
        }

        void resubmit(LocalDate newDate) {
            if (status == Status.GRADED) {
                System.out.println("Cannot resubmit: '"
                        + assignment.getTitle()
                        + "' has already been graded.");
                return;
            }

            submittedDate = newDate;
            System.out.println("Submission updated.");
        }
    }

    public static void main(String[] args) {
        Student asha = new Student("Asha");
        Student ravi = new Student("Ravi");

        Assignment coding = new CodingAssignment(
                "Linked List Lab", 50,
                LocalDate.of(2026, 3, 10));

        Assignment written = new WrittenAssignment(
                "Design Essay", 50,
                LocalDate.of(2026, 3, 12));

        Submission s1 = new Submission(
                asha, coding, LocalDate.of(2026, 3, 10));

        Submission s2 = new Submission(
                ravi, written, LocalDate.of(2026, 3, 14));

        System.out.println("Asha's submission for 'Linked List Lab'"
                + " received (on time). Status: SUBMITTED");

        System.out.println("Ravi's submission for 'Design Essay'"
                + " received (2 days late). Status: SUBMITTED");

        s1.grade(45);
        s2.grade(40);

        s1.resubmit(LocalDate.of(2026, 3, 11));
    }
}