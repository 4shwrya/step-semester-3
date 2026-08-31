public class TrafficStreakAnalyzer {

    static void findLongestStreak(String signal) {

        int current = 1;
        int longest = 1;
        char color = signal.charAt(0);

        for (int i = 1; i < signal.length(); i++) {

            if (signal.charAt(i) == signal.charAt(i - 1)) {
                current++;
            }
            else {
                current = 1;
            }

            if (current > longest) {
                longest = current;
                color = signal.charAt(i);
            }
        }

        System.out.println("Longest Streak: '" + color +
                "' repeated " + longest + " times");
    }

    public static void main(String[] args) {

        String signal = "RRGGGYRR";

        findLongestStreak(signal);
    }
}

