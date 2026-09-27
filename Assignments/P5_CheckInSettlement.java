public class P5_CheckInSettlement {

    static class GymMember {
        private String memberId;
        private int monthlyFee;
        private final String membershipNumber;

        private static int counter = 2001;
        private int feesPaid = 0;

        public GymMember(String memberId, int monthlyFee) {
            if (memberId == null ||
                memberId.trim().length() < 4) {
                throw new IllegalArgumentException(
                    "Invalid Member ID"
                );
            }

            this.memberId = memberId;
            this.monthlyFee = monthlyFee;
            this.membershipNumber = "GYM-" + counter++;
        }

        public String getMembershipNumber() {
            return membershipNumber;
        }

        public void payFee(int amount) {
            feesPaid += amount;
        }

        public void payFee(int amount, String mode) {
            payFee(amount);
        }

        public int getFeesPaid() {
            return feesPaid;
        }

        public void displayInfo() {
            System.out.println(
                "Member ID: " + memberId +
                " | Membership Number: " + membershipNumber
            );
        }
    }

    static class GroupClassMember extends GymMember {
        private String className;

        public GroupClassMember(int monthlyFee, String className) {
            super("GRP1", monthlyFee);
            this.className = className;
        }

        public String getClassName() {
            return className;
        }

        @Override
        public void displayInfo() {
            System.out.println(
                "Group Class Member: " + getMembershipNumber() +
                " | Class: " + className
            );
        }
    }

    public static boolean isValidReferralCode(String code) {
        if (code == null || code.length() != 4) {
            return false;
        }

        return code.charAt(0) == 'G'
            && Character.isDigit(code.charAt(1))
            && Character.isDigit(code.charAt(2))
            && Character.isUpperCase(code.charAt(3));
    }

    public static void processWeeklyCheckIn(GymMember[] members) {
        int processed = 0;
        int nullSkipped = 0;
        int groupCount = 0;
        int individualCount = 0;

        for (GymMember member : members) {
            if (member == null) {
                nullSkipped++;
                continue;
            }

            processed++;

            if (member instanceof GroupClassMember) {
                groupCount++;
            } else {
                individualCount++;
            }
        }

        System.out.println(
            processed + " processed | " +
            nullSkipped + " null skipped | " +
            groupCount + " group | " +
            individualCount + " individual"
        );
    }

    public static void main(String[] args) {

        GymMember m1 = new GymMember("MEM1", 1000);
        GroupClassMember m2 =
            new GroupClassMember(1500, "Yoga");
        GymMember m3 = new GymMember("MEM2", 1200);

        m1.payFee(1000);
        m2.payFee(1500, "UPI");

        System.out.println(m1.getMembershipNumber());
        System.out.println(m2.getMembershipNumber());
        System.out.println(m3.getMembershipNumber());

        System.out.println("Referral G12A: " +
            isValidReferralCode("G12A"));

        System.out.println("Referral G1AA: " +
            isValidReferralCode("G1AA"));

        GymMember[] members = {m1, m2, null, m3};

        processWeeklyCheckIn(members);
    }
}