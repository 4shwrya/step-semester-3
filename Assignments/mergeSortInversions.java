public class mergeSortInversions {

    public static long countInversions(int[] roll) {
        int[] temp = new int[roll.length];
        return mergeSort(roll, temp, 0, roll.length - 1);
    }

    private static long mergeSort(int[] roll, int[] temp, int left, int right) {
        if (left >= right) {
            return 0;
        }

        int mid = left + (right - left) / 2;

        long count = 0;

        count += mergeSort(roll, temp, left, mid);
        count += mergeSort(roll, temp, mid + 1, right);
        count += merge(roll, temp, left, mid, right);

        return count;
    }

    private static long merge(int[] roll, int[] temp,
                              int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int k = left;

        long count = 0;

        while (i <= mid && j <= right) {
            if (roll[i] <= roll[j]) {
                temp[k++] = roll[i++];
            } else {
                temp[k++] = roll[j++];

                // Remaining left elements form inversions
                count += mid - i + 1;
            }
        }

        while (i <= mid) {
            temp[k++] = roll[i++];
        }

        while (j <= right) {
            temp[k++] = roll[j++];
        }

        for (int p = left; p <= right; p++) {
            roll[p] = temp[p];
        }

        return count;
    }

    public static void main(String[] args) {
        int[] roll = {2, 4, 1, 3, 5};

        System.out.println(countInversions(roll));
    }
}