import java.util.*;

public class PairWithTargetSumMain {

    // Approach 1: brute force. Time O(n^2), Space O(1)
    public static boolean hasPairBrute(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++)
            for (int j = i + 1; j < nums.length; j++)
                if (nums[i] + nums[j] == target) return true;
        return false;
    }

    // Approach 2: hash set. Time O(n), Space O(n)
    public static boolean hasPairWithSum(int[] nums, int target) {
        Set<Integer> seen = new HashSet<>();
        for (int x : nums) {
            if (seen.contains(target - x)) return true; // check BEFORE adding
            seen.add(x);
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(hasPairWithSum(new int[]{2, 7, 11, 15}, 9)); // true
        System.out.println(hasPairWithSum(new int[]{3, 4, 6}, 20));     // false
        System.out.println(hasPairBrute(new int[]{2, 7, 11, 15}, 9));   // true
    }
}