import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;
import java.util.OptionalInt;

import static org.junit.jupiter.api.Assertions.*;

class ShrubTest {

    Plant p3,p7;

    @BeforeEach
    void setUp() {
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
    void testToString() {
        assertEquals(p3.toString(),
                """
                        Shrub named Sweetbriar Rose (latin: Rosa rubiginosa), typical size between 200cm and 300cm.
                        		This plant has medium, pink flowers with 5 petals.
                        		""");
    }

    @Test
    void globalWarming() {
        Shrub p1 = new Shrub(
                new Names("Sweetbriar Rose","Rosa rubiginosa"),
                220,
                330,
                new FlowerDetails(true,
                        Optional.of("pink"),
                        Optional.of("medium"),
                        OptionalInt.of(5)
                )
        );
        assertEquals(p1, p3.globalWarming());
    }
}