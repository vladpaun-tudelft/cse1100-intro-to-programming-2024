import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class StoreApplication {

    /**
     * Reads store.csv and prints out the store.
     *
     * @throws IOException If the file reading fails
     */
    public static void main(String[] args) throws IOException {
        System.out.println(Store.read(new Scanner(new File("resources/store.csv"))));
    }

}
