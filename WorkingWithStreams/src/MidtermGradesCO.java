import java.util.List;

/**
 * This class showcases how to do some calculations.
 * Based on (fictional) points for the CO midterm!
 */
public class MidtermGradesCO {

    public static void main(String[] args) {
        // Let's do some calculations with the CO midterm grades.

        List<Integer> points = List.of(1820, 3320,1240,2380, 3840);
        // Let's give everyone 400 points extra, and calculate the grades list


        var result = points.stream()
                .map(x -> x + 400)
                .map(x -> max4000(x))
                .map(x -> (x.doubleValue() / 400))
                .sorted()
                .toList();

        // How about the average?
        // What about the pass rate?

        var average = result
                .stream()
                .mapToDouble(x -> x.doubleValue())
                .average();
        var passRate = result.stream().filter(x -> x > 5.8).count();

        System.out.println(result);
        System.out.println(average.getAsDouble());
        System.out.println("The passrate is " + passRate + " out of " + result.size());
    }

    private static Integer max4000(Integer x) {
        if(x > 4000){
            return 4000;
        }
        return x;
    }
}
