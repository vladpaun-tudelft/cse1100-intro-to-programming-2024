import java.util.ArrayList;
import java.util.List;

public  class Plant {
    private String name;
    private String latinName;
    private SizeRange size;
    private Flower flower;

    public static int read(int index, List<String> lines, ArrayList<Plant> plants) {
        Flower flower = null;

        String firstLine = lines.get(index);
        index++;

        if(index < lines.size() && lines.get(index).contains("FLOWER")) {
            flower = Flower.read(lines.get(index));
            index++;
        }

        if(firstLine.contains("HERB")) {
            // test for poison;
            index++;
        }
        plants.add(new Plant(null, null, null, flower));
        return index;
    }

    public Plant(String name, String latinName, SizeRange size, Flower flower) {
        this.name = name;
        this.latinName = latinName;
        this.size = size;
        this.flower = flower;
    }


}
