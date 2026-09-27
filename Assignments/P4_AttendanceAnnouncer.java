public class P4_AttendanceAnnouncer {

    static class GymMember {
        protected String memberId;
        protected int monthlyFee;

        public GymMember(String memberId, int monthlyFee) {
            if (memberId == null ||
                memberId.trim().length() < 4) {
                throw new IllegalArgumentException(
                    "Invalid Member ID"
                );
            }

            this.memberId = memberId;
            this.monthlyFee = monthlyFee;
        }

        public void displayInfo() {
            System.out.println(
                "Gym Member: " + memberId +
                " | Monthly Fee: " + monthlyFee
            );
        }
    }

    static class PremiumMember extends GymMember {
        private String trainerName;

        public PremiumMember(
            String memberId,
            int monthlyFee,
            String trainerName
        ) {
            super(memberId, monthlyFee);
            this.trainerName = trainerName;
        }

        @Override
        public void displayInfo() {
            System.out.println(
                "Premium Member: " + memberId +
                " | Monthly Fee: " + monthlyFee +
                " | Trainer: " + trainerName
            );
        }

        public String getTrainerName() {
            return trainerName;
        }
    }

    public static String batchPrint(GymMember[] members) {
        StringBuilder result = new StringBuilder();

        for (GymMember member : members) {
            if (member == null) {
                continue;
            }

            // Polymorphism: calls the correct displayInfo()
            // based on the actual object type.
            java.io.ByteArrayOutputStream output =
                new java.io.ByteArrayOutputStream();

            java.io.PrintStream originalOut = System.out;

            try {
                System.setOut(new java.io.PrintStream(output));
                member.displayInfo();
            } finally {
                System.setOut(originalOut);
            }

            result.append(output.toString().trim());

            // Safe downcasting after checking the object type.
            if (member instanceof PremiumMember) {
                PremiumMember premium =
                    (PremiumMember) member;

                result.append(
                    "\n[Trainer via downcast: " +
                    premium.getTrainerName() + "]"
                );
            }

            result.append("\n");
        }

        return result.toString().trim();
    }

    public static void main(String[] args) {
        GymMember member1 =
            new GymMember("MEM1", 1000);

        PremiumMember member2 =
            new PremiumMember("PREM1", 2000, "Coach Riya");

        GymMember member3 =
            new GymMember("MEM2", 1500);

        GymMember[] members = {
            member1, member2, member3
        };

        System.out.println(batchPrint(members));
    }
}