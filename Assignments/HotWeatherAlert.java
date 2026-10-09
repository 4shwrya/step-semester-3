public class HotWeatherAlert{

    // Sliding window: O(n) time, O(1) space. Recalculating each block: O(n*k)
    public static int countAlerts(int[] readings, int k, int threshold) {
        long need = (long) k * threshold;   // avoids decimal division
        long window = 0;
        for (int i = 0; i < k; i++) window += readings[i];

        int count = (window >= need) ? 1 : 0;
        for (int i = k; i < readings.length; i++) {
            window += readings[i] - readings[i - k];
            if (window >= need) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countAlerts(new int[]{2, 2, 2, 2, 5, 5, 5, 8}, 3, 4)); // 3
    }
}