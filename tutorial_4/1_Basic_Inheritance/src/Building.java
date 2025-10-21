import java.util.Objects;

public class Building {
    private String street;
    private int value;

    public Building(String street, int value) {
        this.street = street;
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Building building = (Building) o;
        return value == building.value && Objects.equals(street, building.street);
    }

    @Override
    public int hashCode() {
        return Objects.hash(street, value);
    }
}
