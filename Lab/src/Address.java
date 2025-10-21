import java.util.Scanner;

public record Address(String street, int number, String zipCode, String city) {

    /**
     * Reads a correctly formatted address string.
     *
     * @param addressString a string containing an address in the format:
     *                      "[Street]; [Number]; [ZipCode]; [City]"
     * @return an Address object
     */
    public static Address readAddress(String addressString) {
        Scanner addressScanner = new Scanner(addressString);
        addressScanner.useDelimiter("; ");
        return new Address(
                addressScanner.next(),
                addressScanner.nextInt(),
                addressScanner.next(),
                addressScanner.next()
        );
    }

    static Address getUserAddress(Scanner userInput) {
        System.out.print("Job location: ");
        System.out.print("Street: ");
        String street = userInput.next();
        System.out.print("\tNumber: ");
        int number = userInput.nextInt();
        System.out.print("\tZipCode: ");
        String zipCode = userInput.next();
        System.out.print("\tCity: ");
        String city = userInput.next();

        return new Address(street, number, zipCode, city);
    }



    /**
     * Makes a string version of address
     *
     * @return (String) Address
     */
    public String toString() {
        return street + "; " + number + "; " + zipCode + "; " + city;
    }

    /**
     * Equals method for address
     *
     * @param other Address object
     * @return true if objects are equal, false otherwise
     */
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || this.getClass() != other.getClass()) return false;
        Address otherAddress = (Address) other;
        return this.zipCode.equals(otherAddress.zipCode) && this.number == otherAddress.number;
    }
}
