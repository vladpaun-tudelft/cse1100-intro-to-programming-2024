import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class VenueCatalogueTest {
    Venue v1; Venue v2; Venue v3; Venue v4; Venue v5;
    Restaurant r1; Restaurant r2; Restaurant r3; Restaurant r4;
    Bar b1; Bar b2; Bar b3;
    VenueCatalogue vc;

    @BeforeEach
    void setUp() {
        List<String> menu1 = List.of("pasta", "bread", "cheese", "pizza");
        List<String> menu2 = List.of("pasta", "bread", "sarmale", "kebab");
        List<String> menu3 = List.of("papanasi", "bulz", "sarmale", "kebab");
        List<String> menu4 = List.of("manti", "caca", "pipi", "pizza");

         v1 = new Venue("bla","bla",4, menu1);
         v2 = new Venue("bla","bla",3, menu2);
         v3 = new Venue("bla","bla",2, menu3);
         v4 = new Venue("bla","bla",1, menu3);
         v5 = new Venue("bla","bla",5, menu1);
         r1 = new Restaurant("bla", "bla", 4,menu1, true);
         r2 = new Restaurant("bla", "bla", 3,menu4, false);
         r3 = new Restaurant("bla", "bla", 2,menu2, true);
         r4 = new Restaurant("bla", "bla", 1,menu3, false);
         b1 = new Bar("bla","bla",5,menu1,4,5);
         b2 = new Bar("bla","bla",3,menu2,1,5);
         b3 = new Bar("bla","bla",1,menu4,1,5);
         

         vc = new VenueCatalogue(List.of(v1,v2,v3,v4,v5,r1,r2,r3,r4,b1,b2,b3));

    }

    @Test
    void qualityVenues() {
        assertEquals(List.of(v1,v2,v5,r1,r2,b1,b2), vc.qualityVenues());
    }

    @Test
    void veganRestaurantNames() {
        assertEquals(List.of(r1.getName(),r3.getName()), vc.veganRestaurantNames());
    }

    @Test
    void cheapDrinkingLocations() {
        assertEquals(List.of(b2.getLocation(),b3.getLocation()), vc.cheapDrinkingLocations());
    }

    @Test
    void averageStars() {
        OptionalDouble average = vc.averageStars();
        assertTrue(average.isPresent());
        assertEquals(OptionalDouble.of(34.0/12), average);
    }

    @Test
    void uniqueMenu() {
        assertEquals(List.of("pasta", "bread", "cheese", "pizza", "sarmale", "kebab", "papanasi", "bulz", "manti", "caca", "pipi"), vc.allUniqueMenuItems());
    }
}
