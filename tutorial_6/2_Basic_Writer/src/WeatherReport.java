import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.List;

public class WeatherReport {

    private List<DailyWeather> dailyReports;

    /**
     * Creates a weather report.
     *
     * @param dailyReports The list of daily reports in the weather report
     */
    public WeatherReport(List<DailyWeather> dailyReports) {
        this.dailyReports = dailyReports;
    }

    /**
     * Writes this weather report to the given writer.
     *
     * @param writer The writer to write to
     */
    public void write(Writer writer) throws IOException {

        PrintWriter printWriter = new PrintWriter(writer);

        for (DailyWeather weather : dailyReports) {
            printWriter.println(weather);
        }
        writer.flush();
        writer.close();

        /*
        for (DailyWeather dailyWeather : dailyReports) {
            try {
                writer.write(dailyWeather.getDate().toString());
                writer.write(",");
                if(dailyWeather instanceof SunnyDay) {
                    writer.write("SUN,");

                    writeTempWind(writer, dailyWeather);

                    writer.write(Integer.toString(((SunnyDay) dailyWeather).getSunHours()));
                    writer.write("h");

                } else {
                    writer.write("RAIN,");

                    writeTempWind(writer, dailyWeather);

                    writer.write(Integer.toString(((RainyDay) dailyWeather).getMillimetersRained()));
                    writer.write("mm");
                }
                writer.write(System.lineSeparator());

            } catch (IOException e) {
                throw new RuntimeException(e);
            } finally { printWriter.flush(); printWriter.close(); }
        }*/
    }

    public void writeTempWind(Writer writer, DailyWeather dailyWeather) throws IOException {
        writer.write(Double.toString(dailyWeather.getTemperature()));
        writer.write("C,");
        writer.write(Integer.toString(dailyWeather.getWindSpeed()));
        writer.write("BFT,");
    }

    /**
     * Gets the list of daily reports.
     *
     * @return The list of daily reports in this weather report
     */
    public List<DailyWeather> getDailyReports() {
        return dailyReports;
    }

}
