import java.util.Scanner;

/**
 * The type Date.
 */
public class Date implements Comparable<Date>{

    /**
     * Read date.
     *
     * @param dateString the date string
     * @return the date
     */
    public static Date readDate(String dateString) {
        Scanner dateScanner = new Scanner(dateString);
        dateScanner.useDelimiter("-");
        return new Date(
                dateScanner.nextInt(),
                dateScanner.nextInt(),
                dateScanner.nextInt()
        );
    }

    /**
     * Gets user date.
     *
     * @param userInput the user input
     * @return the user date
     */
    static Date getUserDate(Scanner userInput) {
        System.out.print("Planned date: ");
        System.out.print("Day: ");
        int day = userInput.nextInt();
        System.out.print("\tMonth: ");
        int month = userInput.nextInt();
        System.out.print("\tYear: ");
        int year = userInput.nextInt();

        return new Date(day, month, year);
    }


    private int day;
    private int month;
    private int year;

    /**
     * Instantiates a new Date.
     *
     * @param day   the day
     * @param month the month
     * @param year  the year
     */
    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }


    /**
     * Gets day.
     *
     * @return the day
     */
    public int getDay() {
        return day;
    }

    /**
     * Gets month.
     *
     * @return the month
     */
    public int getMonth() {
        return month;
    }

    /**
     * Gets year.
     *
     * @return the year
     */
    public int getYear() {
        return year;
    }

    /**
     * String representation of a date
     * @return string of date
     */
    @Override
    public String toString() {
        return day + "-" + month + "-" + year;
    }

    /**
     * Equals method for dates
     * @param other Date object
     * @return true if equal
     */
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || other.getClass() != this.getClass()) return false;
        Date that = (Date) other;
        return this.day == that.day && this.month == that.month && this.year == that.year;
    }

    /**
     * Method to compare two dates
     * @param o the object to be compared.
     * @return the order of the dates
     */
    @Override
    public int compareTo(Date o) {
        if (this.year != o.year) {
            return Integer.compare(this.year, o.year);
        }
        if (this.month != o.month) {
            return Integer.compare(this.month, o.month);
        }
        return Integer.compare(this.day, o.day);
    }
}
