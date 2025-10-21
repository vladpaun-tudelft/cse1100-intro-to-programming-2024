import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * This class showcases an overview of different function interfaces
 * that are used.
 */
public class Functions {

    public static void main(String[] args) {
        Function<Integer, Integer> increment = x -> x + 1;
        int result = increment.apply(5);
        System.out.println(result);

        BiFunction<Integer, Integer, Integer> add = (x, y) -> x + y;
        int result2 = add.apply(3, 6);
        System.out.println(result2);

        Supplier<Boolean> truthSupplier = () -> true;
        boolean result3 = truthSupplier.get();
        System.out.println(result3);

        Predicate<Integer> greaterThanFive = x -> x > 5;
        boolean result4 = greaterThanFive.test(4);
        System.out.println(result4);
    }
}
