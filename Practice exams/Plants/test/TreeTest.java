import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;
import java.util.OptionalInt;

import static org.junit.jupiter.api.Assertions.*;

class TreeTest {

    Plant p4,p5;

    @BeforeEach
    void setUp() {

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
    }

    @Test
    void testToString() {
        assertEquals("""
                Tree named Pine (latin: Pinus), typical size between 300cm and 8000cm.
                		This plant does not have flowers.
                """,p4.toString());
    }

    @Test
    void globalWarming() {
        Tree p1 = new Tree(
                new Names("Oshima cherry","Prunus speciosa"),
                440,
                1320,
                new FlowerDetails(true,
                        Optional.of("white"),
                        Optional.of("medium"),
                        OptionalInt.of(5)
                )
        );

        assertEquals(p1, p5.globalWarming());
    }
}