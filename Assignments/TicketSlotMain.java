public class TicketSlotMain {

    // Binary search: O(log n) time, O(1) space. Linear scan: O(n)
    public static int findSlot(int[] prices, int newPrice) {
        int lo = 0, hi = prices.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (prices[mid] == newPrice) return mid;
            else if (prices[mid] < newPrice) lo = mid + 1;
            else hi = mid - 1;
        }
        return lo;   // insertion point
    }

    public static void main(String[] args) {
        int[] p = {120, 150, 200, 260};
        System.out.println(findSlot(p, 150)); // 1
        System.out.println(findSlot(p, 210)); // 3
        System.out.println(findSlot(p, 300)); // 4
    }
}