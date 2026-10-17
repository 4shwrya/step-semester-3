import java.util.Arrays;

public class WarehouseSummaryMain {

    // Time: O(m*n), Space: O(1) extra
    public static int[] warehouseSummary(int[][] grid) {
        int total = 0, best = -1, bestR = -1, bestC = -1;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                total += grid[r][c];
                if (grid[r][c] > best) {   // strict > keeps the first max
                    best = grid[r][c];
                    bestR = r;
                    bestC = c;
                }
            }
        }
        return new int[]{total, bestR, bestC}; // {total, row, col}
    }

    public static void main(String[] args) {
        int[][] grid = {{4, 9, 2}, {7, 1, 6}, {3, 12, 5}};
        System.out.println(Arrays.toString(warehouseSummary(grid))); // [49, 2, 1]
    }
}