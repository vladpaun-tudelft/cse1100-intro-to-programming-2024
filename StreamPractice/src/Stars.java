import javax.xml.xpath.XPathEvaluationResult;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Stars {

    public String triangleOfStars(int numberOfLines) {
        return IntStream.rangeClosed(1, numberOfLines)
                .mapToObj(i -> "*".repeat(i))
                .collect(Collectors.joining("\n"));
    }

    public Collection<String> uniqueWordsSorted(BufferedReader reader) {
        return Stream.generate(() -> {
                try {
                    return reader.readLine();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            })
                .map(value -> value.split(" "))
                .flatMap(Arrays::stream) 
                .distinct()
                .sorted()
                .toList();
    }

    public static double e(int upperBound) {
        return IntStream.rangeClosed(0, upperBound)
                .mapToLong(value -> factorial(value))
                .mapToDouble(value -> 1.0/value)
                .sum();
    }

    private static long factorial(int value) {
        return value <= 1 ? 1 : factorial(value - 1) * value;
    }
}
