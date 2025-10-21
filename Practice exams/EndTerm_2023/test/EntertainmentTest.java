import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EntertainmentTest {

    @Test
    void readEntertainmentMovieTest() {
        String entertainmentString = """
                MOVIE Barbie; Adventure, Comedy, Fantasy; PG-13
                DURATION 1:54
                BOX OFFICE 1442 million
                CAST Margot Robbie; Barbie""";

        Movie movie = new Movie("Barbie", List.of("Adventure", "Comedy", "Fantasy"),
                Rating.PG_13, 114,
                List.of(new Actor("Margot Robbie", "Barbie")),1442);
        assertEquals(movie, Entertainment.readEntertainment(entertainmentString));
    }

    @Test
    void readEntertainmentSeriesTest() {
        String entertainmentString = """
                SERIES Brooklyn 99; Comedy, Crime; PG-13
                DURATION 0:25; 153 episodes
                CAST Andy Samberg; Jake Peralta""";

        Series series = new Series("Brooklyn 99", List.of( "Comedy", "Crime"), Rating.PG_13, 25,
                List.of(new Actor("Andy Samberg", "Jake Peralta")),153);
        assertEquals(series, Entertainment.readEntertainment(entertainmentString));
    }

    @Test
    void readEntertainmentPodcastTest1() {
        String entertainmentString = """
                PODCAST Reply All - Long Distance; Talk-show, Technology; PG
                DURATION 0:50
                CAST Alex Goldman; themselves
                CAST PJ Vogt; themselves""";

        Podcast podcast = new Podcast("Reply All - Long Distance", List.of("Talk-show", "Technology"), Rating.PG, 50,
                List.of(
                        new Actor("Alex Goldman", "themselves"),
                        new Actor("PJ Vogt", "themselves")
                ),1);
        assertEquals(podcast, Entertainment.readEntertainment(entertainmentString));
    }
    @Test
    void readEntertainmentPodcastTest2() {
        String entertainmentString = """
                PODCAST Reply All - Long Distance; Talk-show, Technology; PG
                DURATION 0:50; 656 episodes
                CAST Alex Goldman; themselves
                CAST PJ Vogt; themselves""";

        Podcast podcast = new Podcast("Reply All - Long Distance", List.of("Talk-show", "Technology"), Rating.PG, 50,
                List.of(
                        new Actor("Alex Goldman", "themselves"),
                        new Actor("PJ Vogt", "themselves")
                ),656);
        assertEquals(podcast, Entertainment.readEntertainment(entertainmentString));
    }
}