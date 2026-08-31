public class InventoryBalancer {

    static void analyzeInventory(int[] a, int[] b) {

        int totalA = 0;
        int totalB = 0;

        for (int i = 0; i < a.length; i++) {
            totalA = totalA + a[i];
            totalB = totalB + b[i];
        }

        String status;

        if (totalA == totalB)
            status = "Balanced";
        else
            status = "Not Balanced";

        int max = a[0];
        String section = "Section A";
        int index = 0;

        for (int i = 0; i < a.length; i++) {

            if (a[i] > max) {
                max = a[i];
                section = "Section A";
                index = i;
            }

            if (b[i] > max) {
                max = b[i];
                section = "Section B";
                index = i;
            }
        }

        System.out.println("Section A Total: " + totalA);
        System.out.println("Section B Total: " + totalB);
        System.out.println("Status: " + status);
        System.out.println("Highest Quantity: " + max);
        System.out.println(section + ", Item " + (index + 1));
    }

    public static void main(String[] args) {

        int[] sectionA = {20, 15, 30};
        int[] sectionB = {25, 10, 30};

        analyzeInventory(sectionA, sectionB);
    }
}

