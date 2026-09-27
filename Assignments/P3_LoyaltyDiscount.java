import java.util.Arrays;

public class P3_LoyaltyDiscount {

    static class GymMember {
        private String memberId;
        private int monthlyFee;

        private int[] lateFeeHistory = new int[10];
        private int feeCount = 0;

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

        public void chargeLateFee(int amount) {
            if (feeCount < lateFeeHistory.length) {
                lateFeeHistory[feeCount] = amount;
                feeCount++;
            }
        }

        public int[] getLateFeeHistory() {
            return Arrays.copyOf(lateFeeHistory, feeCount);
        }

        public int getTotalLateFees() {
            int total = 0;

            for (int i = 0; i < feeCount; i++) {
                total += lateFeeHistory[i];
            }

            return total;
        }
    }

    static class PremiumMember extends GymMember {

        public PremiumMember(String memberId, int monthlyFee) {
            super(memberId, monthlyFee);
        }

        @Override
        public void chargeLateFee(int amount) {
            super.chargeLateFee(amount / 2);
        }
    }

    public static void main(String[] args) {

        PremiumMember p =
            new PremiumMember("MEM1", 2000);

        p.chargeLateFee(200);
        p.chargeLateFee(100);

        System.out.println(
            "Total Late Fees: " + p.getTotalLateFees()
        );

        int[] history = p.getLateFeeHistory();

        System.out.println(
            "Late Fee History: " + Arrays.toString(history)
        );

        // Modify the returned array
        history[0] = 999;

        System.out.println(
            "History After Modification: " +
            Arrays.toString(p.getLateFeeHistory())
        );

        System.out.println(
            "Total After Modification: " +
            p.getTotalLateFees()
        );
    }
}