class FeesAccount {
}

class HostelFeesAccount extends FeesAccount {
}

public class AccountBatchPayment {

    static void processPayment(
            FeesAccount account,
            double amount) {

        if (account instanceof HostelFeesAccount)
            System.out.println(
                    "Paid in two installments (hostel account)");
        else
            System.out.println(
                    "Paid in one go (day-scholar account)");
    }

    public static void main(String[] args) {

        FeesAccount[] accounts = {
                new HostelFeesAccount(),
                new HostelFeesAccount(),
                new FeesAccount(),
                new FeesAccount()
        };

        int hostel = 0;
        int dayScholar = 0;

        for (FeesAccount a : accounts) {

            processPayment(a, 60000);

            if (a instanceof HostelFeesAccount)
                hostel++;
            else
                dayScholar++;
        }

        System.out.println(
                "Hostel accounts processed: "
                        + hostel);

        System.out.println(
                "Day-scholar accounts processed: "
                        + dayScholar);
    }
}
