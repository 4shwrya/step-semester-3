class Entry {
    String name;
    int marks;

    Entry(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    public String toString() {
        return name + " " + marks;
    }
}

public class Leaderboard {

    public static Entry[] leaderboard(Entry[] entries) {
        int n = entries.length;
        int[] count = new int[101];

        // Count entries using key = 100 - marks
        for (Entry entry : entries) {
            int key = 100 - entry.marks;
            count[key]++;
        }

        // Build cumulative counts
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        Entry[] output = new Entry[n];

        // Traverse backwards to preserve submission order for ties
        for (int i = n - 1; i >= 0; i--) {
            int key = 100 - entries[i].marks;
            output[count[key] - 1] = entries[i];
            count[key]--;
        }

        return output;
    }

    public static void main(String[] args) {
        Entry[] entries = {
            new Entry("Asha", 90),
            new Entry("Ravi", 75),
            new Entry("Neha", 90),
            new Entry("Kiran", 100),
            new Entry("Meera", 75)
        };

        Entry[] result = leaderboard(entries);

        for (Entry entry : result) {
            System.out.println(entry);
        }
    }
}