
public class HostelLaundryMain {

    interface WashType {
        int getDuration();
        double getCharge();
        String getName();
    }

    static class QuickWash implements WashType {
        public int getDuration() { return 30; }
        public double getCharge() { return 20; }
        public String getName() { return "Quick"; }
    }

    static class NormalWash implements WashType {
        public int getDuration() { return 45; }
        public double getCharge() { return 30; }
        public String getName() { return "Normal"; }
    }

    static class HeavyWash implements WashType {
        public int getDuration() { return 60; }
        public double getCharge() { return 45; }
        public String getName() { return "Heavy"; }
    }

    static class Student {
        private String name;

        Student(String name) {
            this.name = name;
        }

        String getName() {
            return name;
        }
    }

    static class WashCycle {
        Student student;
        WashingMachine machine;
        WashType washType;

        WashCycle(Student student, WashingMachine machine,
                  WashType washType) {
            this.student = student;
            this.machine = machine;
            this.washType = washType;
        }
    }

    static class WashingMachine {
        private String machineId;
        private WashCycle currentCycle;

        WashingMachine(String machineId) {
            this.machineId = machineId;
        }

        boolean isFree() {
            return currentCycle == null;
        }

        void startWash(Student student, WashType type) {
            if (!isFree()) {
                System.out.println("Machine " + machineId
                        + " is currently busy.");
                return;
            }

            currentCycle = new WashCycle(student, this, type);

            System.out.println(type.getName() + " wash started on "
                    + machineId + " for " + student.getName()
                    + " (" + type.getDuration() + " min).");

            System.out.printf("Charge: ₹%.2f%n", type.getCharge());
        }

        void completeWash() {
            if (isFree()) {
                System.out.println(machineId + " is already free.");
                return;
            }

            System.out.println(machineId + " cycle completed.");
            currentCycle = null;
            System.out.println(machineId + " is now free.");
        }
    }

    public static void main(String[] args) {
        Student asha = new Student("Asha");
        Student ravi = new Student("Ravi");
        Student neha = new Student("Neha");

        WashingMachine m1 = new WashingMachine("M1");
        WashingMachine m2 = new WashingMachine("M2");

        m1.startWash(asha, new QuickWash());
        m1.startWash(ravi, new HeavyWash());
        m2.startWash(ravi, new HeavyWash());

        m1.completeWash();
        m1.startWash(neha, new NormalWash());
    }
}