import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PlantCollection {
    private List<Plant> plants;

    /**
     * Makes a new empty Plant collection object
     */
    public PlantCollection() {
        plants = new ArrayList<>();
    }

    /**
     * Makes a new plant collection object
     * @param plants with the list of plants to be created with
     */
    public PlantCollection(List<Plant> plants) {
        this.plants = plants;
    }

    /**
     * Reads in a plantcollection from a filepath given
     * @param filePath the filepath to the file
     * @return the plant collection from tje file
     */
    public static PlantCollection read(String filePath) {
        PlantCollection plantCollection = new PlantCollection();

        try (Scanner inFile = new Scanner(new File(filePath))) {

            inFile.useDelimiter("(?=HERB: |SHRUB: |TREE: )");

            while (inFile.hasNext()) {
                plantCollection.addPlant(Plant.read(inFile.next().strip()));
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        return plantCollection;
    }

    /**
     * Filters by edible/unedible herbs
     * @return a success string
     */
    public String filterByEdibility(boolean getEdible) {

        plants = plants.stream()
                        .filter(plant -> plant instanceof Herb hb &&
                                hb.isEdible() == getEdible)
                        .collect(Collectors.toList());

        return "Filtered.";
    }

    /**
     * Filters by the color of stuff
     * @return a success string
     */
    public String filterByColor(String color) {

        plants = plants.stream()
                        .filter(plant -> plant.getFlowerDetails().hasFlowers() &&
                                plant.getFlowerDetails().color().get().equals(color))
                        .collect(Collectors.toList());

        return "Filtered.";
    }

    /**
     * Filters by the size fo stuff
     * @return a success string
     */
    public String filterBySize(int size) {

        plants = plants.stream()
                        .filter(plant -> plant.getMinSize() <= size
                                && plant.getMaxSize() >= size)
                        .collect(Collectors.toList());
        return "Filtered.";
    }

    /**
     * Adds a new plant to the list
     * @param plant the plant to be added
     */
    public void addPlant(Plant plant) {
        plants.add(plant);
    }

    /**
     * Equals method for objects of this class
     * @param o the object to be compared with
     * @return true if objrcts are equal
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlantCollection that = (PlantCollection) o;
        return Objects.equals(plants, that.plants);
    }

    /**
     * ToString method of a plant collection
     * @return the string representation of a plant collection
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("There are a total of " + plants.size()
                + " plant(s) that fit the selected filters\n");

        for (int i = 0; i < plants.size(); i++) {
            sb.append("\t").append(i+1).append(". ").append(plants.get(i)).append("\n");
        }

        return sb.toString();
    }

    /**
     * Hashcode method for objects of this class
     * @return the int hashcode of such an instance
     */
    @Override
    public int hashCode() {
        return Objects.hashCode(plants);
    }

    /**
     * Gets the plants
     * @return the plants list
     */
    public List<Plant> getPlants() {
        return plants;
    }

    /**
     * shallow copies the plant collection
     * @return a new plant collection
     */
    public PlantCollection copy() {
        PlantCollection pc =  new PlantCollection();
        for (Plant p : plants) {
            pc.addPlant(p);
        }

        return pc;
    }

    /**
     * Simulates global warming by increasing the size of all stuff
     */
    public void simulateGlobalWarming() {
        plants.replaceAll(
                plant -> plant.globalWarming()
        );
    }

    /**
     * Prints all the distinct colors in the collection
     */
    public String showColors() {
        String s = "Here are the available flower colors:\n";
        for (
                String color : plants.stream()
                .filter(plant -> plant.getFlowerDetails().hasFlowers())
                .map(plant -> plant.getFlowerDetails().color().get())
                .distinct()
                .collect(Collectors.toList())
        ) {
            s+= "\t" + color + "\n";
        }

        return s;
    }
}
