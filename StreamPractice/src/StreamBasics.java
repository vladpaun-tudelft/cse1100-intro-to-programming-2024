import java.util.Arrays;

public class StreamBasics {
    public static int[] even(int[] input) {
        return Arrays.stream(input)
                .filter(x -> x%2 == 0)
                .toArray();
    }

    public static int[] squareAll(int[] input) {
        return Arrays.stream(input)
                .map(v -> v * v)
                .toArray();
    }
}
