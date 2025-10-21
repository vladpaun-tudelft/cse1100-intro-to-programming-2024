import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;
import java.util.OptionalInt;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class HerbTest {

    Plant p1,p2,p3;

    @BeforeEach
    void setUp() {
        p1 = new Herb(
                new Names("White mustard","Sinapis alba"),
                20,
                70,
                new FlowerDetails(true,
                        Optional.of("yellow"),
                        Optional.of("small"),
                        OptionalInt.of(4)
                ),
                true,
                "strong, pungent, somewhat bitter and slightly sweet"
        );
        p2 = new Herb(
                new Names("Basil","Ocimum basilicum"),
                30,
                150,
                new FlowerDetails(true,
                        Optional.of("white"),
                        Optional.of("small"),
                        OptionalInt.of(5)
                ),
                true,
                "savory and sweet with mint and pepper notes"
        );
        p3 = new Herb(
                new Names("Bracken fern","Pteridium aquilinum"),
                30,
                100,
                new FlowerDetails(false,
                        Optional.empty(),
                        Optional.empty(),
                        OptionalInt.empty()
                ),
                false,
                "a mixture of asparagus, almonds and kale"
        );
    }

    @Test
    void testToString() {
        assertEquals(p1.toString(), """
                Herb named White mustard (latin: Sinapis alba), typical size between 20cm and 70cm.
                		This plant has small, yellow flowers with 4 petals.
                		This herb is safe to eat. strong, pungent, somewhat bitter and slightly sweet
                """);
    }

    @Test
    void read() {
        assertEquals(p1, Herb.read(
                new Names("White mustard","Sinapis alba"),
                20,
                70,
                new Scanner("""
                        FLOWER DETAILS: yellow; small; 4 petals
                        EDIBILITY: Yes; strong, pungent, somewhat bitter and slightly sweet""")
                )
        );
    }

    @Test
    void testEquals() {
        Herb p5 = new Herb(
                new Names("White mustard","Sinapis alba"),
                20,
                70,
                new FlowerDetails(true,
                        Optional.of("yellow"),
                        Optional.of("small"),
                        OptionalInt.of(4)
                ),
                true,
                "strong, pungent, somewhat bitter and slightly sweet"
        );
        assertEquals(p5, p1);
        assertNotEquals(p5, p2);
    }

    @Test
    void testHashCode() {
        Herb p5 = new Herb(
                new Names("White mustard","Sinapis alba"),
                20,
                70,
                new FlowerDetails(true,
                        Optional.of("yellow"),
                        Optional.of("small"),
                        OptionalInt.of(4)
                ),
                true,
                "strong, pungent, somewhat bitter and slightly sweet"
        );
        assertEquals(p5.hashCode(), p1.hashCode());
        assertNotEquals(p5.hashCode(), p2.hashCode());
    }

    @Test
    void globalWarming() {
        Herb p4 = new Herb(
                new Names("White mustard","Sinapis alba"),
                22,
                77,
                new FlowerDetails(true,
                        Optional.of("yellow"),
                        Optional.of("small"),
                        OptionalInt.of(4)
                ),
                true,
                "strong, pungent, somewhat bitter and slightly sweet"
        );

        assertEquals(p4, p1.globalWarming());
    }
}