package clothing;

import clothing.data.ClothingItem;
import clothing.data.Dress;
import clothing.data.Shirt;
import clothing.data.Shoes;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClothingIOTest {

    @Test
    void writingAndThenReadingWorks() {

        List<ClothingItem> catalogue = List.of(
                new Dress("Red", 11999, 1.10),
                new Shirt("White", 1000, 'M'),
                new Shoes("Black", 4449, 42)
        );

        // Write
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ClothingIO.writeCatalogue(out, catalogue);

        // Read back
        assertEquals(catalogue, ClothingIO.readCatalogue(new ByteArrayInputStream(out.toByteArray())));

    }

}
