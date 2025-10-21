import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class PrizeRange {
    private final String name;
    private final List<Prize> possiblePrizes;

    public PrizeRange(String name) {
        this.name = name;
        possiblePrizes = new ArrayList<>();
    }

    public static PrizeRange readPrizeRange(String prizeRangeString, String description) {
        Scanner scanner = new Scanner(description);
        scanner.next();
        scanner.next();
        scanner.next();
        String prizeRangeName = scanner.nextLine();



        PrizeRange prizeRange = new PrizeRange(prizeRangeName);

        prizeRangeString = prizeRangeString.substring(1, prizeRangeString.length() - 1);
        Scanner sc = new Scanner(prizeRangeString);
        sc.useDelimiter(", ");
        while (sc.hasNext()) {
            Prize prize = new Prize(sc.next(), prizeRange);
            prizeRange.possiblePrizes.add(prize);
        }

        return prizeRange;
    }


    public List<Prize> getPossiblePrizes() {
        return possiblePrizes;
    }


    @Override
    public String toString() {
        return "PrizeRange{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PrizeRange that = (PrizeRange) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(possiblePrizes, that.possiblePrizes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, possiblePrizes);
    }

    public String getName() {
        return name;
    }


}
