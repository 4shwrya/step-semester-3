public class highestMarks {

    public static int kthHighest(int[] marks, int k) {
        int target = marks.length - k;
        int low = 0;
        int high = marks.length - 1;

        while (low <= high) {
            int pivotIndex = partition(marks, low, high);

            if (pivotIndex == target) {
                return marks[pivotIndex];
            } else if (pivotIndex < target) {
                low = pivotIndex + 1;
            } else {
                high = pivotIndex - 1;
            }
        }

        return -1; // Invalid k
    }

    private static int partition(int[] marks, int low, int high) {
        int pivot = marks[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (marks[j] <= pivot) {
                i++;

                int temp = marks[i];
                marks[i] = marks[j];
                marks[j] = temp;
            }
        }

        int temp = marks[i + 1];
        marks[i + 1] = marks[high];
        marks[high] = temp;

        return i + 1;
    }

    public static void main(String[] args) {
        int[] marks = {72, 95, 60, 88, 79};
        System.out.println(kthHighest(marks, 2));

        int[] marks2 = {50, 90, 90, 70};
        System.out.println(kthHighest(marks2, 2));
    }
}