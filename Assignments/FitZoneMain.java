public class FitZoneMain {

    interface MembershipPlan {
        int getMonths();
        double calculateFee();
        String getName();
    }

    static class MonthlyPlan implements MembershipPlan {
        public int getMonths() { return 1; }
        public double calculateFee() { return 1000; }
        public String getName() { return "Monthly"; }
    }

    static class QuarterlyPlan implements MembershipPlan {
        public int getMonths() { return 3; }
        public double calculateFee() { return 2700; }
        public String getName() { return "Quarterly"; }
    }

    static class AnnualPlan implements MembershipPlan {
        public int getMonths() { return 12; }
        public double calculateFee() { return 9000; }
        public String getName() { return "Annual"; }
    }

    enum Status {
        ACTIVE, FROZEN, EXPIRED
    }

    static class Member {
        private String name;
        private Membership membership;

        Member(String name) {
            this.name = name;
        }

        String getName() {
            return name;
        }

        void buyMembership(MembershipPlan plan) {
            membership = new Membership(this, plan);

            System.out.println(plan.getName()
                    + " membership created for " + name + ".");

            System.out.printf("Fee: ₹%.2f%n",
                    plan.calculateFee());

            System.out.println("Status: "
                    + membership.getStatus());
        }

        void checkIn() {
            if (membership == null) {
                System.out.println("No membership found.");
                return;
            }

            membership.checkIn();
        }

        void freeze() {
            if (membership != null) {
                membership.freeze();
            }
        }

        void unfreeze() {
            if (membership != null) {
                membership.unfreeze();
            }
        }

        void expire() {
            if (membership != null) {
                membership.expire();
            }
        }
    }

    static class Membership {
        private Member member;
        private MembershipPlan plan;
        private Status status = Status.ACTIVE;

        Membership(Member member, MembershipPlan plan) {
            this.member = member;
            this.plan = plan;
        }

        Status getStatus() {
            return status;
        }

        void checkIn() {
            if (status == Status.ACTIVE) {
                System.out.println(member.getName()
                        + " checked in successfully.");
            } else {
                System.out.println("Check-in denied: "
                        + member.getName()
                        + "'s membership is " + status + ".");
            }
        }

        void freeze() {
            if (status == Status.EXPIRED) {
                System.out.println("Cannot freeze an Expired membership.");
                return;
            }

            if (status == Status.FROZEN) {
                System.out.println("Membership is already Frozen.");
                return;
            }

            status = Status.FROZEN;

            System.out.println(member.getName()
                    + "'s membership frozen.");
            System.out.println("Status: " + status);
        }

        void unfreeze() {
            if (status == Status.EXPIRED) {
                System.out.println(
                        "Cannot unfreeze an Expired membership.");
                return;
            }

            if (status == Status.ACTIVE) {
                System.out.println("Membership is already Active.");
                return;
            }

            status = Status.ACTIVE;

            System.out.println(member.getName()
                    + "'s membership unfrozen.");
            System.out.println("Status: " + status);
        }

        void expire() {
            status = Status.EXPIRED;

            System.out.println(member.getName()
                    + "'s membership expired.");
            System.out.println("Status: " + status);
        }
    }

    public static void main(String[] args) {
        Member asha = new Member("Asha");
        Member ravi = new Member("Ravi");

        asha.buyMembership(new QuarterlyPlan());
        ravi.buyMembership(new MonthlyPlan());

        asha.checkIn();
        asha.freeze();
        asha.checkIn();

        ravi.expire();
        ravi.freeze();
    }
}