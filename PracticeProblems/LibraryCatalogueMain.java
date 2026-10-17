public class LibraryCatalogueMain {

    // Binary search: O(log n) time, O(1) space
    public static String findBook(String[][] catalog, String targetIsbn) {
        int lo = 0, hi = catalog.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int cmp = catalog[mid][0].compareTo(targetIsbn);
            if (cmp == 0) return catalog[mid][1];
            else if (cmp < 0) lo = mid + 1;
            else hi = mid - 1;
        }
        return "Not Found";
    }

    public static void main(String[] args) {
        String[][] cat = {
            {"0001112223", "Introduction to Algebra"},
            {"0002223334", "Beginning Python"},
            {"0003334445", "Classic Mythology"},
            {"0004445556", "Data and Society"},
            {"0005556667", "European History"}
        };
        System.out.println(findBook(cat, "0003334445")); // Classic Mythology
        System.out.println(findBook(cat, "0009998887")); // Not Found
    }
}