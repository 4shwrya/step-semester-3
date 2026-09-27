public class P4_CirculationReport {

    static class LibraryMember {
        private int booksBorrowed;

        public LibraryMember() {
            booksBorrowed = 0;
        }

        public void borrowBook() {
            booksBorrowed++;
        }

        public int getBooksBorrowed() {
            return booksBorrowed;
        }

        public String displayInfo() {
            return "General | Books: " + booksBorrowed;
        }
    }

    static class StudentMember extends LibraryMember {
        private String course;

        public StudentMember(String course) {
            super();
            this.course = course;
        }

        public String getCourse() {
            return course;
        }

        @Override
        public String displayInfo() {
            return "Student | Course: " + course
                    + " | Books: " + getBooksBorrowed();
        }
    }

    public static String batchPrint(LibraryMember[] members) {
        StringBuilder report = new StringBuilder();

        for (LibraryMember member : members) {
            if (member == null) {
                continue;
            }

            // Polymorphic method call
            report.append(member.displayInfo());

            // Downcasting to access the student's course
            if (member instanceof StudentMember) {
                StudentMember student = (StudentMember) member;

                report.append(" [Course via downcast: ")
                      .append(student.getCourse())
                      .append("]");
            }

            report.append(" | ");
        }

        return report.toString();
    }

    public static void main(String[] args) {
        LibraryMember general = new LibraryMember();
        StudentMember student = new StudentMember("ECE");

        general.borrowBook();
        student.borrowBook();
        student.borrowBook();

        LibraryMember[] members = {general, student};

        System.out.println(batchPrint(members));
    }
}