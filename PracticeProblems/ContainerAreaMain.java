public class ContainerAreaMain {

    // Brute force: O(n^2). This two-pointer version: O(n) time, O(1) space
    public static int maxContainerArea(int[] heights) {
        int l = 0, r = heights.length - 1, best = 0;
        while (l < r) {
            int area = Math.min(heights[l], heights[r]) * (r - l);
            best = Math.max(best, area);
            if (heights[l] < heights[r]) l++;   // move the shorter wall
            else r--;
        }
        return best;
    }

    public static void main(String[] args) {
        System.out.println(maxContainerArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7})); // 49
    }
}