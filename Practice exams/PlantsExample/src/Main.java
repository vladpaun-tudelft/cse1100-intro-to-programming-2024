import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class Main {



    public static void main(String[] args) throws FileNotFoundException {
        BufferedReader fileReader = new BufferedReader(new FileReader("resources/plants.txt"));
        List<String> lines = fileReader.lines().toList();

        PlantCatalogue plants = PlantCatalogue.read(lines);

        String s = "";
    }
}