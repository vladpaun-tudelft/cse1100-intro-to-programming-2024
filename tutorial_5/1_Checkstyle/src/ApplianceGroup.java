import java.util.ArrayList;
import java.util.List;

public class ApplianceGroup {

    private String name;
    private List<Appliance> appliances;

    /**
     * Creates an appliance group.
     *
     * @param name The name
     */
    public ApplianceGroup(String name) {
        this.name = name;
        this.appliances = new ArrayList<>();
    }

    /**
     * Gets the name.
     *
     * @return The name
     */
    public String getName() {
        return name;
    }

    /**
     * Adds an appliance
     *
     * @param appliance
     */
    public void addAppliance(Appliance appliance) {
        appliances.add(appliance);
    }

    /**
     * Toggles the Lights
     */
    public void toggleLights() {
        for (Appliance appliance : appliances) {
            if (appliance instanceof Lamp l) {
                l.toggle();
            }
        }
    }

    /**
     * Plays a song
     * 
     * @param songToPlay
     */
    public void playSong(String songToPlay) {
        for (Appliance appliance : appliances) {
            if (appliance instanceof Speaker s) {
                s.setPlaying(songToPlay);
            }
        }
    }

    /**
     * Sets the Light Color
     * 
     * @param red
     * @param green
     * @param blue
     */
    public void setLightColour(int red, int green, int blue) {
        for (Appliance appliance : appliances) {
            if (appliance instanceof Lamp l) {
                l.setRed(red);
                l.setGreen(green);
                l.setBlue(blue);
            }
        }
    }

    /**
     * Gets the status
     * @return status
     */
    public String getStatus() {
        String status = "Group " + name + ":\n";
        for (Appliance appliance : appliances) {
            status += " - " + appliance.getDescription() + "\n";
        }
        return status;
    }

}
