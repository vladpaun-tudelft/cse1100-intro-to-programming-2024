import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.StringReader;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CityReaderTest {

    @Test
    void readCities() {
        StringReader reader = new StringReader("""
                Amsterdam,821752,Noord-Holland,219.32
                Delft,106184,Zuid-Holland,24.06
                
                Rotterdam,588490,Zuid-Holland,324.10
                
                
                Utrecht,368024,Utrecht,99.21
                
                """.stripIndent());

        assertEquals(List.of(
                new City("Amsterdam", 821_752, "Noord-Holland", 219.32),
                new City("Delft", 106_184, "Zuid-Holland", 24.06),
                new City("Rotterdam", 588_490, "Zuid-Holland", 324.10),
                new City("Utrecht", 368_024, "Utrecht", 99.21)
        ), CityReader.readCitiesFunctional(new BufferedReader(reader)).toList());
    }

}
