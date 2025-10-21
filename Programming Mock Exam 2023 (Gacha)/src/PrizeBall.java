import java.util.Objects;

public abstract class PrizeBall extends Ball{
    private Prize prize;

    public PrizeBall(String color, String description, Prize prize) {
        super(color, description);
        this.prize = prize;
    }

    public Prize getPrize() {
        return prize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PrizeBall prizeBall = (PrizeBall) o;
        return Objects.equals(prize, prizeBall.prize);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), prize);
    }
}
