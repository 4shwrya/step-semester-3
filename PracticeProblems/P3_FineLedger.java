import java.util.Arrays;

public class P3_FineLedger {

    static class LibraryMember {
        protected String memberId;
        protected int borrowLimit;

        private int[] fineHistory = new int[10];
        private int fineCount = 0;

        public LibraryMember(String memberId, int borrowLimit) {
            if (memberId == null ||
                memberId.trim().length() < 4) {
                throw new IllegalArgumentException("Invalid Member ID");
            }

            if (borrowLimit <= 0) {
                throw new IllegalArgumentException(
                    "Borrow limit must be positive"
                );
            }

            this.memberId = memberId;
            this.borrowLimit = borrowLimit;
        }

        protected void chargeFine(int amount) {
            if (fineCount < fineHistory.length) {
                fineHistory[fineCount] = amount;
                fineCount++;
            }
        }

        public int[] getFineHistory() {
            return Arrays.copyOf(fineHistory, fineCount);
        }

        public int getTotalFine() {
            int total = 0;

            for (int i = 0; i < fineCount; i++) {
                total += fineHistory[i];
            }

            return total;
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

        @Override
        protected void chargeFine(int amount) {
            super.chargeFine(amount / 2);
        }
    }

    public static void main(String[] args) {

        StudentMember student =
            new StudentMember("STU5", 3, "CSE");

        student.chargeFine(100);

        System.out.println(
            "Total Fine: " + student.getTotalFine()
        );

        int[] history = student.getFineHistory();

        System.out.println(
            "Fine History: " + Arrays.toString(history)
        );

        // Attempt to modify the returned array
        history[0] = 999;

        System.out.println(
            "History After Modification: " +
            Arrays.toString(student.getFineHistory())
        );

        System.out.println(
            "Total Fine After Modification: " +
            student.getTotalFine()
        );
    }
}

