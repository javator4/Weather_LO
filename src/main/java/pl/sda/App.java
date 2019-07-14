package pl.sda;

import pl.sda.model.Current;
import pl.sda.model.Location;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //http://api.apixu.com/v1/current.json
        // ?key=d48c0d5e40054b6a9e571834181808&q=Paris

        WeatherService weatherService = new WeatherService(
                "http://api.apixu.com/v1/current.json",
                "d48c0d5e40054b6a9e571834181808"
        );

        Current current = weatherService.getJSONData("Torun").getCityWeather();
        Location location = weatherService.getJSONData("Torun").getLocation();

        System.out.println("LAT: " + location.getLat());
        System.out.println("LON: " + location.getLon());
    }
}
