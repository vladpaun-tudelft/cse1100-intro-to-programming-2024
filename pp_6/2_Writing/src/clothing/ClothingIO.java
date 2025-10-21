package clothing;

import clothing.data.ClothingItem;

import java.io.*;
import java.util.List;

public class ClothingIO {

    /**
     * Writes a list of clothing items to a given output stream.
     *
     * @param catalogueStream The output stream
     * @param items The list of clothing items
     */
    public static void writeCatalogue(OutputStream catalogueStream, List<ClothingItem> items) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(catalogueStream)) {
            objectOutputStream.writeObject(items);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * Reads all clothing items in a given input stream.
     *
     * @param catalogueStream The input stream
     * @return The list of clothing items
     */
    public static List<ClothingItem> readCatalogue(InputStream catalogueStream) {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(catalogueStream)) {
            return (List<ClothingItem>) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
