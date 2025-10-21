import java.util.Objects;

public class City {

    private final String name;
    private final int population;
    private final String province;
    private final double area;

    /**
     * Creates a city.
     *
     * @param name The name of the city
     * @param population The population of the city
     * @param province The province the city is in
     * @param area The surface area of the city in squared kilometres
     */
    public City(String name, int population, String province, double area) {
        this.name = name;
        this.population = population;
        this.province = province;
        this.area = area;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return population == city.population && Double.compare(area, city.area) == 0 && Objects.equals(name, city.name) && Objects.equals(province, city.province);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, population, province, area);
    }

    @Override
    public String toString() {
        return name + ", " + province + " - Population: " + population + " - Area: " + area + "km²";
    }
}
