import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Store {

    /**
     * Reads a store from the given input.
     *
     * @param input The scanner to read from
     * @return The store read from the input
     */
    public static Store read(Scanner input) {
        Store store = new Store();
        while (input.hasNextLine()) {
            store.addProduct(Product.read(input.nextLine()));
        }

        return store;
    }

    private List<Product> products;

    /**
     * Creates a store.
     */
    public Store() {
        this.products = new ArrayList<>();
    }

    /**
     * Adds a product to the store.
     *
     * @param product The product to add
     */
    public void addProduct(Product product) {
        products.add(product);
    }

    /**
     * Gets the products in the store.
     *
     * @return The list of products in this store
     */
    public List<Product> getProducts() {
        return products;
    }

    /**
     * Converts this store to a string representation of the form Store(products: [product1, product2...]).
     *
     * @return The string representation of this store
     */
    @Override
    public String toString() {
        return "Store(products: " + products + ")";
    }

}
