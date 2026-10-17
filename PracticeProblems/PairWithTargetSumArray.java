import java.util.*;

public class PairWithTargetSumArray {

    // Approach 1: brute force. Time O(n^2), Space O(1)
    public static boolean pairBrute(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++)
            for (int j = i + 1; j < nums.length; j++)
                if (nums[i] + nums[j] == target) return true;
        return false;
    }

    // Approach 2: hash set. Time O(n), Space O(n)
    public static boolean pairHash(int[] nums, int target) {
        Set<Integer> seen = new HashSet<>();
        for (int x : nums) {
            if (seen.contains(target - x)) return true;
            seen.add(x);
        }
        return false;
    }

    // Approach 3: sort + two pointers. Time O(n log n), Space O(n) with clone
    public static boolean pairSort(int[] nums, int target) {
        int[] a = nums.clone();
        Arrays.sort(a);
        int l = 0, r = a.length - 1;
        while (l < r) {
            long s = (long) a[l] + a[r];
            if (s == target) return true;
            if (s < target) l++;
            else r--;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] a = {2, 7, 11, 15};
        int[] b = {3, 4, 6};
        System.out.println(pairBrute(a, 9)); // true
        System.out.println(pairHash(a, 9));  // true
        System.out.println(pairSort(a, 9));  // true
        System.out.println(pairHash(b, 20)); // false
    }
}