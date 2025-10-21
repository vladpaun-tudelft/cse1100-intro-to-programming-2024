public abstract class DailyWeather {

    private Date date;
    private double temperature;
    private int windSpeed;

    /**
     * Creates a daily weather.
     *
     * @param date The date of the weather
     * @param temperature The temperature in C
     * @param windSpeed The wind speed in BFT
     */
    public DailyWeather(Date date, double temperature, int windSpeed) {
        this.date = date;
        this.temperature = temperature;
        this.windSpeed = windSpeed;
    }

    @Override
    public String toString() {
        return date.toString() + "," + getType() + "," + temperature + "C," + windSpeed + "BFT";
    }

    public abstract String getType();

    /**
     * Gets the date.
     *
     * @return The date of this weather
     */
    public Date getDate() {
        return date;
    }

    /**
     * Gets the temperature.
     *
     * @return The temperature in Celsius
     */
    public double getTemperature() {
        return temperature;
    }

    /**
     * Gets the wind speed.
     *
     * @return The wind speed in beaufort
     */
    public int getWindSpeed() {
        return windSpeed;
    }

}
