public class P1_LibraryMembership {

    static class LibraryMember {
        protected String memberId;
        protected int borrowLimit;
        private int booksBorrowed = 0;

        public LibraryMember(String memberId, int borrowLimit) {

            if (memberId == null ||
                memberId.trim().length() < 4) {
                throw new IllegalArgumentException(
                    "Invalid Member ID"
                );
            }

            if (borrowLimit <= 0) {
                throw new IllegalArgumentException(
                    "Borrow limit must be positive"
                );
            }

            this.memberId = memberId;
            this.borrowLimit = borrowLimit;
        }

        public void borrowBook() {
            booksBorrowed++;
        }

        public int getBooksBorrowed() {
            return booksBorrowed;
        }

        public void displayInfo() {
            System.out.println(
                "General Member | Books Borrowed: "
                + booksBorrowed
            );
        }
    }

    static class StudentMember extends LibraryMember {
        private String course;

        public StudentMember(
            String memberId,
            int borrowLimit,
            String course
        ) {
            super(memberId, borrowLimit);
            this.course = course;
        }
    }

    public static String enrollBatch(
        String[] memberIds,
        int borrowLimit
    ) {
        int enrolled = 0;
        int rejected = 0;

        for (String memberId : memberIds) {
            try {
                new LibraryMember(memberId, borrowLimit);
                enrolled++;
            } catch (IllegalArgumentException e) {
                rejected++;
            }
        }

        return "Enrolled: " + enrolled
            + " | Rejected: " + rejected;
    }

    public static void main(String[] args) {

        try {
            LibraryMember member =
                new LibraryMember("LB1", 3);
        } catch (IllegalArgumentException e) {
            System.out.println("Construction rejected");
        }

        StudentMember student =
            new StudentMember("STU10", 3, "CSE");

        student.borrowBook();
        student.borrowBook();

        System.out.println(student.getBooksBorrowed());

        String[] memberIds = {
            "STU1", "LB1", "STU2", " ", "STU3"
        };

        System.out.println(
            enrollBatch(memberIds, 3)
        );
    }
}
