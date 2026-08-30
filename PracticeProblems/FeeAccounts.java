class FeeAccount {

    String regNo;
    double totalFee;

    FeeAccount(String regNo, double totalFee) {
        this.regNo = regNo;
        this.totalFee = totalFee;
    }

    final double calculateLateFee(int daysLate) {
        return totalFee * 0.01 * daysLate;
    }

    final void printSummary(int daysLate) {

        if (daysLate <= 0) {
            System.out.println(regNo +
                    " - On time, no late fee");
        }
        else {
            System.out.println(regNo +
                    " | Total Fee: Rs " + totalFee +
                    " | Late Fee: Rs " +
                    calculateLateFee(daysLate));
        }
    }
}

public class FeeAccounts {

    public static void main(String[] args) {

        FeeAccount[] acc = {
                new FeeAccount("RA001", 200000),
                new FeeAccount("RA002", 150000),
                new FeeAccount("RA003", 180000),
                new FeeAccount("RA004", 220000)
        };

        int[] days = {10, 0, -2, 5};

        for (int i = 0; i < acc.length; i++) {
            acc[i].printSummary(days[i]);
        }
    }
}
