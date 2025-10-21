import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

import static org.junit.jupiter.api.Assertions.*;
class PlantCollectionTest {

    PlantCollection pc;
    Plant p1,p2,p3,p4,p5,p6,p7;

    @BeforeEach
    void setUp() {
        pc = new PlantCollection();

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

        pc.addPlant(p1);
        pc.addPlant(p2);
        pc.addPlant(p3);
        pc.addPlant(p4);
        pc.addPlant(p5);
        pc.addPlant(p6);
        pc.addPlant(p7);
    }

    @Test
    void read() {
        String filePath = "C:\\Users\\vladp\\IdeaProjects\\" +
                "Practice exams\\Plants\\resources\\plants.txt";
        assertEquals(pc, PlantCollection.read(filePath));
    }

    @Test
    void addPlant() {
        PlantCollection pc2 = new PlantCollection();
        pc2.addPlant(p1);
        assertEquals(p1, pc2.getPlants().getFirst());
    }

    @Test
    void testEquals() {
        PlantCollection pc2 = new PlantCollection();
        pc2.addPlant(p1);
        pc2.addPlant(p2);
        pc2.addPlant(p3);
        pc2.addPlant(p4);
        pc2.addPlant(p5);
        pc2.addPlant(p6);
        assertNotEquals(pc, pc2);
        pc2.addPlant(p7);
        assertEquals(pc, pc2);
        assertEquals(pc,pc);
    }

    @Test
    void testToString() {
        assertEquals("""
                        There are a total of 7 plant(s) that fit the selected filters
                        	1. Herb named White mustard (latin: Sinapis alba), typical size between 20cm and 70cm.
                        		This plant has small, yellow flowers with 4 petals.
                        		This herb is safe to eat. strong, pungent, somewhat bitter and slightly sweet
                        
                        	2. Herb named Basil (latin: Ocimum basilicum), typical size between 30cm and 150cm.
                        		This plant has small, white flowers with 5 petals.
                        		This herb is safe to eat. savory and sweet with mint and pepper notes
                        
                        	3. Shrub named Sweetbriar Rose (latin: Rosa rubiginosa), typical size between 200cm and 300cm.
                        		This plant has medium, pink flowers with 5 petals.
                        
                        	4. Tree named Pine (latin: Pinus), typical size between 300cm and 8000cm.
                        		This plant does not have flowers.
                        
                        	5. Tree named Oshima cherry (latin: Prunus speciosa), typical size between 400cm and 1200cm.
                        		This plant has medium, white flowers with 5 petals.
                        
                        	6. Herb named Bracken fern (latin: Pteridium aquilinum), typical size between 30cm and 100cm.
                        		This plant does not have flowers.
                        		This herb is not safe to eat. a mixture of asparagus, almonds and kale
                        
                        	7. Shrub named King sago (latin: Cycas revoluta), typical size between 50cm and 100cm.
                        		This plant does not have flowers.
                        
                        """
                ,pc.toString());
    }

    @Test
    void testHashCode() {
        PlantCollection pc2 = new PlantCollection();
        pc2.addPlant(p1);
        pc2.addPlant(p2);
        pc2.addPlant(p3);
        pc2.addPlant(p4);
        pc2.addPlant(p5);
        pc2.addPlant(p6);
        assertNotEquals(pc.hashCode(), pc2.hashCode());
        pc2.addPlant(p7);
        assertEquals(pc.hashCode(), pc2.hashCode());
        assertEquals(pc.hashCode(),pc.hashCode());
    }

    @Test
    void copy() {
        PlantCollection pc2 = pc.copy();
        assertEquals(pc,pc2);
    }

    @Test
    void simulateGlobalWarming() {
        PlantCollection pc2 = pc.copy();
        pc.simulateGlobalWarming();
        assertEquals((int) pc2.getPlants().get(0).getMinSize() * 11 /10,
                pc.getPlants().get(0).getMinSize());
    }

    @Test
    void filterbyEdibility() {
        PlantCollection pc2 = new PlantCollection(List.of(p1,p2));
        pc.filterByEdibility(true);
        assertEquals(pc,pc2);
    }

    @Test
    void filterbyEdibilityFalse() {
        PlantCollection pc2 = new PlantCollection(List.of(p6));
        pc.filterByEdibility(false);
        assertEquals(pc,pc2);
    }



    @Test
    void filterByColor() {
        PlantCollection pc2 = new PlantCollection(List.of(p3));
        pc.filterByColor("pink");
        assertEquals(pc,pc2);
    }

    @Test
    void filerBySize() {
        PlantCollection pc2 = new PlantCollection(List.of(p4,p5));
        pc.filterBySize(1000);
        assertEquals(pc,pc2);
    }

    @Test
    void showColors() {
        assertEquals("""
                Here are the available flower colors:
                	yellow
                	white
                	pink
                 """, pc.showColors());
    }

    @Test
    void exceptionTest() {
        assertThrows(RuntimeException.class, () -> PlantCollection.read(""));
    }
}