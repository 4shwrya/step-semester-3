public class P5_NightlyAudit {

    static class LibraryMember {
        private static int memberCounter = 100;
        private static int membersEnrolled = 0;

        private final String memberNumber;
        private int borrowLimit;
        private int booksBorrowed;

        public LibraryMember(int borrowLimit) {
            if (borrowLimit <= 0) {
                throw new IllegalArgumentException(
                        "Borrow limit must be positive"
                );
            }

            memberCounter++;
            membersEnrolled++;

            this.memberNumber = "LIB-" + memberCounter;
            this.borrowLimit = borrowLimit;
            this.booksBorrowed = 0;
        }

        public String getMemberNumber() {
            return memberNumber;
        }

        public int getBooksBorrowed() {
            return booksBorrowed;
        }

        public void borrowBook() {
            if (booksBorrowed < borrowLimit) {
                booksBorrowed++;
            } else {
                System.out.println("Borrow limit reached");
            }
        }

        public void borrowBook(String genre) {
            System.out.println("Genre: " + genre);
            borrowBook();
        }

        public static boolean isValidRenewalCode(String code) {
            if (code == null || code.length() != 4) {
                return false;
            }

            return code.charAt(0) == 'R'
                    && Character.isDigit(code.charAt(1))
                    && Character.isDigit(code.charAt(2))
                    && Character.isUpperCase(code.charAt(3));
        }

        public static int getMembersEnrolled() {
            return membersEnrolled;
        }
    }

    static class FacultyMember extends LibraryMember {
        private String department;

        public FacultyMember(int borrowLimit, String department) {
            super(borrowLimit);
            this.department = department;
        }

        public String getDepartment() {
            return department;
        }
    }

    public static String processNightlyAudit(LibraryMember[] members) {
        int processed = 0;
        int nullSkipped = 0;
        int facultyCount = 0;
        int regularCount = 0;

        for (LibraryMember member : members) {
            if (member == null) {
                nullSkipped++;
                continue;
            }

            processed++;

            if (member instanceof FacultyMember) {
                facultyCount++;
            } else {
                regularCount++;
            }
        }

        return processed + " processed | "
                + nullSkipped + " null skipped | "
                + facultyCount + " faculty | "
                + regularCount + " regular";
    }

    public static void main(String[] args) {

        LibraryMember m1 = new LibraryMember(3);

        System.out.println(m1.getMemberNumber());
        System.out.println(LibraryMember.getMembersEnrolled());

        System.out.println(
                LibraryMember.isValidRenewalCode("R12A")
        );

        System.out.println(
                LibraryMember.isValidRenewalCode("R1A")
        );

        System.out.println(
                LibraryMember.isValidRenewalCode("X12A")
        );

        m1.borrowBook();
        m1.borrowBook("Fiction");

        System.out.println(m1.getBooksBorrowed());

        FacultyMember f1 = new FacultyMember(5, "CSE");

        LibraryMember[] members = {
                m1,
                f1,
                null
        };

        System.out.println(processNightlyAudit(members));
    }
}