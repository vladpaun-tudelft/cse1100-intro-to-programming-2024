import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;
import java.util.OptionalInt;

import static org.junit.jupiter.api.Assertions.*;

class PlantTest {

    Plant p1,p2,p3,p4,p5,p6,p7;

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
        p3 = new Shrub(
                new Names("Sweetbriar Rose","Rosa rubiginosa"),
                200,
                300,
                new FlowerDetails(true,
                        Optional.of("pink"),
                        Optional.of("medium"),
                        OptionalInt.of(5)
                )
        );
        p4 = new Tree(
                new Names("Pine","Pinus"),
                300,
                8000,
                new FlowerDetails(false,
                        Optional.empty(),
                        Optional.empty(),
                        OptionalInt.empty()
                )
        );
        p5 = new Tree(
                new Names("Oshima cherry","Prunus speciosa"),
                400,
                1200,
                new FlowerDetails(true,
                        Optional.of("white"),
                        Optional.of("medium"),
                        OptionalInt.of(5)
                )
        );
        p6 = new Herb(
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
        p7 = new Shrub(
                new Names("King sago","Cycas revoluta"),
                50,
                100,
                new FlowerDetails(false,
                        Optional.empty(),
                        Optional.empty(),
                        OptionalInt.empty()
                )
        );
    }

    @Test
    void read() {
        assertEquals(p1, Plant.read("""
                HERB: White mustard; Sinapis alba; (20, 70)
                FLOWER DETAILS: yellow; small; 4 petals
                EDIBILITY: Yes; strong, pungent, somewhat bitter and slightly sweet"""));
    }

    @Test
    void testToString() {
        assertEquals("""
                Herb named White mustard (latin: Sinapis alba), typical size between 20cm and 70cm.
                		This plant has small, yellow flowers with 4 petals.
                		This herb is safe to eat. strong, pungent, somewhat bitter and slightly sweet
                """,
                p1.toString());
    }

    @Test
    void testEquals() {
        Plant pTest = new Herb(
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

        assertEquals(p1, pTest);
        assertNotEquals(p1, p2);
    }

    @Test
    void testHashCode() {
        Plant pTest = new Herb(
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

        assertEquals(p1.hashCode(), pTest.hashCode());
        assertNotEquals(p1.hashCode(), p2.hashCode());
    }

}