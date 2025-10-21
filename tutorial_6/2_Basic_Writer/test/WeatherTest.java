import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.StringWriter;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WeatherTest {

    @Test
    public void testSunnyDay() throws IOException {
        StringWriter writer = new StringWriter();
        SunnyDay sunny = new SunnyDay(new Date(1, 9, 2020), 20.1, 2, 10);
        WeatherReport report = new WeatherReport(List.of(sunny));

        report.write(writer);

        assertEquals("1/9/2020,SUN,20.1C,2BFT,10h" + System.lineSeparator(), writer.toString());
    }

    @Test
    public void testCloudyDay() throws IOException {
        StringWriter writer = new StringWriter();
        RainyDay rainy = new RainyDay(new Date(1, 9, 2020), 20.1, 2, 434);
        WeatherReport report = new WeatherReport(List.of(rainy));

        report.write(writer);

        assertEquals("1/9/2020,RAIN,20.1C,2BFT,434mm" + System.lineSeparator(), writer.toString());
    }

    @Test
    public void testWeek() throws IOException {
        StringWriter writer = new StringWriter();
        RainyDay rainyDay = new RainyDay(new Date(1, 9, 2020), 20.1, 2, 23);
        SunnyDay sunnyDay = new SunnyDay(new Date(2, 9, 2020), 20.1, 2, 15);
        SunnyDay sunnyDay2 = new SunnyDay(new Date(3, 9, 2020), 20.1, 2, 15);
        SunnyDay sunnyDay3 = new SunnyDay(new Date(4, 9, 2020), 20.1, 2, 15);
        RainyDay rainyDay2 = new RainyDay(new Date(5, 9, 2020), 20.1, 2, 15);
        RainyDay rainyDay3 = new RainyDay(new Date(6, 9, 2020), 20.1, 2, 15);
        RainyDay rainyDay4 = new RainyDay(new Date(7, 9, 2020), 20.1, 2, 15);

        WeatherReport report = new WeatherReport(List.of(rainyDay, sunnyDay, sunnyDay2,sunnyDay3,rainyDay2,rainyDay3,rainyDay4));

        report.write(writer);

        assertEquals("1/9/2020,RAIN,20.1C,2BFT,23mm" + System.lineSeparator() +
                "2/9/2020,SUN,20.1C,2BFT,15h" + System.lineSeparator() +
                "3/9/2020,SUN,20.1C,2BFT,15h" + System.lineSeparator() +
                "4/9/2020,SUN,20.1C,2BFT,15h" + System.lineSeparator() +
                "5/9/2020,RAIN,20.1C,2BFT,15mm" + System.lineSeparator() +
                "6/9/2020,RAIN,20.1C,2BFT,15mm" + System.lineSeparator() +
                "7/9/2020,RAIN,20.1C,2BFT,15mm" + System.lineSeparator()
                , writer.toString());

    }

}
