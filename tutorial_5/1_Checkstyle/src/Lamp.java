public class Lamp extends Appliance implements Togglable {

    private boolean on;
    private int red;
    private int green;
    private int blue;
    private double power;
    private boolean hasLightSwitch;

    /**
     *
     * @return red
     */
    public int getRed() {
        return red;
    }

    /**
     *
     * @return green
     */
    public int getGreen() {
        return green;
    }

    /**
     *
     * @return blue
     */
    public int getBlue() {
        return blue;
    }

    /**
     *
     * @param red
     */
    public void setRed(int red) {
        this.red = red;
    }

    /**
     *
     * @param green
     */
    public void setGreen(int green) {
        this.green = green;
    }

    /**
     *
     * @param blue
     */
    public void setBlue(int blue) {
        this.blue = blue;
    }

    /**
     * Creates a lamp.
     *
     * @param name The name
     * @param on Whether the lamp is on
     * @param red The red component of the colour
     * @param green The green component of the colour
     * @param blue The blue component of the colour
     * @param power The power (between 0 and 1)
     * @param hasLightSwitch Whether the lamp has a light switch
     */
    public Lamp(String name, boolean on, int red, int green, int blue,
                double power, boolean hasLightSwitch) {
        super(name);
        this.on = on;
        this.red = red;
        this.green = green;
        this.blue = blue;
        this.power = power;
        this.hasLightSwitch = hasLightSwitch;
    }

    /**
     * Gets the power.
     *
     * @return The power
     */
    public double getPower() {
        return power;
    }

    /**
     * Sets the power.
     *
     * @param power The new power
     */
    public void setPower(double power) {
        this.power = power;
    }

    /**
     * Gets whether the lamp has a light switch.
     *
     * @return True iff this lamp has a light switch
     */
    public boolean hasLightSwitch() {
        return hasLightSwitch;
    }

    /**
     * @inheritDoc
     */
    @Override
    public void turnOff() {
        on = false;
        System.out.println(getName() + " is now off");
    }

    /**
     * @inheritDoc
     */
    @Override
    public void turnOn() {
        on = true;
        System.out.println(getName() + " is now on");
    }

    /**
     * @inheritDoc
     */
    @Override
    public boolean isOn() {
        return on;
    }

    /**
     * @inheritDoc
     */
    @Override
    public String getDescription() {
        String desc = "Lamp " + getName() + " with power " + power +
                " and colour (" + red + ", " + green + ", " + blue + ") ";
        if (hasLightSwitch) desc += "with a light switch ";
        if (on) desc += "is turned on";
        else desc += "is turned off";
        return desc;
    }
}
