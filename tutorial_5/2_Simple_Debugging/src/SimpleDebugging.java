public class SimpleDebugging {

    /**
     * Calculates and prints the primes between 0 and 100.
     */
    public static void main(String[] args) {
        boolean[] primes = calculatePrimes();
        printPrimes(primes);
    }

    /**
     * Calculates the primes between 0 and 100.
     *
     * @return The array of primes, if primes[n] is true, n is prime
     */
    private static boolean[] calculatePrimes() {
        boolean[] primes = new boolean[100];
        int number = 1;
        while (++number < 100) {
            int divisor = number - 1;
            primes[number] = true;
            while (divisor-- > 2) {
                if (number % divisor == 0) {
                    primes[number] = false;
                    break;
                }
            }
        }
        return primes;
    }

    /**
     * Prints the given primes.
     *
     * @param primes The array of primes to be printed
     */
    private static void printPrimes(boolean[] primes) {
        System.out.println("The primes are:");
        for (int i = 0; i < primes.length; i++) {
            if (primes[i]) {
                System.out.println(i);
            }
        }
    }

}
