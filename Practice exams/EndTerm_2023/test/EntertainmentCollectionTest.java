import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EntertainmentCollectionTest {

    EntertainmentCollection collection;
    Movie movie;
    Podcast podcast;
    Series series;

    @BeforeEach
    void setUp() {
        collection = new EntertainmentCollection();
        movie = new Movie("Barbie", List.of("Adventure", "Comedy", "Fantasy"),
                Rating.PG_13, 114, List.of(new Actor("Margot Robbie", "Barbie")),
                1442);
        series = new Series("Brooklyn 99", List.of( "Comedy", "Crime"), Rating.PG_13, 25,
                List.of(new Actor("Andy Samberg", "Jake Peralta")),153);
        podcast = new Podcast("Reply All", List.of("Talk-show", "Technology"), Rating.PG, 50,
                List.of(
                        new Actor("Alex Goldman", "themselves"),
                        new Actor("PJ Vogt", "themselves")
                ),1);

        collection.add(movie);
        collection.add(podcast);
        collection.add(series);
    }

    @Test
    void readFile() {

    }

    @Test
    void copy() {
        EntertainmentCollection copy = EntertainmentCollection.copy(collection);
        assertEquals(collection, copy);
    }

    @Test
    void testToString() {
        String string = "We have 3 thing(s) in the collection.\n" +
                "Movie: Barbie - Genres: Adventure, Comedy, Fantasy. Maturity rating: PG_13\n" +
                "\tDuration: 1 hour and 54 minutes\n" +
                "\tCast members: Margot Robbie (Barbie)\n" +
                "\tBox office revenue: 1442 million\n" +
                "Podcast: Reply All - Genres: Talk-show, Technology. Maturity rating: PG\n" +
                "\tDuration: 0 hour and 50 minutes\n" +
                "\tCast members: Alex Goldman (themselves), PJ Vogt (themselves)\n" +
                "\t1 Episode(s).\n" +
                "Series: Brooklyn 99 - Genres: Comedy, Crime. Maturity rating: PG_13\n" +
                "\tDuration: 0 hour and 25 minutes\n" +
                "\tCast members: Andy Samberg (Jake Peralta)\n" +
                "\t153 Episdoes.\n";
        assertEquals(string, collection.toString());
    }

    @Test
    void testEquals() {
       EntertainmentCollection collection2 = new EntertainmentCollection();
       collection2.add(movie);
       collection2.add(podcast);
       collection2.add(series);
       assertEquals(collection, collection2);
       EntertainmentCollection collection3 = new EntertainmentCollection();
       collection3.add(movie);
       collection3.add(podcast);
       assertNotEquals(collection, collection3);

    }

    @Test
    void testHashCode() {
        EntertainmentCollection collection2 = new EntertainmentCollection();
        collection2.add(movie);
        collection2.add(podcast);
        collection2.add(series);
        assertEquals(collection.hashCode(), collection2.hashCode());
        EntertainmentCollection collection3 = new EntertainmentCollection();
        collection3.add(movie);
        collection3.add(podcast);
        assertNotEquals(collection.hashCode(), collection3.hashCode());
    }

    @Test
    void filterOnGenre() {
        collection.filterOnGenre("Comedy");
        EntertainmentCollection collection2 = new EntertainmentCollection();
        collection2.add(movie);
        collection2.add(series);
        assertEquals(collection, collection2);
    }

    @Test
    void filterOnMaxPlaytime() {
        collection.filterOnMaxPlaytime(50);
        EntertainmentCollection collection2 = new EntertainmentCollection();
        collection2.add(podcast);
        collection2.add(series);
        assertEquals(collection, collection2);
    }

    @Test
    void filterOnMinPlaytime() {
        collection.filterOnMinPlaytime(60);
        EntertainmentCollection collection2 = new EntertainmentCollection();
        collection2.add(movie);
        collection2.add(series);
        assertEquals(collection, collection2);
    }

    @Test
    void filterOnRating() {
        collection.filterOnRating(Rating.PG);
        EntertainmentCollection collection2 = new EntertainmentCollection();
        collection2.add(podcast);
        assertEquals(collection, collection2);
    }
}