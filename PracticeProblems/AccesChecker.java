class MovieTicket {
    private int seatNumber;
    int screenId;              // default
    protected double ticketPrice;
    public String movieTitle;
}

class AccesChecker {

    static String classifyAccess(String fieldModifier, String accessorContext) {

        if (accessorContext.equals("SAME_CLASS")) {
            return "ALLOWED";
        }

        if (accessorContext.equals("SAME_PACKAGE")) {
            if (fieldModifier.equals("private")) {
                return "DENIED";
            }
            return "ALLOWED";
        }

        if (accessorContext.equals("DIFFERENT_PACKAGE")) {
            if (fieldModifier.equals("public")) {
                return "ALLOWED";
            }
            return "DENIED";
        }

        return "DENIED";
    }

    static String summarizeBatch(String[][] attempts) {
        int allowed = 0;
        int denied = 0;

        for (String[] attempt : attempts) {
            String result = classifyAccess(attempt[0], attempt[1]);

            if (result.equals("ALLOWED")) {
                allowed++;
            } else {
                denied++;
            }
        }

        return "Allowed: " + allowed + " | Denied: " + denied;
    }
}