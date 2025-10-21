import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class CityReader {

    public static Stream<City> readCitiesFunctional(BufferedReader reader) {
        return reader.lines()
                .filter(line -> !line.isEmpty())
                .map(line -> line.split(","))
                .map(line -> new City(line[0], Integer.parseInt(line[1]), line[2], Double.parseDouble(line[3])));
    }

    public static List<City> readCitiesImperative(BufferedReader reader) throws IOException {
        // Read all lines
        List<String> lines = new ArrayList<>();
        String line = reader.readLine();
        while (line != null) {
            lines.add(line);
            line = reader.readLine();
        };

        // Remove all empty lines
        List<String> notEmpty = new ArrayList<>();
        for (int i = 0; i < lines.size(); i++) {
            if (!lines.get(i).isBlank()) {
                notEmpty.add(lines.get(i));
            }
        }

        // Split all lines on comma
        List<String[]> linesSplit = new ArrayList<>();
        for (int i = 0; i < notEmpty.size(); i++) {
            linesSplit.add(notEmpty.get(i).split(","));
        }

        // Convert the String arrays to cities
        List<City> cities = new ArrayList<>();
        for (int i = 0; i < linesSplit.size(); i++) {
            String[] parts = linesSplit.get(i);
            cities.add(new City(parts[0], Integer.parseInt(parts[1]), parts[2],
                    Double.parseDouble(parts[3])));
        }

        return cities;
    }

}
