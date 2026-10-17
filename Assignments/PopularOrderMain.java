import java.util.*;

public class PopularOrderMain {

    // Hash map: O(n) time, O(k) space. Rescanning per item would be O(n^2)
    public static Map.Entry<String, Integer> mostPopular(List<String> orders) {
        Map<String, Integer> count = new HashMap<>();
        for (String item : orders) {
            count.put(item, count.getOrDefault(item, 0) + 1);
        }
        int best = Collections.max(count.values());
        for (String item : orders) {   // original order breaks ties
            if (count.get(item) == best) {
                return new AbstractMap.SimpleEntry<>(item, best);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(mostPopular(Arrays.asList(
            "dosa", "idli", "vada", "dosa", "idli", "dosa", "tea"))); // dosa=3
        System.out.println(mostPopular(Arrays.asList(
            "tea", "coffee", "coffee", "tea")));                      // tea=2
    }
}