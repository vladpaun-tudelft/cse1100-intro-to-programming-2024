import java.util.Objects;

public class Prize {
    private String name;
    private PrizeRange range;

    public Prize(String name, PrizeRange range) {
        this.name = name;
        this.range = range;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PrizeRange getRange() {
        return range;
    }

    public void setRange(PrizeRange range) {
        this.range = range;
    }

    @Override
    public String toString() {
        return "Prize{" +
                "name='" + name + '\'' +
                ", range=" + range +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prize prize = (Prize) o;
        return Objects.equals(name, prize.name) && Objects.equals(range, prize.range);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, range);
    }
}
