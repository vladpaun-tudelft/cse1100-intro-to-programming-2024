public class Date {

    private int day;
    private int month;
    private int year;

    /**
     * Creates a date.
     *
     * @param day The day of month
     * @param month The number of the month (i.e. jan=1, feb=2, etc.)
     * @param year The year
     */
    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    /**
     * Gets the day.
     *
     * @return The day of month
     */
    public int getDay() {
        return day;
    }

    /**
     * Gets the month.
     *
     * @return The number of the month
     */
    public int getMonth() {
        return month;
    }

    /**
     * Gets the year.
     *
     * @return The year
     */
    public int getYear() {
        return year;
    }

    /**
     * Converts this date to a string representation of the form "day/month/year".
     *
     * @return The string representation of this date
     */
    @Override
    public String toString() {
        return day + "/" + month + "/" + year;
    }
}
