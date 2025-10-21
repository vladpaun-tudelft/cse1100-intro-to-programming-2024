import java.util.ArrayList;
import java.util.List;

public class PlantCatalogue {

    private List<Plant> plants;

    public static PlantCatalogue read(List<String> lines){
        ArrayList<Plant> plants = new ArrayList<>();
        int index = 0;

        while(index < lines.size()) {
            index = Plant.read(index, lines, plants);
        }

        return new PlantCatalogue(plants);
    }


    public PlantCatalogue(ArrayList<Plant> plants) {
        this.plants = plants;
    }



}
