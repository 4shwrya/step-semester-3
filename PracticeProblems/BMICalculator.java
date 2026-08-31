import java.util.Random;

public class BMICalculator {

    static String getBmiStatus(double bmi) {

        if (bmi < 18.5)
            return "Underweight";
        else if (bmi < 25)
            return "Normal";
        else if (bmi < 30)
            return "Overweight";
        else
            return "Obese";
    }

    static void printWellnessReport(double[] height, double[] weight) {

        System.out.println("Person\tHeight\tWeight\tBMI\tStatus");

        for (int i = 0; i < height.length; i++) {

            double bmi = weight[i] / (height[i] * height[i]);

            String status = getBmiStatus(bmi);

            System.out.printf("%d\t%.2f\t%.2f\t%.2f\t%s%n",
                    i + 1, height[i], weight[i], bmi, status);
        }
    }

    public static void main(String[] args) {

        double[] height = new double[10];
        double[] weight = new double[10];

        Random r = new Random();

        for (int i = 0; i < 10; i++) {
            height[i] = 1.5 + r.nextDouble() * 0.5;
            weight[i] = 45 + r.nextDouble() * 55;
        }

        printWellnessReport(height, weight);
    }
}

