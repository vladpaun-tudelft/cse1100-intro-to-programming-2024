import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * This example shows how you can filter a list of numbers on
 * a specific condition.
 */
public class GreaterThanFive {

    public static void main(String[] args) {
        List<Integer> input = List.of(3, 4, 5, 6, 7);
        Predicate<Integer> condition = x -> x > 5;
        List<Integer> result;

        result = filterGreaterThan5(input);
//        result = filterGreaterThanX(input, 5);
//        result = filterOnConditionIterative(input, condition);
//        result = filterOnConditionFunctional(input, condition);

        System.out.println(result);
    }



    public static List<Integer> filterGreaterThan5(List<Integer> input) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < input.size(); i++) {
            Integer element = input.get(i);
            if (element > 5) {
                result.add(element);
            }
        }
        return result;
    }

    public static List<Integer> filterGreaterThanX(List<Integer> input, int x) {
        List<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < input.size(); i++) {
            Integer element = input.get(i);
            if (element > x) {
                result.add(element);
            }
        }
        return result;
    }

    public static List<Integer> filterOnConditionIterative(
            List<Integer> input, Predicate<Integer> condition) {

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < input.size(); i++) {
            Integer element = input.get(i);
            if (condition.test(element)) {
                result.add(element);
            }
        }
        return result;
    }

    private static List<Integer> filterOnConditionFunctional(
            List<Integer> input, Predicate<Integer> condition) {
        // map  --> Stream<TypeA> --> Stream<TypeB> (number of elements stays the same).
        // filter --> Stream<Type> --> Stream<Type> (may reduce number of elements).

        // input --> List<Integer>
        // .stream --> Stream<Integer>    != IntStream
        // .filter --> Stream<Integer> (but number of elements may be reduced)
        // .toList --> List<Integer>
        return input.stream().filter(condition).toList();

    }
}
