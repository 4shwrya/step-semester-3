import java.util.*;

public class MarksGridAnalysis {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int rows = sc.nextInt();
        int cols = sc.nextInt();

        int[][] marks = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                marks[i][j] = sc.nextInt();
            }
        }

        // Calculate row sums
        for (int i = 0; i < rows; i++) {
            int sum = 0;

            for (int j = 0; j < cols; j++) {
                sum += marks[i][j];
            }

            System.out.println("Row " + (i + 1) + " sum: " + sum);
        }

        // Calculate column sums
        for (int j = 0; j < cols; j++) {
            int sum = 0;

            for (int i = 0; i < rows; i++) {
                sum += marks[i][j];
            }

            System.out.println("Column " + (j + 1) + " sum: " + sum);
        }

        // Find the maximum mark
        int max = marks[0][0];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (marks[i][j] > max) {
                    max = marks[i][j];
                }
            }
        }

        System.out.println("Maximum mark: " + max);

        sc.close();
    }
}