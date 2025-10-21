public abstract class Appliance {

    private String name;

    /**
     * Creates an appliance.
     *
     * @param name The name of the appliance
     */
    public Appliance(String name) {
        this.name = name;
    }

    /**
     * Gets the name of the appliance.
     *
     * @return The name of this appliance
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the appliance.
     *
     * @param name The new name for this appliance
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Converts this appliance to a string in the following format:
     * <code>&quot;name (appliance type)&quot;</code>
     *
     * @return The string representation of this appliance
     */
    @Override
    public String toString() {
        return name + " (" + getClass().getSimpleName() + ")";
    }

    /**
     * Gets the description for the appliance.
     *
     * @return The description for this appliance
     */
    public abstract String getDescription();

}
