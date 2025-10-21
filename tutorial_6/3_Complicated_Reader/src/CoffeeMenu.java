import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class CoffeeMenu {

    public static void main (String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("resources/coffee.txt"));
        CoffeeMenu menu = read(input);
        System.out.println(menu);
    }

    /**
     * Reads a coffee menu from the given input.
     *
     * @param input The scanner to read from
     * @return The coffee menu read from the input
     */
    public static CoffeeMenu read(Scanner input) {
        List<CoffeeItem> coffees = new ArrayList<>();
        List<Addition> additions = new ArrayList<>();

        input.nextLine();
        input.useDelimiter("COFFEE,|ADDITIONS\n");
        // Parse coffee item
        while (input.hasNext()) {
            String nextElement = input.next();
            if(input.hasNext()) {
                coffees.add(CoffeeItem.read(nextElement));
            } else {
                Scanner additionsScanner = new Scanner(nextElement);
                while(additionsScanner.hasNextLine()) {
                    additions.add(Addition.read(additionsScanner.nextLine()));
                }
            }

        }

        // Parse additions

        return new CoffeeMenu(coffees, additions);
    }

    private List<CoffeeItem> coffees;
    private List<Addition> additions;

    /**
     * Creates a coffee menu.
     *
     * @param coffees The list of coffees on the menu
     * @param additions The list of additions on the menu
     */
    public CoffeeMenu(List<CoffeeItem> coffees, List<Addition> additions) {
        this.coffees = coffees;
        this.additions = additions;
    }

    /**
     * Gets the coffees on the menu.
     *
     * @return The list of coffees on this menu
     */
    public List<CoffeeItem> getCoffees() {
        return coffees;
    }

    /**
     * Gets the additions on the menu.
     *
     * @return The list of coffees on this menu
     */
    public List<Addition> getAdditions() {
        return additions;
    }

    /**
     * Checks whether an object is equal to the coffee menu.
     *
     * @param other The other object
     * @return True iff the other is an identical coffee menu
     */
    @Override
    public boolean equals(Object other) {
        if (other == null || this.getClass() != other.getClass()) return false;
        CoffeeMenu that = (CoffeeMenu) other;
        return Objects.equals(this.coffees, that.coffees) && Objects.equals(this.additions, that.additions);
    }

    @Override
    public String toString() {
        return "CoffeeMenu:" +
                "\n\tCoffees:" + coffees +
                "\n\tAdditions:" + additions;
    }
}
