import java.util.Optional;

public class CalculatorApplication {

    /**
     * Safely divides two doubles.
     *
     * @param dividend The dividend, i.e. a in a/b
     * @param divisor The divisor, i.e. b in a/b
     * @return An optional of the quotient or an empty optional if the divisor is zero
     */
    public static Optional<Double> safeDivide(double dividend, double divisor) {
        return divisor==0?Optional.empty():Optional.of(dividend/divisor);
    }
}
