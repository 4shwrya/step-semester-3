import java.util.Arrays;

public class ClassTopperMain {

    // Time: O(m*n), Space: O(1) extra
    public static int[] findTopper(int[][] marks) {
        int bestIdx = 0, bestTotal = -1;
        for (int i = 0; i < marks.length; i++) {
            int total = 0;
            for (int x : marks[i]) total += x;
            if (total > bestTotal) {   // strict > keeps smallest index on ties
                bestTotal = total;
                bestIdx = i;
            }
        }
        return new int[]{bestIdx, bestTotal};
    }

    public static void main(String[] args) {
        int[][] marks = {{78, 85, 90}, {88, 92, 79}, {65, 70, 95}};
        System.out.println(Arrays.toString(findTopper(marks))); // [1, 259]
    }
}