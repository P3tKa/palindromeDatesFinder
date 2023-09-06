public class BonusDates {
    private static final int LEAP_YEAR_FEBRUARY = 29;
    private static final int NON_LEAP_YEAR_FEBRUARY = 28;
    private static final int MONTHS_IN_YEAR = 12;

    /**
     * Finds and Prints palindrome dates between two given years inclusively.
     *
     * @param fromYear The starting year.
     * @param toYear   The ending year.
     */
    public static void printBonusDatesBetween(int fromYear, int toYear) {
        if (fromYear < 1000 || fromYear > 9999 || toYear < 1000 || toYear > 9999) {
            throw new IllegalArgumentException("Years must be 4 digit values.");
        }
        if (toYear < fromYear) {
            throw new IllegalArgumentException("Ending year must be higher or equal to starting year.");
        }

        // This array is designed for month-based indexing,
        // starting at index 1 (January) and ending at index 12 (December).
        int[] daysInMonth = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

        for (int year = fromYear; year <= toYear; year++) {
            // Check for leap year
            daysInMonth[2] = (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0))
                    ? LEAP_YEAR_FEBRUARY
                    : NON_LEAP_YEAR_FEBRUARY;

            for (int month = 1; month <= MONTHS_IN_YEAR; month++) {
                for (int day = 1; day <= daysInMonth[month]; day++) {
                    if (isPalindromeDate(year, month, day)) {
                        System.out.printf("%04d-%02d-%02d%n", year, month, day);
                    }
                }
            }
        }
    }

    /**
     * Determines whether a given date is a palindrome date, meaning it reads the
     * same forwards and backwards.
     * 
     * @param year
     * @param month
     * @param day
     * @return {@code true} if the date is a palindrome date; otherwise,
     *         {@code false}.
     */
    private static boolean isPalindromeDate(int year, int month, int day) {
        // Format the date components into a string representation ("YYYYMMDD").
        String dateStr = String.format("%04d%02d%02d", year, month, day);

        String reversedStr = new StringBuilder(dateStr).reverse().toString();

        // Return true if the reversed string is equal to the original string.
        return dateStr.equals(reversedStr);
    }

    public static void main(String[] args) {
        printBonusDatesBetween(2010, 2015);
    }
}
